package com.it.ssm.dao;

import com.it.ssm.pojo.Customer;
import com.it.ssm.pojo.Sys_user;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerDAO {

    //添加
    @Insert("insert into customer(Customer_id,Customer_name,Customer_sex,Customer_age,Credit_information) values(#{Customer_id},#{Customer_name},#{Customer_sex},#{Customer_age},#{Credit_information})")
    void addCustomer(Customer customer);


    //带模糊查询和分页的查询全部
    @Select("select * from customer where 1=1 and Customer_name like '%${customer.Customer_name}%' limit #{startPos},#{pageSize}")

    List<Customer> queryAllCustomer(@Param("customer") Customer customer, @Param(value="startPos") Integer startPos,
                            @Param(value="pageSize") Integer pageSize);


    //登录
    @Select("select * from customer where Customer_id=#{Customer_id} and Customer_name=#{Customer_name}")
    Customer login(Customer customer);


    //总记录数
    @Select("select count(1) from customer")
    int count(Customer customer);

    //删除单个
    @Delete("delete from customer where Customer_id=#{Customer_id}")
    void delCustomer(Customer customer);

}
