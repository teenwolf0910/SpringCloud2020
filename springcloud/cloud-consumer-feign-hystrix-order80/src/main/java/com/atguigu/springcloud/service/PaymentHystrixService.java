package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.awt.SunHints;

/**
 * @Author ljw
 * @create 2020/3/25 11:25
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id);



    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
