package com.ymj.webdemo.controller;

import com.ymj.webdemo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ContactsController {
    @GetMapping("/address/contacts/{username}")
    public Result getAllContacts() {

        return Result.success();
    }
}
