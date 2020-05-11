package com.it.ssm.dao;

import com.it.ssm.pojo.Sys_user;
import com.it.ssm.pojo.Work_hour;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Work_hourDAO {


    @Insert("insert into project_work_hour(pui_pi_id,pui_su_id,pui_work_hour,pui_input_dt) values(#{pui_pi_id},#{pui_su_id},#{pui_work_hour},#{pui_input_dt})")
    void addWork_hour(Work_hour work_hour);

    @Delete("delete from project_work_hour where id=#{id}")
    void delWork_hour(Work_hour work_hour);

    @Update("update project_work_hour set pui_pi_id=#{pui_pi_id},pui_su_id=#{pui_su_id},pui_work_hour=#{pui_work_hour},pui_input_dt=#{pui_input_dt} where id=#{id}")
    void updWork_hour(Work_hour work_hour);


    @Select("select * from project_work_hour WHERE pui_input_dt BETWEEN #{startdate} AND #{enddate} limit #{startPos},#{pageSize}")
    List<Work_hour> queryAll(@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize ,@Param(value="startdate") String startdate, @Param(value="enddate") String enddate);

    @Select("select * from project_work_hour where id=#{id}")
    Work_hour findById(Work_hour work_hour);

    @Select("select count(1) from project_work_hour WHERE pui_input_dt BETWEEN #{startdate} AND #{enddate}")
    int count(@Param(value="startdate") String startdate, @Param(value="enddate") String enddate);

    @Delete("delete from project_work_hour where id in (${delIds})")
    int work_hourDelete(@Param("delIds") String delIds);

    @Select("SELECT MAX(pui_input_dt) FROM project_work_hour")
    String maxdate();

    @Select("SELECT MIN(pui_input_dt) FROM project_work_hour")
    String mindate();

}
