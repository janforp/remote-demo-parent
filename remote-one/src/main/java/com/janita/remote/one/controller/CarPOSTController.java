package com.janita.remote.one.controller;

import com.alibaba.fastjson.JSON;
import com.janita.remote.one.config.RemoteConfig;
import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.util.HttpUrlConnectionUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Janita on 2017-03-27 10:57
 */
@RestController
@RequestMapping(value = "/car")
public class CarPOSTController {

    @RequestMapping(value = "/postCar",method = RequestMethod.GET)
    @ApiOperation(value = "postCar")
    public ResultDto findCar(String carId){

        Map<String,String> map = new HashMap<>();
        map.put("carId",carId);
        String url = RemoteConfig.getUrl()+"/car/findOne";
        String result = HttpUrlConnectionUtil.httpRequestToString(url,RemoteConfig.getPost(),map);
        System.out.println("*******"+result);
        return JSON.parseObject(result,ResultDto.class);
    }
}
