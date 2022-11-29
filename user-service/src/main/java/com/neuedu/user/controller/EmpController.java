package com.neuedu.user.controller;

import com.neuedu.api.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    OrderClient orderClient;

    @GetMapping("/emp")
    public void getEmpClient() {
        orderClient.test();
    }

    @GetMapping("/user")
    public String testUserInfo() {
        return "success";
    }
}
