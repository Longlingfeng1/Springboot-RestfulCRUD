package com.bupt.crud.mapper;

import com.bupt.crud.entities.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
//@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public void deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public void addDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public void updateDept(Department department);
}
