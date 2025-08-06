package com.ditroauth.distroauth.keyfilter;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.servlet.http.HttpServletRequest;

public class AuthService {

    private static final String API_AUTH = "ApiKeyAuth"; // here where you can set the secret key for the API,
    // for now i kept it like this 

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader("Authorization");
        if (apiKey == null || !apiKey.equals(API_AUTH)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    } 

    
}
