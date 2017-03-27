package com.janita.remote.one.service;

import com.alibaba.fastjson.JSON;
import com.janita.remote.one.config.RemoteConfig;
import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.util.HttpUrlConnectionUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-27 10:34
 */
@Service
public class POSTUserService {

    public ResultDto postUser(String userId){

//        Map<String,String> map = new HashMap<>();
//        map.put("userId",userId);
//        String url = RemoteConfig.getUrl()+"/user/findOne";
//        String result = HttpUrlConnectionUtil.httpRequestToString(url,RemoteConfig.getPost(),map);
//        System.out.println("*******"+result);
//        return JSON.parseObject(result,ResultDto.class);
        return null;
    }
}
