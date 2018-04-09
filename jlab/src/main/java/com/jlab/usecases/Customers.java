package com.jlab.usecases;

import com.jlab.entities.Customer;
import com.jlab.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Customers {
    @Inject
    private CustomersDAO customersDAO;

    private List<Customer> allCustomers;

    private Customer newCustomer = new Customer();

    @PostConstruct
    public void init(){
        this.loadCustomers();
    }

    private void loadCustomers() {
        this.allCustomers = customersDAO.getAllCustomers();
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }

    @Transactional
    public String createNewCustomer() {
        customersDAO.create(newCustomer);
        return "home?faces-redirect=true";
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer){
        this.newCustomer = newCustomer;
    }

}
