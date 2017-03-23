package com.janita.remote.two.service;

import com.alibaba.fastjson.JSON;
import com.janita.remote.two.config.RemoteConfig;
import com.janita.remote.two.constant.ResultDto;
import com.janita.remote.two.util.HttpClientUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-23 09:56
 */
@Service
public class QuestionService {

    public ResultDto findOne(String questionId) {
        Map<String,String> map = new HashMap<>();
        String url = RemoteConfig.getUrl()+"/question/findOne?id="+questionId;
        String result = HttpClientUtil.httpRequestToString(url,RemoteConfig.getPost(),map);
        System.out.println("*******"+result);
        return JSON.parseObject(result,ResultDto.class);
    }
}
