package com.jlab.usecases;

import com.jlab.entities.*;
import com.jlab.persistence.*;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class OrdersForCustomer {

    private Customer customer;

    private Order newOrder = new Order();

    @Inject
    private CustomersDAO customersDAO;

    @Inject
    private OrdersDAO ordersDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer customerId = Integer.parseInt(requestParameters.get("customerId"));
        this.customer = customersDAO.findById(customerId);
    }

    @Transactional
    public String createOrder() {
        newOrder.setCustomer(this.customer);
        ordersDAO.create(newOrder);
        return "/orders.xhtml?faces-redirect=true&customerId=" + this.customer.getId();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(Order newOrder) {
        this.newOrder = newOrder;
    }
}
