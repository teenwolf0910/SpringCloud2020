package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ljw
 * @create 2020/3/11 15:54
 */
public interface PaymentService {
    public  int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}
