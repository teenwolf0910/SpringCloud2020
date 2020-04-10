package org.atguigu.springcloud.controller;

import org.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ljw
 * @create 2020/3/28 12:01
 */
@RestController
public class SendMessagecontroller {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public  String sendMessage(){
        return  iMessageProvider.send();
    }
}
