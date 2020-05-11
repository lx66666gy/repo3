package com.it.ssm.dao;

import com.it.ssm.pojo.Update_log;
import com.it.ssm.pojo.Work_hour;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Update_logDAO {

    @Insert("insert into project_update_log(pul_pi_id,pul_update_uid,pul_update_dt,pul_update_contents) values(#{pul_pi_id},#{pul_update_uid},#{pul_update_dt},#{pul_update_contents})")
    void addUpdate_log(Update_log update_log);

    @Delete("delete from project_update_log where id=#{id}")
    void delUpdate_log(Update_log update_log);

    @Update("update project_update_log set pul_pi_id=#{pul_pi_id},pul_update_uid=#{pul_update_uid},pul_update_dt=#{pul_update_dt},pul_update_contents=#{pul_update_contents} where id=#{id}")
    void updUpdate_log(Update_log update_log);

    @Select("select * from project_update_log limit #{startPos},#{pageSize}")
    List<Update_log> queryAll(@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize);

    @Select("select * from project_update_log where id=#{id}")
    Update_log findById(Update_log update_log);

    @Select("select count(1) from project_update_log")
    int count();


}
