package com.semi_semi_backend11.semisemi.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class BlockPathInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();

        if (uri.startsWith("/images/test/cutecat")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 금지된 경로입니다.");
            return false;
        }

        return true;
    }
}
