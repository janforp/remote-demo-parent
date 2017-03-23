package com.janita.remote.one.service;

import com.alibaba.fastjson.JSON;
import com.janita.remote.one.config.RemoteConfig;
import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.util.HttpUrlConnectionUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-23 09:56
 */
@Service
public class QuestionService {

    /**
     * 这里有个问题：就是只能调用别人的Controller接口，
     * 我们肯定只想调用他们的Service接口，因为Service返回的只是Question，
     * 而controller返回的是被封装了一层的实体类
     * @param questionId
     * @return
     */
    public ResultDto findOne(String questionId) {
        Map<String,String> map = new HashMap<>();
        map.put("id",questionId);
        String url = RemoteConfig.getUrl()+"/question/findOne?id="+questionId;
        String result = HttpUrlConnectionUtil.httpRequestToString(url,RemoteConfig.getPost(),map);
        System.out.println("*******"+result);
        return JSON.parseObject(result,ResultDto.class);
    }
}
