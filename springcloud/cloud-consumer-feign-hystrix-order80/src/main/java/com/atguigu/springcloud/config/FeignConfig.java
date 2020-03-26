package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ljw
 * @create 2020/3/18 20:50
 */
@Configuration
public class FeignConfig {
 @Bean
    Logger.Level feignLoggerLevel(){
     return  Logger.Level.FULL;
 }
}
