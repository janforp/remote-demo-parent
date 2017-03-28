package com.janita.httpclient;

import com.httpclient.exception.HttpProcessException;
import com.janita.httpclient.bean.User;
import com.janita.httpclient.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Janita on 2017-03-27 20:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpClientApplicationTests {

    private static String HOST = "http://192.168.100.75:9999";
    private static String url = "";

    @Test
    public void testPOST1() throws HttpProcessException {
        url = "/car/findOne";
        Map<String,Object> params = new HashMap<>();
        params.put("carId",1111111);
        System.out.println("*******"+ HttpClientUtils.doHttpPostFetchCookie(HOST+url,params));
   }

   @Test
    public void testPOST2() throws HttpProcessException {
       url = "/user/findOne";
       User user = new User();
       user.setUserId("sdfsdfsdf");
       System.out.println("*******"+HttpClientUtils.doHttpPost(HOST+url,user));
   }

   @Test
   public void testPOST3() throws HttpProcessException {
       url = "/user/saveBatch";
       List<User> list = new ArrayList<>();
       User user1 = new User();
       User user2 = new User();
       user1.setUserId("123123");
       user1.setUsername("user1");
       user2.setUserId("dfsdf");
       user2.setUsername("user2");
       list.add(user1);
       list.add(user2);
       System.out.println("*******"+HttpClientUtils.doHttpPost(HOST+url,list));
   }

   @Test
    public void testGET1() throws HttpProcessException {
        url = "/friend/findOne";
        Map<String,Object> par = new HashMap<>();
        par.put("friendId","sdfsdfsdfsdfs");
        System.out.println("*******"+HttpClientUtils.doHttpGet(HOST+url,par));
   }


}
