package com.it.ssm.dao;

import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Sys_user;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptDAO {

    @Insert("insert into sys_dept(dept_parent_id,dept_name,dept_order,dept_flag,dept_addr,dept_contact,dept_phone,dept_desc) values(#{dept_parent_id},#{dept_name},#{dept_order},#{dept_flag},#{dept_addr},#{dept_contact},#{dept_phone},#{dept_desc})")
    void addDept(Dept dept);

    @Select("select * from sys_dept where 1=1 and dept_name like '%${dept.dept_name}%' limit #{startPos},#{pageSize}")
    List<Dept> queryAll(@Param("dept") Dept dept, @Param(value="startPos") Integer startPos,
                            @Param(value="pageSize") Integer pageSize);

    @Select("select count(1) from sys_dept")
    int count(Dept dept);

    @Delete("delete from sys_dept where dept_id=#{dept_id}")
    void delDept(Dept dept);

    @Select("select * from sys_dept where dept_id=#{dept_id}")
    Dept findById(@Param("dept_id") Long su_dept_id);


    @Update("update sys_dept set dept_parent_id=#{dept_parent_id},dept_name=#{dept_name},dept_order=#{dept_order},dept_flag=#{dept_flag},dept_addr=#{dept_addr},dept_contact=#{dept_contact},dept_phone=#{dept_phone},dept_desc=#{dept_desc} where dept_id=#{dept_id}")
    void updDept(Dept dept);

    @Delete("delete from sys_dept where dept_id in (${delIds})")
    int deptDelete(@Param("delIds") String delIds);


    @Select("select * from sys_dept")
    List<Dept> queryAll2();
}
