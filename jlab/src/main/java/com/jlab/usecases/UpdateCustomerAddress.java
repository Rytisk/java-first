package com.jlab.usecases;

import com.jlab.cdi.specialization.LongGreeting;
import com.jlab.cdi.specialization.SmartGreeter;
import com.jlab.entities.Customer;
import com.jlab.cdi.interceptors.Logging;
import com.jlab.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
public class UpdateCustomerAddress implements Serializable {

    private Customer customer;

    @Inject CustomersDAO customersDAO;

    @Inject @SmartGreeter
    LongGreeting greeting;

    @PostConstruct
    private void init() {
        System.out.println(greeting.greet());
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer customerId = Integer.parseInt(requestParameters.get("customerId"));
        this.customer = customersDAO.findById(customerId);
    }

    @Transactional
    @Logging
    public String updateCustomerAddress() {
        try {
            customersDAO.update(this.customer);
        } catch (OptimisticLockException e) {
            return "/customer.xhtml?faces-redirect=true&customerId=" + this.customer.getId() + "&error=optimistic-lock-exception";
        }
        return "/home.xhtml";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
