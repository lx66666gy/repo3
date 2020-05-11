package com.it.ssm.service;

import com.it.ssm.pojo.Sys_role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {

    void addRole(Sys_role sys_role);
    List<Sys_role> queryAll( Sys_role sys_role, Integer startPos, Integer pageSize);
    int count();
    void delRole(Sys_role sys_role);
    Sys_role findById(Sys_role sys_role);
    void updRole(Sys_role sys_role);
    int roleDelete(String delIds);
    List<Sys_role> selectRoleByUser_Id(String id);
}
