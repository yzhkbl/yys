package com.jeethink.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yys")
public class YysController {

    @RequestMapping("/find")
    public Integer find(Integer id){
        int count = id;
        return count;
    }
}
