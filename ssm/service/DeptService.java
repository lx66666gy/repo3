package com.it.ssm.service;

import com.it.ssm.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeptService{

    void addDept(Dept dept);

    List<Dept> queryAll(Dept dept, Integer startPos, Integer pageSize);
    int count(Dept dept);
    void delDept(Dept dept);
    Dept findById(Long dept_id);
    void updDept(Dept dept);
    int deptDelete(String delIds);

    List<Dept> queryAll2();
}
