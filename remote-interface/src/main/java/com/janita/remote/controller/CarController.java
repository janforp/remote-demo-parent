package com.janita.remote.controller;

import com.janita.remote.bean.Car;
import com.janita.remote.constant.ResultDto;
import com.janita.remote.constant.ResultDtoFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-27 10:53
 */
@RestController
@RequestMapping("/car")
@Api(description = "POST请求，但是参数不在对象中，直接接受")
public class CarController {
    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    @ApiOperation(value = "POST直接传参的接口")
    public ResultDto findCar(String carId){
        Car car = new Car();
        car.setCarId(Integer.valueOf(carId));
        car.setCarName("POST直接传参的Car");
        return ResultDtoFactory.toSuccess(car);
    }
}
