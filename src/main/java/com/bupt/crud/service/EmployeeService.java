package com.bupt.crud.service;

import com.bupt.crud.entities.Employee;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    public Employee getEmpById(Integer id);

    public Employee getEmpbyName(String username);
}
