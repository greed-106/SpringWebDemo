package com.ymj.webdemo.controller;


import com.ymj.webdemo.pojo.DTO.LoginRequest;
import com.ymj.webdemo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class LoginController {

    @PostMapping("/address/login")
    public Result login(@RequestBody LoginRequest loginReq) {
        log.info(loginReq.toString());
        return Result.success();
    }
}
