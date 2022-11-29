package com.neuedu.order.mapper;

import com.neuedu.order.model.Emp;
import org.springframework.stereotype.Repository;


//@Mapper
@Repository
public interface EmpMapper {

    Emp queryEmpById(String id);
}
