package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ljw
 * @create 2020/3/27 21:20
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    private  String getConfigInfo(){
        System.out.println(configInfo);
        return  configInfo;
    }
}
