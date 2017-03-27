package com.janita.remote.one.controller;

import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.service.POSTUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-27 10:33
 */
@RestController
@RequestMapping("/user")
@Api(description = "POST方法远程调用")
public class UserPOSTController {

    @Autowired
    private POSTUserService postUserService;

    @RequestMapping(value = "/postUser",method = RequestMethod.GET)
    @ApiOperation(value = "POST请求远程调用接口，获取User")
    public ResultDto postUserById(String userId){
        return postUserService.postUser(userId);
    }
}
