package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {
    public HelloController() {
        super();
        this.version = "0.0.1";
    }

    private String version;

    @Value("${server.port}")
    private String port;

    /**
     * @return 返回当前版本号
     */
    @RequestMapping("/myVersion")
    public String myVersion(){
        return String.format("Version is %s;",this.version);
    }

    /**
     * @return 返回当前端口号
     */
    @RequestMapping("/myHello")
    public String myHello(){
        return String.format("I am is port:%s",port);
    }

    /**
     * @return 返回测试布尔值
     */
    @RequestMapping(value = "/isGet",method = RequestMethod.GET)
    public boolean isGet(){
        return true;
    }

    /**
     * @param index
     * @return
     */
    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
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
