package com.baoyi.springbootdemo.controller;

import com.baoyi.springbootdemo.annotation.UserModel;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "测试功能", description = "测试功能")
public class HelloWorldController {

    @GetMapping("/sayHello")
    private String sayHello(@ApiIgnore @UserModel com.baoyi.springbootdemo.model.UserModel useModel) {

        return useModel.toString();
    }
}
