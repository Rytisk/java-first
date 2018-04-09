package com.jlab.persistence;

import com.jlab.entities.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class OrdersDAO {

    @Inject
    private EntityManager em;

    public void create(Order order) {
        this.em.persist(order);
    }
}
