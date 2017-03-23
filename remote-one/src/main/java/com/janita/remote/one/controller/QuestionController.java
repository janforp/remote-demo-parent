package com.janita.remote.one.controller;

import com.janita.remote.one.constant.ResultDto;
import com.janita.remote.one.constant.ResultDtoFactory;
import com.janita.remote.one.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-23 09:55
 */
@RestController
@RequestMapping(value = "/question",method = RequestMethod.POST)
@Api(description = "题目API")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/findOne")
    @ApiOperation(value = "根据id查询题目")
    public ResultDto findQuestionById(String questionId){
        return questionService.findOne(questionId);
    }

}
