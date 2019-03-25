package com.example.web;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.netflix.discovery.DiscoveryManager.*;


/**
 *
 */
@RestController
@SpringBootApplication
@EnableEurekaClient
public class HelloController {
    public HelloController() {
        super();
        this.version = "0.0.1";
    }

//    @Value("${liangHaoSign}")
//    private String liangHaoSign;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/upLine", method = RequestMethod.GET)
    public String index() {
        java.util.List<ServiceInstance> instances = client.getInstances("hello-service");
        return "Hello World";
    }

    private String version;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String springApplicationName;

//    @PostMapping("/liangHaoSign")
//    public String getLiangHaoSign() {
//        return this.liangHaoSign;
//    }

    /**
     * @return 返回当前版本号
     */
    @RequestMapping("/myVersion")
    public String myVersion() {
        return String.format("Version is %s;", this.version);

    }

    /**
     * @return 返回当前端口号
     */
    @RequestMapping("/myPort")
    public String myPort() {
        return String.format("I am is port:%s", port);
    }

    /**
     * @return 返回测试布尔值
     */
    @RequestMapping(value = "/isGet", method = RequestMethod.GET)
    public boolean isGet() {
        return true;
    }

    /**
     * @param index
     * @return
     */
    @RequestMapping(value = "/hello2", method = RequestMethod.POST)
    public String hello2(int index) {

        Integer myIndex = new Integer(index);
        if (myIndex == null)
            index = 0;
        int counter = 9;
        counter++;
        counter += index;
        return String.format("Counter:[%d]", counter);

    }

    @RequestMapping(value = "/downLine", method = RequestMethod.GET)
    public String downLine() {
        getInstance().shutdownComponent();
        return String.format("ApplicationName\"%s\"(Port:%s) is downLine.", this.springApplicationName, this.port);
    }

}
