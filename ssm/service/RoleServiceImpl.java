package com.it.ssm.service;

import com.it.ssm.dao.RoleDAO;
import com.it.ssm.dao.Update_logDAO;
import com.it.ssm.pojo.Sys_role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDAO roleDAO;
    @Override
    public void addRole(Sys_role sys_role) {

    }

    @Override
    public List<Sys_role> queryAll(Sys_role sys_role, Integer startPos, Integer pageSize) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delRole(Sys_role sys_role) {

    }

    @Override
    public Sys_role findById(Sys_role sys_role) {
        return null;
    }

    @Override
    public void updRole(Sys_role sys_role) {

    }

    @Override
    public int roleDelete(String delIds) {
        return 0;
    }

    @Override
    public List<Sys_role> selectRoleByUser_Id(String id) {

        return roleDAO.selectRoleByUser_Id(id);
    }
}
