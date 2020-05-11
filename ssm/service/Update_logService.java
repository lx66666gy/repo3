package com.it.ssm.service;

import com.it.ssm.pojo.Update_log;
import com.it.ssm.pojo.Work_hour;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Update_logService {

    void addUpdate_log(Update_log update_log);
    void delUpdate_log(Update_log update_log);
    void updUpdate_log(Update_log update_log);
    List<Update_log> queryAll(@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize);
    Update_log findById(Update_log update_log);
    int count();
}
