package com.neuedu.his.drug.client;

import com.neuedu.his.drug.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "menzhen", configuration = FeignConfig.class)
public interface EmpClient {

    @GetMapping("/test")
    public void test();

}
