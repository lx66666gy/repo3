package com.it.ssm.service;

import com.it.ssm.pojo.Work_hour;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Work_hourService {


    void addWork_hour(Work_hour work_hour);
    void delWork_hour(Work_hour work_hour);
    void updWork_hour(Work_hour work_hour);
    List<Work_hour> queryAll(Integer startPos,Integer pageSize,String startdate,String enddate);
    Work_hour findById(Work_hour work_hour);
    int count(String startdate,String enddate);

    int work_hourDelete(String delIds);
    String maxdate();
    String mindate();
    /*List<Work_hour> queryAll2(String startdate,String enddate);*/
}
