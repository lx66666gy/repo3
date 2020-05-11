package com.it.ssm.controller;

import com.it.ssm.pojo.Sys_user;
import com.it.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes("sys_user3")
public class UserController {


    @Resource
    UserService userService;

    @RequestMapping("/addUser")
    public String addUser(Sys_user sys_user){
        try{
            userService.addSys_user(sys_user);

            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "user/addUser";
    }



    @RequestMapping("/delUser")
    @ResponseBody
    public String delUser(Sys_user sys_user){
        try{
            userService.delSys_user(sys_user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/user/queryAll";
    }


    @RequestMapping("queryAll")
    @ResponseBody
    public Map<String,Object> queryAll(Sys_user sys_user, int limit, int page){

        Map<String,Object> map=new HashMap<>();

        List<Sys_user> userList=userService.queryAll(sys_user,(page-1)*limit,limit);
        int count = userService.count(sys_user);
        map.put("code", 0);
        map.put("msg", "正在加载....");
        map.put("count", count);
        map.put("data", userList);
        System.out.println("map------>"+map);
        return  map;
    }


    /*@RequestMapping("queryAll")
    @ResponseBody
    public List<Sys_user> queryAll(Sys_user sys_user){

        List<Sys_user> userList=userService.queryAll(sys_user);

        return  userList;
    }*/
    @RequestMapping("findById")
    public ModelAndView findById(Sys_user sys_user){
        ModelAndView modelAndView=new ModelAndView("user/findById");
        Sys_user sys_user1=userService.findById(sys_user.getId());
        System.out.println("sys_user1------->"+sys_user1);
        modelAndView.addObject("sys_user",sys_user1);
        return  modelAndView;
    }
    @RequestMapping("/updUser")
    public String updUser(Sys_user sys_user){
        try{
            System.out.println(sys_user);
            userService.updSys_user(sys_user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("/login")
    public String login(Model model, Sys_user sys_user) {

        Sys_user sys_user3 = null;
        try {
            sys_user3 = userService.login(sys_user);
            if (sys_user3!= null) {
                model.addAttribute("sys_user3",sys_user3);
                return "forward:/index1.jsp";
            }else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";

        }

    }


    @RequestMapping("/login1")
    public String login1(Sys_user sys_user) {

        Sys_user sys_user3 = null;
        try {
            sys_user3 = userService.login(sys_user);
            if (sys_user3!= null) {
                return "user/queryAllUser";
            }else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }
    @RequestMapping("/userDelete")
    @ResponseBody
    public String userDelete(String delArray){
        System.out.println(delArray+"aaaaaaaaaa");
        userService.sys_userDelete(delArray);
        return  "redirect:/user/queryAll";

    }
    @RequestMapping("/toqueryAll")
    public String toqueryAll(){
        return "user/queryAllUser";
    }



}
