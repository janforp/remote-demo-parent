package com.janita.remote.rmi.controller;

import com.janita.remote.rmi.constant.ResultDto;
import com.janita.remote.rmi.constant.ResultDtoFactory;
import com.janita.remote.rmi.service.RMIQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-23 11:14
 */
@RequestMapping("/question")
@RestController
@Api(description = "RMI远程调用方法")
public class RMIQuestionController {

    @Autowired
    private RMIQuestionService rmiQuestionService;

    @PostMapping("/findOne")
    @ApiOperation(value = "根据题目id查询")
    public ResultDto findOne(String questionId){
        return ResultDtoFactory.toSuccess(rmiQuestionService.findOne(questionId));
    }
}
