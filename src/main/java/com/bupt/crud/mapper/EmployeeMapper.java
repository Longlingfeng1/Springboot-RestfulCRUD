package com.bupt.crud.mapper;


import com.bupt.crud.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);
}
