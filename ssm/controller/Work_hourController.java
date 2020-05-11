package com.it.ssm.controller;




import com.it.ssm.pojo.Work_hour;
import com.it.ssm.service.Work_hourService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/workhour")
public class Work_hourController {

    @Resource
    Work_hourService workHourService;

    @RequestMapping("/addWorkhour")
    public String addWorkhour(Work_hour work_hour){
        try{
            workHourService.addWork_hour(work_hour);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "workhour/addWorkhour";
    }

    @RequestMapping("/delWork_hour")
    @ResponseBody
    public String deldelWork_hour(Work_hour work_hour){
        try{
            workHourService.delWork_hour(work_hour);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/workhour/queryAllWorkhour";
    }
    @RequestMapping("/toqueryAllWorkhour")
    public String queryAllWorkhour(){
        return "workhour/queryAllWorkhour";
    }
    @RequestMapping("queryAllWorkhour")
    @ResponseBody
    public Map<String,Object> queryAllWorkhour(int limit, int page,String startdate, String enddate){

        Map<String,Object> map=new HashMap<>();

        System.out.println(startdate);
        System.out.println(enddate);
        if(startdate==null||startdate==""){

            startdate=workHourService.mindate();
        }
        if(enddate==null||enddate==""){
            enddate=workHourService.maxdate();
        }

        List<Work_hour> workhourList=workHourService.queryAll((page-1)*limit,limit,startdate,enddate);
        int count = workHourService.count(startdate,enddate);
        map.put("code", 0);
        map.put("msg", "正在加载....");
        map.put("count", count);
        map.put("data", workhourList);
        return  map;
    }

    @RequestMapping("findById")
    public ModelAndView findById(Work_hour work_hour){
        ModelAndView modelAndView=new ModelAndView("workhour/findById");
        Work_hour work_hour1=workHourService.findById(work_hour);
        modelAndView.addObject("work_hour",work_hour1);
        return  modelAndView;
    }
    @RequestMapping("/updWorkhour")
    public String updWorkhour(Work_hour work_hour){
        try{
            workHourService.updWork_hour(work_hour);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }



}
