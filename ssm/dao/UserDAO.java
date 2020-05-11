package com.it.ssm.dao;

import com.it.ssm.pojo.Sys_user;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDAO {

    @Insert("insert into sys_user(su_name,su_login_name,su_login_passwd,su_sex,su_birth_dt,su_icon,su_address,su_province,su_city,su_district,su_dept_id,su_email,su_mobile,su_status,su_create_uid,su_create_dt) values(#{su_name},#{su_login_name},#{su_login_passwd},#{su_sex},#{su_birth_dt},#{su_icon},#{su_address},#{su_province},#{su_city},#{su_district},#{su_dept_id},#{su_email},#{su_mobile},#{su_status},#{su_create_uid},#{su_create_dt})")
    void addSys_user(Sys_user sys_user);

    @Delete("delete from sys_user where id=#{id}")
    void delSys_user(Sys_user sys_user);

    @Update("update sys_user set su_name=#{su_name},su_login_name=#{su_login_name},su_login_passwd=#{su_login_passwd},su_sex=#{su_sex},su_birth_dt=#{su_birth_dt},su_icon=#{su_icon},su_address=#{su_address},su_province=#{su_province},su_city=#{su_city},su_district=#{su_district},su_dept_id=#{su_dept_id},su_email=#{su_email},su_mobile=#{su_mobile},su_status=#{su_status},su_create_uid=#{su_create_uid},su_create_dt=#{su_create_dt} where id=#{id} ")
    void updSys_user(Sys_user sys_user);




    @Select("select * from sys_user where 1=1 and su_name like '%${sys_user.su_name}%' limit #{startPos},#{pageSize}")
    @Results(
            value = {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(property = "dept",column ="su_dept_id", one = @One(select = "com.it.ssm.dao.DeptDAO.findById",fetchType = FetchType.EAGER)),
                    @Result(property = "sys_user",column ="su_create_uid", one = @One(select = "com.it.ssm.dao.UserDAO.findById",fetchType = FetchType.EAGER)),
            }

    )
    List<Sys_user> queryAll(@Param("sys_user") Sys_user sys_user, @Param(value="startPos") Integer startPos,
                            @Param(value="pageSize") Integer pageSize);

   /* @Select("select * from sys_user")
    List<Sys_user> queryAll( Sys_user sys_user);*/


    @Select("select * from sys_user where id=#{id}")
    Sys_user findById(@Param("id") Long su_create_uid);

    @Select("select * from sys_user where su_login_name=#{su_login_name} and su_login_passwd=#{su_login_passwd}")
    Sys_user login(Sys_user sys_user);

    @Select("select count(1) from sys_user")
    int count(Sys_user sys_user);

    @Delete("delete from sys_user where id in (${delIds})")
    int sys_userDelete(@Param("delIds") String delIds);


    @Select("select * from sys_user")
    @Results(
            value = {
                    @Result(property = "id",id = true,column = "id"),
                    @Result(property = "roleList",column = "id",
                            many = @Many(select = "com.it.ssm.dao.RoleDAO.selectRoleByUser_Id",fetchType = FetchType.LAZY))
            }
    )
    List<Sys_user> findAllSysUser();

}
