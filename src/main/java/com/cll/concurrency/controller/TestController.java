package com.cll.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenliangliang
 * @date 2018/4/17
 */
@Controller
@Slf4j
public class TestController {

    @ResponseBody
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
