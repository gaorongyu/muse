package com.fngry.muse.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaorongyu
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("hello")
    public String hello(@RequestParam("userName") String userName) {
        return "hello " + userName;
    }

}
