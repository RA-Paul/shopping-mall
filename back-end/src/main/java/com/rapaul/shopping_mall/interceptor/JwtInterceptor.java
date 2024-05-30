package com.rapaul.shopping_mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.rapaul.shopping_mall.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = extractToken(request);
        if (token != null && validateToken(token)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
	}
	
	private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    private boolean validateToken(String token) {
        try {
        	return JwtUtil.validateToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
}
