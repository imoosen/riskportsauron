package com.allinpay.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by mengsen on 2017/8/17.
 *
 * @Description: [这是一个入口]
 * @UpdateUser: mengsen on 2017/8/17.
 */

@SpringBootApplication
@EnableAsync
public class KafkaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaClientApplication.class, args);
    }
}
