package com.neuedu.his.drug.controller;

import com.neuedu.his.drug.client.EmpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    EmpClient empClient;

    @GetMapping("/emp")
    public void getEmpClient() {
        empClient.test();
    }
}
