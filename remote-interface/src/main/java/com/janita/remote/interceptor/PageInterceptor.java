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

    private static Integer ONE_HOUR =  60*60;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //打印请求头
        InterceptorUtils.printRequestHeaders(request);
        //在此处可以根据具体的业务添加多个cookie到前端
        InterceptorUtils.setCookie(request,response,"X-access-token", UUID.randomUUID().toString(),ONE_HOUR);
        InterceptorUtils.setCookie(request,response,"CookTwo","CookTwoValue",ONE_HOUR);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        InterceptorUtils.printCookies(request);
    }

}
