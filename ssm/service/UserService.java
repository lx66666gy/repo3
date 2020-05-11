package com.it.ssm.service;

import com.it.ssm.pojo.Sys_user;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    void addSys_user(Sys_user sys_user);


    void delSys_user(Sys_user sys_user);

    void updSys_user(Sys_user sys_user);

    List<Sys_user> queryAll(Sys_user sys_user,Integer startPos,Integer pageSize);

    Sys_user findById(Long su_dept_id);


    Sys_user login(Sys_user sys_user);


    int count(Sys_user sys_user);

    int sys_userDelete(String delIds);
}
