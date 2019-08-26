package com.jarvis.hello.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable String message) {
        return "provider提供者输出信息，你输入的信息为：" + message + "，我的端口是：" + port;
    }

    /**
     * 注入配置文件上下文
     */
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    /**
     * 从上下文中读取配置
     * @return
     */
    @GetMapping(value = "/hi")
    public String sayHi() {
        return "读取配置： " + applicationContext.getEnvironment().getProperty("user.name");
    }
}