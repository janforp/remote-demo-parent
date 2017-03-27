package com.janita.remote.controller;

import com.janita.remote.bean.User;
import com.janita.remote.constant.ResultDto;
import com.janita.remote.constant.ResultDtoFactory;
import com.janita.remote.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-27 10:07
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "POST，接口参数为对象，提供远程调用的接口")
public class PostPojoUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    @ApiOperation(value = "POST请求：根据id查询用户")
    public ResultDto findUserById(@RequestBody User user){
        String userId = user.getUserId();
        return ResultDtoFactory.toSuccess(userService.findOne(userId));
    }
}
