package com.jlab.persistence;

import com.jlab.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProductsDAO {
    @Inject
    private EntityManager em;

    public List<Product> getAllProducts(){
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public Product findById(Integer id) {
        return em.find(Product.class, id);
    }

    public void create(Product product){
        this.em.persist(product);
    }
}
