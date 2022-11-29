package com.neuedu.order.service.impl;

import com.neuedu.order.mapper.EmpMapper;
import com.neuedu.order.model.Emp;
import com.neuedu.order.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp queryEmpById(String id) {
        return empMapper.queryEmpById(id);
    }
}
