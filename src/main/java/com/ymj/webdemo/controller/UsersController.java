package com.ymj.webdemo.controller;

import com.ymj.webdemo.pojo.DTO.UpdateUserRequest;
import com.ymj.webdemo.pojo.Result;
import com.ymj.webdemo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("/address/users/update")
    public Result updateUserInfo(@RequestBody UpdateUserRequest updateUserRequest) {
        usersService.updateUser(updateUserRequest.getUser());
        return Result.success();
    }
}
