package com.jlab.persistence;

import com.jlab.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CustomersDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Customer> loadAll(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public void save(Customer customer){
        this.em.persist(customer);
    }
}
