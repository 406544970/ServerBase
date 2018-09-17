package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
    @RequestMapping("/hello2")
    public String hello2(int index){
        Integer myIndex = new Integer(index);
        if (myIndex == null)
             index = 0;
        int counter = 9;
        counter ++;
        counter += index;
        return String.format("Counter:[%d]",counter);
    }
}
