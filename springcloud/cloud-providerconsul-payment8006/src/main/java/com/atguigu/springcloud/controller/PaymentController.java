package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author ljw
 * @create 2020/3/17 14:22
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping(value = "/payment/consul")
    public  String paymentzk(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
