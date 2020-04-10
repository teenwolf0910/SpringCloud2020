package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.SAAJResult;

/**
 * @Author ljw
 * @create 2020/3/27 11:16
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    private  String getConfigInfo(){
        return  configInfo;
    }
}
