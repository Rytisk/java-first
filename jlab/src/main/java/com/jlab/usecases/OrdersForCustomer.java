package com.jlab.usecases;

import com.jlab.entities.*;
import com.jlab.persistence.*;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Model
public class OrdersForCustomer {

    private Customer customer;

    private Order newOrder = new Order();

    private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

    @Inject
    private CustomersDAO customersDAO;

    @Inject
    private OrdersDAO ordersDAO;

    @Inject
    private ProductsDAO productsDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer customerId = Integer.parseInt(requestParameters.get("customerId"));
        this.customer = customersDAO.findById(customerId);
        List<Product> products = productsDAO.getAllProducts();
        for (Product p : products) {
            OrderProduct op = new OrderProduct();
            op.setProduct(p);
            op.setOrder(newOrder);
            this.orderProducts.add(op);
        }
    }

    @Transactional
    public String createOrder() {
        newOrder.setCustomer(this.customer);
        newOrder.setOrderProducts(orderProducts);
        newOrder.setDate(new Date());
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

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
