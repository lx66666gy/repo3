package com.it.ssm.service;

import com.it.ssm.dao.UserDAO;
import com.it.ssm.dao.Work_hourDAO;
import com.it.ssm.pojo.Work_hour;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class Work_hourServiceImpl implements Work_hourService {

    @Resource
    Work_hourDAO work_hourDAO;
    @Override
    public void addWork_hour(Work_hour work_hour) {
        work_hourDAO.addWork_hour(work_hour);
    }

    @Override
    public void delWork_hour(Work_hour work_hour) {
        work_hourDAO.delWork_hour(work_hour);
    }

    @Override
    public void updWork_hour(Work_hour work_hour) {
        work_hourDAO.updWork_hour(work_hour);
    }

    @Override
    public List<Work_hour> queryAll(Integer startPos, Integer pageSize,String startdate,String enddate) {
        return work_hourDAO.queryAll(startPos,pageSize,startdate,enddate);
    }


    @Override
    public Work_hour findById(Work_hour work_hour) {
        return work_hourDAO.findById(work_hour);
    }

    @Override
    public int count(String startdate,String enddate) {
        return work_hourDAO.count(startdate,enddate);
    }

    @Override
    public int work_hourDelete(String delIds) {
        return work_hourDAO.work_hourDelete(delIds);
    }

    @Override
    public String maxdate() {

        return work_hourDAO.maxdate();
    }

    @Override
    public String mindate() {

        return work_hourDAO.mindate();
    }

    /*@Override
    public List<Work_hour> queryAll2(String startdate, String enddate) {
        return work_hourDAO.queryAll2(startdate,enddate);
    }*/
}
