package com.bupt.crud.service.impl;

import com.bupt.crud.entities.Employee;
import com.bupt.crud.mapper.EmployeeMapper;
import com.bupt.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee getEmpById(Integer id) {
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    @Override
    public Employee getEmpbyName(String username) {
        Employee employee = employeeMapper.getEmpByName(username);
        return employee;
    }

}
