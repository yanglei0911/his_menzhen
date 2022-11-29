package com.neuedu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order-service")
public interface OrderClient {

    // user模块 调用 order模块
    @GetMapping("/test")
    public void test();
}
