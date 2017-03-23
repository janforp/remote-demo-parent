package com.janita.remote.one.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-23 09:37
 */
public class HttpUrlConnectionUtil {

    /**
     * <pre>
     * 方法体说明：向远程接口发起请求，返回字符串类型结果
     * @param url 接口地址
     * @param requestMethod 请求方式
     * @param params 传递参数     重点：参数值需要用Base64进行转码
     * @return String 返回结果
     * </pre>
     */
    public static String httpRequestToString(String url, String requestMethod,
                                             Map<String, String> params){

        String result = null;
        try {
            InputStream is = httpRequestToStream(url, requestMethod, params);
            byte[] b = new byte[is.available()];
            is.read(b);
            result = new String(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * <pre>
     * 方法体说明：向远程接口发起请求，返回字节流类型结果
     * 作者：高会于
     * 日期：2015年3月17日 上午11:20:25
     * @param url 接口地址
     * @param requestMethod 请求方式
     * @param params 传递参数     重点：参数值需要用Base64进行转码
     * @return InputStream 返回结果
     * </pre>
     */
    public static InputStream httpRequestToStream(String url, String requestMethod,
                                                  Map<String, String> params){

        InputStream is = null;
        try {
            String parameters = "";
            boolean hasParams = false;
            //将参数集合拼接成特定格式，如name=zhangsan&age=24
            for(String key : params.keySet()){
                String value = URLEncoder.encode(params.get(key), "UTF-8");
                parameters += key +"="+ value +"&";
                hasParams = true;
            }
            if(hasParams){
                parameters = parameters.substring(0, parameters.length()-1);
            }

            //请求方式是否为get
            boolean isGet = "get".equalsIgnoreCase(requestMethod);
            //请求方式是否为post
            boolean isPost = "post".equalsIgnoreCase(requestMethod);
            if(isGet){
                url += "?"+ parameters;
            }

            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();

            //请求的参数类型(使用restlet框架时，为了兼容框架，必须设置Content-Type为“”空)
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //设置连接超时时间
            conn.setConnectTimeout(50000);
            //设置读取返回内容超时时间
            conn.setReadTimeout(50000);
            //设置向HttpURLConnection对象中输出，因为post方式将请求参数放在http正文内，因此需要设置为ture，默认false
            if(isPost){
                conn.setDoOutput(true);
            }
            //设置从HttpURLConnection对象读入，默认为true
            conn.setDoInput(true);
            //设置是否使用缓存，post方式不能使用缓存
            if(isPost){
                conn.setUseCaches(false);
            }
            //设置请求方式，默认为GET
            conn.setRequestMethod(requestMethod);

            //post方式需要将传递的参数输出到conn对象中
            if(isPost){
                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(parameters);
                dos.flush();
                dos.close();
            }

            //从HttpURLConnection对象中读取响应的消息
            //执行该语句时才正式发起请求
            is = conn.getInputStream();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}
