package com.it.ssm.controller;


import com.it.ssm.pojo.Dept;
import com.it.ssm.pojo.Item;
import com.it.ssm.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemComtroller {
    @Resource
    ItemService itemService;

    @RequestMapping("/toadd")
    public String toadd(){
        return "item/addItem";
    }

    @RequestMapping("/addItem")
    public String addItem(Item item){
        try{
            itemService.addItem(item);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/delItem")
    @ResponseBody
    public String delItem(Item item){
        try{
            itemService.delItem(item);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/item/queryAllitem";
    }


    @RequestMapping("/toqueryAllitem")
    public String toqueryAllitem(){
        return "item/queryAllitem";
    }


    @RequestMapping("queryAllitem")
    @ResponseBody
    public Map<String,Object> queryAll(Item item, int limit, int page){

        Map<String,Object> map=new HashMap<>();

        List<Item> itemList=itemService.queryAll(item,(page-1)*limit,limit);
        int count =itemService.count();
        map.put("code", 0);
        map.put("msg", "正在加载....");
        map.put("count", count);
        map.put("data", itemList);
        return  map;
    }


    @RequestMapping("findById")
    public ModelAndView findById(Item item){
        ModelAndView modelAndView=new ModelAndView("item/findById");
        Item item1=itemService.findById(item);
        modelAndView.addObject("item",item1);
        return  modelAndView;
    }


    @RequestMapping("/updItem")
    public String updItem(Item item){
        try{
            itemService.updItem(item);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }


    @RequestMapping("/itemDelete")
    @ResponseBody
    public String itemDelete(String delArray){
        System.out.println(delArray+"aaaaaaaaaa");
        itemService.itemDelete(delArray);
        return  "redirect:/item/queryAllitem";

    }


}
