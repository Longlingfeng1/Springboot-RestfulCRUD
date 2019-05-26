package com.bupt.crud.controller;

import com.bupt.crud.entities.Department;
import com.bupt.crud.entities.Employee;
import com.bupt.crud.mapper.DepartmentMapper;
import com.bupt.crud.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @RequestMapping("/dept/{id}")
    public Department queryDeptById(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @RequestMapping("/dept")
    public Department addDept(Department department){
        departmentMapper.addDept(department);
        return department;
    }

    @RequestMapping("/emp2/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

}
