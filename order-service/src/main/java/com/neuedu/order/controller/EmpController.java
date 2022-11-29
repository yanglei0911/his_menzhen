package com.neuedu.order.controller;

import com.neuedu.order.model.Emp;
import com.neuedu.order.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/test")
    public String test(){
        System.out.println("调用门诊模块成功");
        return "TEST";
    };

    @PostMapping("/emp/queryEmpById")
    public Emp queryEmpInfoById(@RequestBody Emp emps){
        System.out.println(emps.getId());
        Emp emp = empService.queryEmpById(emps.getId());
        System.out.println("EMP:"+emp);
        return emp;
    };

}
