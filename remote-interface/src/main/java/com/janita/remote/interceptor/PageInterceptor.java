package com.janita.remote.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Janita on 2017-03-27 10:39
 */
public class PageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //打印请求头
        InterceptorUtils.printRequestHeaders(request);
        //打印cookie
        InterceptorUtils.printCookies(request);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        Cookie cookie = new Cookie("cookie","cookieValue");
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        cookie.setHttpOnly(false);
        cookie.setDomain("*");
        cookie.setSecure(true);
        response.addCookie(cookie);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
    }

}
