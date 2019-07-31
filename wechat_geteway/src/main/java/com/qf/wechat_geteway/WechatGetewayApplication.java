package com.qf.wechat_geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.qf")
public class WechatGetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatGetewayApplication.class, args);
    }

}
