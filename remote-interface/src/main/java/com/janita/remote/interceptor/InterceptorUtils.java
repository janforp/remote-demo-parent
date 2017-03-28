package com.janita.remote.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Janita on 2017-03-28 13:10
 */
public class InterceptorUtils {

    private static Logger httpHeaderLogger = LoggerFactory.getLogger(InterceptorUtils.class);

    /**
     * 在控制台及log上打印出请求头中的键值对
     */
    public static void printRequestHeaders(HttpServletRequest request){
        String requestUri = request.getRequestURI();
        Enumeration<String> headers = request.getHeaderNames();
        Map<String, String> requestHeader = new HashMap<String, String>();
        if (headers != null) {
            while (headers.hasMoreElements()) {
                String name = headers.nextElement();
                List<String> headerValueList = new ArrayList<>(3);
                Enumeration<String> headerValues = request.getHeaders(name);
                if (headerValues != null) {
                    while (headerValues.hasMoreElements()) {
                        headerValueList.add(headerValues.nextElement());
                    }
                }
                requestHeader.put(name, headerValuesToString(headerValueList));
            }
        }
        if (httpHeaderLogger.isInfoEnabled()) {
            httpHeaderLogger.info(requestUri + " - requestHeader: \n" + requestHeader);
        }
    }

    /**
     * 在控制台及log上打印出请求头中的所有的cookie的键值对
     * @param request
     */
    public static void printCookies(HttpServletRequest request){
        String requestUri = request.getRequestURI();
        Cookie[] cookies = request.getCookies();
        Map<String ,String> cookieMap = null;
        if (cookies != null && cookies.length > 0) {
            cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                cookieMap.put(cookieName,cookieValue);
            }
        }
        if (httpHeaderLogger.isInfoEnabled()) {
            httpHeaderLogger.info(requestUri + " - cookies: \n" + cookieMap);
        }
    }

    public static String headerValuesToString(Collection<String> values) {
        if (values == null || values.size() == 0) {
            return "";
        }
        StringBuilder buf = new StringBuilder();
        int i = 0;
        for (String value : values) {
            if (i > 0) {
                buf.append(", ");
            }
            buf.append(value);
            i++;
        }
        return buf.toString();
    }
}
