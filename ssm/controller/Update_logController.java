package com.it.ssm.controller;


import com.it.ssm.pojo.Update_log;
import com.it.ssm.pojo.Work_hour;
import com.it.ssm.service.Update_logService;
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
@RequestMapping("/updatelog")
public class Update_logController {

    @Resource
    Update_logService update_logService;

    @RequestMapping("/addUpdatelog")
    public String addUpdatelog(Update_log update_log){
        System.out.println("update_log--*>"+update_log);
        try{
            update_logService.addUpdate_log(update_log);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "updatelog/addUpdatelog";
    }

    @RequestMapping("/delUpdate_log")
    @ResponseBody
    public String delUpdate_log(Update_log update_log){
        try{
            update_logService.delUpdate_log(update_log);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/updatelog/queryAllUpdatelog";
    }
    @RequestMapping("/toqueryAllUpdatelog")
    public String toqueryAllUpdatelog(){
        return "updatelog/queryAllUpdatelog";
    }
    @RequestMapping("queryAllUpdatelog")
    @ResponseBody
    public Map<String,Object> queryAllUpdatelog(int limit, int page){

        Map<String,Object> map=new HashMap<>();


        List<Update_log> updatelogList=update_logService.queryAll((page-1)*limit,limit);
        int count = update_logService.count();
        map.put("code", 0);
        map.put("msg", "正在加载....");
        map.put("count", count);
        map.put("data", updatelogList);
        return  map;
    }

    @RequestMapping("findById")
    public ModelAndView findById(Update_log update_log){
        ModelAndView modelAndView=new ModelAndView("updatelog/findById");
        Update_log update_log1=update_logService.findById(update_log);
        modelAndView.addObject("update_log",update_log1);
        return  modelAndView;
    }
    @RequestMapping("/updUpdatelog")
    public String updUpdatelog(Update_log update_log){
        try{
            update_logService.updUpdate_log(update_log);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }


}
