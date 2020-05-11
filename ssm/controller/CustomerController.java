package com.it.ssm.controller;

import com.it.ssm.pojo.Customer;
import com.it.ssm.pojo.Sys_user;
import com.it.ssm.service.CustomerService;
import com.it.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
/*@SessionAttributes("sys_user3")*/
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("/addCustomer")
    public String addCustomer(Customer customer){
        try{
            customerService.addCustomer(customer);

            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping("/toadd")
    public String toadd(){
        return "customer/addCustomer";
    }


    @RequestMapping("queryAllCustomer")
    @ResponseBody
    public Map<String,Object> queryAllCustomer(Customer customer, int limit, int page){

        Map<String,Object> map=new HashMap<>();

        List<Customer> customerList=customerService.queryAllCustomer(customer,(page-1)*limit,limit);
        int count = customerService.count(customer);
        map.put("code", 0);
        map.put("msg", "正在加载....");
        map.put("count", count);
        map.put("data", customerList);
        System.out.println("map------>"+map);
        return  map;
    }

    @RequestMapping("/toqueryAllCustomer")
    public String toqueryAllCustomer(){
        return "customer/queryAllCustomer";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "customer/login1";
    }

    @RequestMapping("/login1")
    public String login1(Model model, Customer customer) {

        Customer customer3 = null;
        try {
            customer3 = customerService.login(customer);
            if (customer3!= null) {
                model.addAttribute("customer3",customer3);
                return "forward:/index2.jsp";
            }else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";

        }

    }

    @RequestMapping("/delCustomer")
    @ResponseBody
    public String delCustomer(Customer customer){
        try{
            customerService.delCustomer(customer);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "redirect:/customer/queryAllCustomer";
    }



}
