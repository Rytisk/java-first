package com.jlab.persistence;

import com.jlab.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomersDAO {
    @Inject
    private EntityManager em;

    public List<Customer> getAllCustomers(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public Customer findById(Integer id) {
        return em.find(Customer.class, id);
    }

    public void create(Customer customer){
        this.em.persist(customer);
    }
}
