package com.it.ssm.service;

import com.it.ssm.dao.DeptDAO;
import com.it.ssm.dao.UserDAO;
import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Sys_user;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Resource
    DeptDAO deptDAO;

    @Override
    public void addDept(Dept dept) {
        deptDAO.addDept(dept);
    }

    @Override
    public List<Dept> queryAll(Dept dept, Integer startPos, Integer pageSize) {
        return deptDAO.queryAll(dept,startPos,pageSize);
    }

    @Override
    public int count(Dept dept) {
        return deptDAO.count(dept);
    }

    @Override
    public void delDept(Dept dept) {
        deptDAO.delDept(dept);

    }

    @Override
    public Dept findById(Long dept_id) {
        return deptDAO.findById(dept_id);
    }


    @Override
    public void updDept(Dept dept) {
        deptDAO.updDept(dept);
    }

    @Override
    public int deptDelete(String delIds) {

        return deptDAO.deptDelete(delIds);
    }

    @Override
    public List<Dept> queryAll2() {
        return deptDAO.queryAll2();
    }
}
