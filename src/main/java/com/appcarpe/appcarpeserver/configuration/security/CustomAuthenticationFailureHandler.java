package com.appcarpe.appcarpeserver.configuration.security;

import com.appcarpe.appcarpeserver.error.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            String error = "L'adresse email ou le mot de passe est incorrect";
            ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, exception.getLocalizedMessage(), error);
            ObjectMapper mapper = new ObjectMapper();
            response.getOutputStream().println(mapper.writeValueAsString(apiError));
        } else {
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}
