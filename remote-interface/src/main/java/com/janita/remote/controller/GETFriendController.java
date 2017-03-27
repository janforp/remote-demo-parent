package com.janita.remote.controller;

import com.janita.remote.constant.ResultDto;
import com.janita.remote.constant.ResultDtoFactory;
import com.janita.remote.service.IFriendService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-27 10:17
 */
@RestController
@RequestMapping("/friend")
@Api(description = "GET请求远程调用接口")
public class GETFriendController {

    @Autowired
    IFriendService friendService;

    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public ResultDto getFriend(String friendId){
        return ResultDtoFactory.toSuccess(friendService.findFriendById(friendId));
    }
}