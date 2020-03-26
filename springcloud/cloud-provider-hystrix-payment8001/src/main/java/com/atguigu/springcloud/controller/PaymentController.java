package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ljw
 * @create 2020/3/20 11:32
 */
@RestController

public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private  String serverPort;


    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result=paymentService.paymentInfo_Ok(id );
        return  result;
    }


    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        String result=paymentService.paymentInfo_TimeOut(id );
        return  result;
    }





    //熔断
    @GetMapping("/payment/circuit/{id}")
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result=paymentService.paymentCircuitBreaker(id);
        return result;
    }

}
