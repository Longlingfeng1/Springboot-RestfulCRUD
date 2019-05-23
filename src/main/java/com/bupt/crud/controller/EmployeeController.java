package com.bupt.crud.controller;

import com.bupt.crud.dao.DepartmentDao;
import com.bupt.crud.dao.EmployeeDao;
import com.bupt.crud.entities.Department;
import com.bupt.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询员工，返回列表
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments =departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("员工信息："+employee);
        //redirect:重定向到一个地址
        //forword：转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments =departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("修改之后的员工信息"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
