package com.rapaul.shopping_mall.interceptor;

import java.util.Enumeration;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.owasp.encoder.Encode;

public class ParameterEscapeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            if (parameterValue != null) {
                String escapedValue = Encode.forHtml(parameterValue);
                escapedValue = Encode.forJavaScript(escapedValue);
                escapedValue = Encode.forJava(escapedValue);
                request.setAttribute(parameterName, escapedValue);
            }
        }
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
