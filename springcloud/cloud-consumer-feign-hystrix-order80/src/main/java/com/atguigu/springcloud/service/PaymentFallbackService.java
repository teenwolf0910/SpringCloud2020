package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author ljw
 * @create 2020/3/25 15:44
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----------PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
