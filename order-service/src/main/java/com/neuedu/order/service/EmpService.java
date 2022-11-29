package com.neuedu.order.service;

import com.neuedu.order.model.Emp;


public interface EmpService {
    /**
     * 根据ID查询EMP信息
     * @param id
     * @return
     */
    Emp queryEmpById(String id);
}
