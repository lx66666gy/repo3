package com.it.ssm.dao;

import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Sys_role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDAO {

    @Insert("insert into sys_role(sr_name,sr_sign,sr_remark,sr_create_uid,sr_create_dt,sr_update_dt,sr_update_uid,sr_issuperadmin,sr_issysadmin) values(#{sr_name},#{sr_sign},#{sr_remark},#{sr_create_uid},#{sr_create_dt},#{sr_update_dt},#{sr_update_uid},#{sr_issuperadmin},#{sr_issysadmin})")
    void addRole(Sys_role sys_role);

    @Select("select * from sys_role where 1=1 and sr_name like '%${sys_role.sr_name}%' limit #{startPos},#{pageSize}")
    List<Sys_role> queryAll(@Param("sys_role") Sys_role sys_role, @Param(value="startPos") Integer startPos,
                        @Param(value="pageSize") Integer pageSize);

    @Select("select count(1) from sys_role")
    int count();

    @Delete("delete from sys_role where id=#{id}")
    void delRole(Sys_role sys_role);

    @Select("select * from sys_role where id=#{id}")
    Sys_role findById(Sys_role sys_role);

    @Update("update sys_role set sr_name=#{sr_name},sr_sign=#{sr_sign},sr_remark=#{sr_remark},sr_create_uid=#{sr_create_uid},sr_create_dt=#{sr_create_dt},sr_update_dt=#{sr_update_dt},sr_update_uid=#{sr_update_uid},sr_issuperadmin=#{sr_issuperadmin},sr_issysadmin=#{sr_issysadmin} where id=#{id}")
    void updRole(Sys_role sys_role);

    @Delete("delete from sys_role where id in (${delIds})")
    int roleDelete(@Param("delIds") String delIds);


    @Select("select * from sys_role where id in(select sur_role_id from sys_user_role where sur_user_id=#{id})")
    List<Sys_role> selectRoleByUser_Id(String id);


}
