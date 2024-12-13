package com.ymj.webdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PageController {
    @GetMapping("/address/login")
    public String login() {
        return "login";
    }

    @GetMapping("/address")
    public String index() {
        return "address";
    }
}
