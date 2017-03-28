package com.janita.httpclient.utils;

import com.alibaba.fastjson.JSON;
import com.httpclient.HttpClientUtil;
import com.httpclient.builder.HCB;
import com.httpclient.common.HttpConfig;
import com.httpclient.common.HttpHeader;
import com.httpclient.common.SSLs;
import com.httpclient.exception.HttpProcessException;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.HttpContext;

import java.util.Map;

/**
 * Created by Janita on 2017-03-27 20:38
 */
public class HttpClientUtils {

    private static HttpClient client4HTTP;
    private static HttpClient client4HTTPS;
    private static HttpContext httpContext;
    private static String ENCODING = "UTF-8";
    private static Header[] headers;
    private static HCB hcb;

    static {
        try {
            //插件式配置生成HttpClient时所需参数（超时、连接池、ssl、重试）
            hcb = HCB.custom()
                    .timeout(5000) 		//超时
                    .pool(100, 10)    	//启用连接池，每个路由最大创建10个链接，总连接数限制为100个
                    .sslpv(SSLs.SSLProtocolVersion.TLSv1_2) 	//可设置ssl版本号，默认SSLv3，用于ssl，也可以调用sslpv("TLSv1.2")
                    .ssl()  			   		//https，支持自定义ssl证书路径和密码，ssl(String keyStorePath, String keyStorepass)
                    .retry(5);//重试5次

            client4HTTP =hcb.build();
            client4HTTPS = hcb.build();

            httpContext = null ;
            //自定义的请求头，可以传自己定义的参数如token
            headers = HttpHeader.custom().userAgent("userAgent").other("customer", "custom").build();
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
    }

    /**
     * POST请求
     * @param url           请求路径
     * @param parameters    参数
     * @return
     */
    public static String doHttpPost(String url, Map<String ,Object> parameters) throws HttpProcessException {
        return HttpClientUtil.post(HttpConfig.custom().client(client4HTTP).url(url).headers(headers).map(parameters).context(httpContext).encoding(ENCODING));
    }

    /**
     * 请求之后会获取页面上的cookie
     * 并且之后可以一直带着此cookie
     * @param url           请求路径
     * @param parameters    参数
     * @return
     * @throws HttpProcessException
     */
    public static String doHttpPostFetchCookie(String url, Map<String,Object> parameters) throws HttpProcessException {
        //定义cookie存储
        HttpClientContext context = new HttpClientContext();
        CookieStore cookieStore = new BasicCookieStore();
        context.setCookieStore(cookieStore);
        String result = HttpClientUtil.post(HttpConfig.custom().client(client4HTTP).url(url).headers(headers).map(parameters).context(context).encoding(ENCODING));

        //理论上上一次请求之后服务器设置的cookie会在此对象中
        cookieStore = context.getCookieStore();
        for (Cookie cookie : cookieStore.getCookies()) {
            System.out.println(cookie.getName()+"--"+cookie.getValue());
        }
        return result;
    }

    /**
     * POST请求
     * @param url   请求路径
     * @param t
     * @param <T>   body体中传的json字符串的对象
     * @return
     */
    public static <T> String doHttpPost(String url, T t) throws HttpProcessException {
        headers = HttpHeader.custom().userAgent("userAgent").other("Content-type", "application/json; charset=utf-8").other("Accept","application/json").build();
        String json = JSON.toJSONString(t);
        return HttpClientUtil.post(HttpConfig.custom().client(client4HTTP).url(url).headers(headers).json(json).context(httpContext).encoding(ENCODING));
    }

    /**
     * GET请求
     * @param url           请求参数
     * @param parameters    url上面的参数
     * @return
     */
    public static String doHttpGet(String url, Map<String,Object> parameters) throws HttpProcessException {
        return HttpClientUtil.get(HttpConfig.custom().client(client4HTTP).url(url).headers(headers).map(parameters).context(httpContext).encoding(ENCODING));
    }
}
