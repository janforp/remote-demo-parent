package com.janita.remote.two;

import com.janita.remote.two.util.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-27 14:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RemoteTwoApplicationTests {

    private static String HOST = "http://118.178.138.136:8080/account/v1/users/get_token";
    String username = "01010072llnt";
    String password = "49ba59abbe56e057";


    @Test
    public void test(){
        Map<String,String> map = new HashMap<>();

        map.put("username",username);
        map.put("password",password);

        String re = HttpClientUtil.httpRequestToString(HOST,"post",map);
        System.out.println("*******"+re);
    }
}
