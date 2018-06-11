package com.example.jwt.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JwtAccessDeniedHandler
 *
 * @author lijiehua
 * @date 2018-06-11
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * 拒绝访问(权限不够)
     *
     * @param request
     * @param response
     * @param accessDeniedException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(403);
    }

}