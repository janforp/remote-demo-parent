package com.janita.remote.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Janita on 2017-03-27 10:39
 */
public class MyInterceptor implements HandlerInterceptor {

    private static Logger httpHeaderLogger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

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
//        logger.setRequestHeader(requestHeader);
        if (httpHeaderLogger.isInfoEnabled()) {
            httpHeaderLogger.info(requestUri + " 他的- requestHeader: \n" + requestHeader);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }


    private static String headerValuesToString(Collection<String> values) {
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
