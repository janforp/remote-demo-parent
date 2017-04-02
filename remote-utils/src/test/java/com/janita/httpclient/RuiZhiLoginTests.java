package com.janita.httpclient;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.httpclient.exception.HttpProcessException;
import com.janita.httpclient.bean.RuizhiLogin;
import com.janita.httpclient.bean.User;
import com.janita.httpclient.utils.HttpClientUtils;
import com.janita.httpclient.utils.MD5Utils;
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
public class RuiZhiLoginTests {

    private static String HOST = "http://118.178.138.136:8080/account/v1/users/get_token";

    @Test
    public void testLogin() throws HttpProcessException {

        String username = "01010072llnt";
        String password = "49ba59abbe56e057";
        Map<String,Object> map = new HashMap<>();

        map.put("username",username);
        map.put("password",password);
        String result = HttpClientUtils.doHttpPost(HOST,map);
        RuizhiLogin ruizhiLogin = JSON.parseObject(result,RuizhiLogin.class);
        System.out.println("*******"+ruizhiLogin);
    }
}