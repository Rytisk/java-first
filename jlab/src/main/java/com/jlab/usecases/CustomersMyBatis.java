package com.jlab.usecases;

import com.jlab.mybatis.dao.CustomerMapper;
import com.jlab.mybatis.model.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CustomersMyBatis {

    @Inject
    private CustomerMapper customerMapper;

    private List<Customer> allCustomers;

    private Customer newCustomer = new Customer();

    @PostConstruct
    public void init(){
        this.loadCustomers();
    }

    private void loadCustomers() {
        this.allCustomers = customerMapper.selectAll();
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }

    @Transactional
    public String createNewCustomer() {
        customerMapper.insert(newCustomer);
        return "/mybatis/home?faces-redirect=true";
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer){
        this.newCustomer = newCustomer;
    }

}
