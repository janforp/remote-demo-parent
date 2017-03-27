package com.janita.remote.one.controller;

import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.service.FriendService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-27 10:26
 */
@RestController
@RequestMapping("/friend")
@Api(description = "远程调用friend接口")
public class FriendGETController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/getFriend",method = RequestMethod.GET)
    public ResultDto getFriend(String friendId){
        return friendService.getFriend(friendId);
    }
}
