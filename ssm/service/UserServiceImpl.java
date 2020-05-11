package com.it.ssm.service;

import com.it.ssm.dao.UserDAO;
import com.it.ssm.pojo.Sys_user;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserDAO sys_userDAO;
    @Override
    public void addSys_user(Sys_user sys_user) {
        sys_userDAO.addSys_user(sys_user);
    }

    @Override
    public void delSys_user(Sys_user sys_user) {
        sys_userDAO.delSys_user(sys_user);
    }

    @Override
    public void updSys_user(Sys_user sys_user) {
        sys_userDAO.updSys_user(sys_user);
    }

    @Override
    public List<Sys_user> queryAll(Sys_user sys_user, Integer startPos, Integer pageSize) {
        return sys_userDAO.queryAll(sys_user,startPos,pageSize);
    }

    @Override
    public Sys_user findById(Long su_dept_id) {
        return sys_userDAO.findById(su_dept_id);
    }

    @Override
    public Sys_user login(Sys_user sys_user) {
        return sys_userDAO.login(sys_user);
    }

    @Override
    public int count(Sys_user sys_user) {
        return sys_userDAO.count(sys_user);
    }

    @Override
    public int sys_userDelete(String delIds) {
        return sys_userDAO.sys_userDelete(delIds);
    }
}
