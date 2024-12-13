package com.ymj.webdemo.controller;


import com.ymj.webdemo.pojo.DTO.LoginRequest;
import com.ymj.webdemo.pojo.DTO.RegisterRequest;
import com.ymj.webdemo.pojo.Result;
import com.ymj.webdemo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class LoginController {
    @Autowired
    UsersService usersService;

    @PostMapping("/address/login")
    public Result login(@RequestBody LoginRequest loginReq) {
        usersService.verifyLogin(loginReq.getUser());
        return Result.success();
    }

    @PostMapping("/address/register")
    public Result register(@RequestBody RegisterRequest registerRequest) {
        usersService.verifyRegister(registerRequest.getUser());
        usersService.insertUser(registerRequest.getUser());
        return Result.success();
    }
}
