package com.neuedu.his.drug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.neuedu.his.drug.client")
public class DrugApplication {
    public static void main(String[] args) {
        SpringApplication.run(DrugApplication.class,args);
    }
}
