package com.janita.remote.one.service;

import com.alibaba.fastjson.JSON;
import com.janita.remote.one.config.RemoteConfig;
import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.entity.Friend;
import com.janita.remote.one.util.HttpUrlConnectionUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-27 10:28
 */
@Service
public class FriendService {

    public ResultDto getFriend(String friendId) {

//        Map<String,String> map = new HashMap<>();
//        map.put("friendId",friendId);
//        String url = RemoteConfig.getUrl()+"/friend/findOne";
//        String result = HttpUrlConnectionUtil.httpRequestToString(url,RemoteConfig.getGet(),map);
//        System.out.println("*******"+result);
//        return JSON.parseObject(result,ResultDto.class);
        return null;
    }

}
