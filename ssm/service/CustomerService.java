package com.it.ssm.service;


import com.it.ssm.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void addCustomer(Customer customer);

    List<Customer> queryAllCustomer( Customer customer, Integer startPos,Integer pageSize);

    Customer login(Customer customer);

    int count(Customer customer);

    void delCustomer(Customer customer);
}
