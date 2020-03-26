package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author ljw
 * @create 2020/3/20 11:17
 */
@Service
public class PaymentService {

    public String paymentInfo_Ok(Integer id){
        return "线程池: "+Thread.currentThread().getName()+"paymentinfo_Ok,id: "+id;
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    } )
    public  String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "线程池："+Thread.currentThread().getName()+"paymentInfo_ok,id:"+id+"\t"+"hah";
    }



    public String paymentInfo_TimeOutHandler(Integer id){
        return  "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id:"+id+"\t"+"5555555555";
    }



    //==========服务熔断
@HystrixCommand(fallbackMethod ="paymentCircuitBreaker_fallback",commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
})
    public  String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("************id 不能为负数");
        }
        String serialNumber= UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public  String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return  "id 不能为负数，请稍后再试 id:"+id;
    }
}
