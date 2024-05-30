package com.rapaul.shopping_mall.util;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JwtUtil {
	
    private static final String SECRET_KEY = "wU1IfuSZzSWJRsciIYarIGvuBuzi3DCSKA0tTFbYdkm8xC4doBsCwfMSfKSWWQiP";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    public static String generateToken(String name , Integer id) {

        String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String base64Header = Base64.getUrlEncoder().encodeToString(header.getBytes());

	    long currentTimeMillis = System.currentTimeMillis();
	    long expirationTimeMillis = currentTimeMillis + EXPIRATION_TIME;
	    String payload = "{\"sub\":\"" + name + "\",\"id\":" + id + "\",\"exp\":" + expirationTimeMillis + "}";
	    String base64Payload = Base64.getUrlEncoder().encodeToString(payload.getBytes());
	
	    String signature = generateSignature(base64Header + "." + base64Payload, SECRET_KEY);
	
	    return base64Header + "." + base64Payload + "." + signature;
	}
    
    public static boolean validateToken(String token) {
        try {
            String[] parts = token.split("\\.");
            String header = parts[0];
            String payload = parts[1];
            String signature = parts[2];

            String calculatedSignature = generateSignature(header + "." + payload, SECRET_KEY);
            if (!calculatedSignature.equals(signature)) {
                return false; 
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }

	private static String generateSignature(String data, String secretKey) {
	    try {
	        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
	        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
	        sha256Hmac.init(secretKeySpec);
	        byte[] signatureBytes = sha256Hmac.doFinal(data.getBytes());
	        return Base64.getUrlEncoder().encodeToString(signatureBytes);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}