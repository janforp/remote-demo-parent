package com.janita.remote.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by Janita on 2017-03-27 10:39
 */
public class PageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //打印请求头
        InterceptorUtils.printRequestHeaders(request);

        Cookie cookie = new Cookie("cookie","cookieValue");
        cookie.setMaxAge(60*60);
        cookie.setPath(request.getContextPath());
        cookie.setSecure(true);
        response.addCookie(cookie);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        InterceptorUtils.setCookie(request,response,"X-access-token", UUID.randomUUID().toString(),60*60);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        InterceptorUtils.printCookies(request);
    }

}
