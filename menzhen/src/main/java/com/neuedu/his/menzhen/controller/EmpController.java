package com.neuedu.his.menzhen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @GetMapping("/test")
    public void test(){
        System.out.println("调用门诊模块成功");
    };
}
