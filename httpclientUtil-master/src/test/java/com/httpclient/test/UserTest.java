package com.httpclient.test;

import com.httpclient.HttpClientUtil;
import com.httpclient.common.HttpConfig;
import com.httpclient.common.HttpHeader;
import com.httpclient.exception.HttpProcessException;
import org.apache.http.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-27 14:22
 */
public class UserTest {

    public static void main(String[] args) throws HttpProcessException {

        String url = "http://192.168.100.75:9999/user/findOne";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key2", "value2");

        //插件式配置Header（各种header信息、自定义header）
        Header[] headers 	= HttpHeader.custom()
                .userAgent("javacl")
                .other("customer", "自定义")
                .build();

        HttpConfig config = HttpConfig.custom()
                .headers(headers)	//设置headers，不需要时则无需设置
                .url(url)					//设置请求的url
                .map(map)			//设置请求参数，没有则无需设置
                .encoding("utf-8"); //设置请求和返回编码，默认就是Charset.defaultCharset()

        String result = HttpClientUtil.post(config);	//post请求

        System.out.println("*******"+result);
    }
}
