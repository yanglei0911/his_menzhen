package com.neuedu.user.controller;

import com.neuedu.api.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    OrderClient orderClient;

    @GetMapping("/emp")
    public void getEmpClient(@RequestHeader(value = "truch", required = false) String truch) {
        System.out.println(">>>>>>>>>trch:" + truch);
        orderClient.test();
    }

    @GetMapping("/user")
    public String testUserInfo() {
        return "success";
    }
}
