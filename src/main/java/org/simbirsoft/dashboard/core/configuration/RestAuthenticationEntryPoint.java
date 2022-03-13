package org.simbirsoft.dashboard.core.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.simbirsoft.dashboard.core.entity.ErrorInfo;
import org.simbirsoft.dashboard.core.exeprion.ErrorCodes;
import org.simbirsoft.dashboard.core.exeprion.JwtAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        String errorCode = ErrorCodes.AUTHENTICATION_GLOBAL_ERROR;
        if (authException.getClass().equals(BadCredentialsException.class)) {
            errorCode = ErrorCodes.AUTHENTICATION_BAD_CREDENTIALS_ERROR;
        }
        if (authException.getClass().equals(JwtAuthenticationException.class)) {
            errorCode = ErrorCodes.AUTHENTICATION_JWT_TOKEN_INVALID;
        }

        ErrorInfo errorInfo = new ErrorInfo(errorCode, authException.getMessage());

        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getOutputStream().println(errorInfoToJson(errorInfo));
    }

    protected String errorInfoToJson(ErrorInfo errorInfo) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(errorInfo);
    }
}
