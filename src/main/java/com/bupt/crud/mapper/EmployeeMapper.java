package com.bupt.crud.mapper;


import com.bupt.crud.entities.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface EmployeeMapper {

   // @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    //@Options(useGeneratedKeys = true,keyProperty = "id")
    //@Insert("insert into employee(lastName,email,gender,dId) values(#{lastname},#{email},#{gender},#{dId})")
    public void addEmp(Employee employee);

    //@Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByName(String username);

}
