package com.it.ssm.dao;

import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ItemDAO {

    @Insert("insert into project_info(pi_name,pi_department,pi_create_uid,pi_create_dt,pi_plan_start_dt,pi_plan_end_dt,pi_real_start_dt,pi_real_end_dt,pi_state) values(#{pi_name},#{pi_department},#{pi_create_uid},#{pi_create_dt},#{pi_plan_start_dt},#{pi_plan_end_dt},#{pi_real_start_dt},#{pi_real_end_dt},#{pi_state})")
    void addItem(Item item);

    @Select("select * from project_info where 1=1 and pi_name like '%${item.pi_name}%' limit #{startPos},#{pageSize}")
    List<Item> queryAll(@Param("item") Item item, @Param(value="startPos") Integer startPos,
                        @Param(value="pageSize") Integer pageSize);

    @Select("select count(1) from project_info")
    int count();


    @Delete("delete from project_info where id=#{id}")
    void delItem(Item item);

    @Select("select * from project_info where id=#{id}")
    Item findById(Item item);

    @Update("update project_info set pi_name=#{pi_name},pi_department=#{pi_department},pi_create_uid=#{pi_create_uid},pi_create_dt=#{pi_create_dt},pi_plan_start_dt=#{pi_plan_start_dt},pi_plan_end_dt=#{pi_plan_end_dt},pi_real_start_dt=#{pi_real_start_dt},pi_real_end_dt=#{pi_real_end_dt},pi_state=#{pi_state} where id=#{id}")
    void updItem(Item item);

    @Delete("delete from project_info where id in (${delIds})")
    int itemDelete(@Param("delIds") String delIds);


}
