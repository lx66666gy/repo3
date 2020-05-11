package com.it.ssm.service;

import com.it.ssm.dao.CustomerDAO;
import com.it.ssm.pojo.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDAO customerDAO;

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public List<Customer> queryAllCustomer(Customer customer, Integer startPos, Integer pageSize) {
        return customerDAO.queryAllCustomer(customer,startPos,pageSize);
    }

    @Override
    public Customer login(Customer customer) {
        return customerDAO.login(customer);
    }

    @Override
    public int count(Customer customer) {
        return customerDAO.count(customer);
    }

    @Override
    public void delCustomer(Customer customer) {
        customerDAO.delCustomer(customer);
    }

}
