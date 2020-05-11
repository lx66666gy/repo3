package com.it.ssm.controller;

import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Sys_user;
import com.it.ssm.service.DeptService;
import com.it.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Resource
    DeptService deptService;

    @RequestMapping("/addDept")
    public String addUser(Dept dept){
        try{
            deptService.addDept(dept);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "dept/addDept";
    }



    @RequestMapping("/delDept")
    @ResponseBody
    public String delDept(Dept dept){
        try{
            deptService.delDept(dept);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/dept/queryAlldept";
    }


    @RequestMapping("queryAlldept")
    @ResponseBody
    public Map<String,Object> queryAll(Dept dept, int limit, int page){

        Map<String,Object> map=new HashMap<>();

        List<Dept> deptList=deptService.queryAll(dept,(page-1)*limit,limit);
        int count = deptService.count(dept);
        map.put("code", 0);
        map.put("msg", "正在加载....");
        map.put("count", count);
        map.put("data", deptList);
        return  map;
    }

    @RequestMapping("queryAlldept2")
    @ResponseBody
    public List<Dept> queryAlldept2(){
        List<Dept> listdept= deptService.queryAll2();
        System.out.println(listdept.size()+"gdsfshhfkasgfhjsgfhjg");
        return listdept;
    }

    @RequestMapping("findById")
    public ModelAndView findById(Dept dept){
        ModelAndView modelAndView=new ModelAndView("dept/findById");
        Dept dept1=deptService.findById(dept.getDept_id());
        modelAndView.addObject("dept",dept1);
        return  modelAndView;
    }
    @RequestMapping("/updDept")
    public String updDept(Dept dept){
        try{
            deptService.updDept(dept);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toqueryAlldept")
    public String toqueryAlldept(){
        return "dept/queryAlldept";
    }



    @RequestMapping("/deptDelete")
    @ResponseBody
    public String deptDelete(String delArray){
        System.out.println(delArray+"aaaaaaaaaa");
        deptService.deptDelete(delArray);
        return  "redirect:/user/queryAll";

    }
}
