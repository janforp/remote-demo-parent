package com.janita.remote.one;

import com.alibaba.fastjson.JSON;
import com.httpclient.HttpClientUtil;
import com.httpclient.builder.HCB;
import com.httpclient.common.HttpConfig;
import com.httpclient.common.HttpHeader;
import com.httpclient.exception.HttpProcessException;
import com.janita.remote.one.entity.User;
import org.apache.http.Header;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-23 09:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RemoteOneApplicationTests {


    /**
     * post请求：但是是直接传参，参数不在对象中
     */
    private static String POST_CAR = "http://192.168.100.75:9999/car/findOne";

    @Test
    public void testPOSTCar() throws HttpProcessException {
        Map<String,Object> map = new HashMap<>();
        map.put("carId","123123");
        System.out.println("*******"+ HttpClientUtil.post(HCB.custom().build(),POST_CAR,null,map,null,"utf-8"));
    }

    /**
     * GET请求
     */
    private static String GET_FRIEND =  "http://192.168.100.75:9999/friend/findOne?friendId=444444";

    @Test
    public void testGETFriend() throws HttpProcessException {
        System.out.println("*******"+HttpClientUtil.get(HCB.custom().build(),GET_FRIEND,null,null,"utf-8"));
    }

    /**
     * POST请求，但是远程的controller是用对象接收的
     */
    private static String POST_USER = "http://192.168.100.75:9999/user/findOne";
    @Test
    public void testPostPojoUser() throws HttpProcessException {

        //插件式配置Header（各种header信息、自定义header）
        Header[] headers 	= HttpHeader.custom()
                .userAgent("javacl")
                .other("customer", "自定义")
                .other("Accept","application/json")
                .other("Content-Type"," application/json")
                .build();


        Map<String,Object> map = new HashMap<>();
        map.put("userId","123123");
        System.out.println("*******"+ HttpClientUtil.post(HCB.custom().build(),POST_USER,headers,map,null,"utf-8"));
    }

    @Test
    public void testPOSTPOJO() throws HttpProcessException {
        String url = "http://192.168.100.75:9999/user/findOne";
        User user = new User();
        user.setUserId("12222");

        Header[] headers 	= HttpHeader.custom()
                .userAgent("javacl")
                .other("customer", "self")
                .other("Accept","application/json")
                .other("Content-Type"," application/json")
                .other("token","12313123123123")
                .other("host","host")
                .build();

        String result  = HttpClientUtil.post(HttpConfig.custom().client(HCB.custom().build()).url(url).headers(headers).map(null).context(null).encoding("UTF-8").json(JSON.toJSONString(user)));
        System.out.println("*******"+result);
    }
}