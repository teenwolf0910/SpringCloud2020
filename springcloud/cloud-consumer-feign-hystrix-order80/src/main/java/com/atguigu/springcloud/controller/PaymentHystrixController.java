package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author ljw
 * @create 2020/3/25 11:27
 */
@RestController
@DefaultProperties(defaultFallback = "payment_global_FallbackMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id)
    {
                String result=paymentHystrixService.paymentInfo_OK(id);
                return  result;
    }



    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//        @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties ={
//            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    } )
    @HystrixCommand
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        String result=paymentHystrixService.paymentInfo_TimeOut(id);
        return  result;
    }

    public String paymentTimeOutFallbackMethod(Integer id){
        return  "我是消费者80，支付系统繁忙请稍后再试";
    }


    //下面是全局fallback方法
    public  String payment_global_FallbackMethod(){
        return "信息处理异常，请稍后再试";
    }
}
