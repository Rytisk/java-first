package com.jlab.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Disposes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;

@ApplicationScoped
public class Resources {

    /*@PersistenceContext(name = "ShopPU")
    private EntityManagerFactory emf;

    @Produces
    @Default
    @RequestScoped
    private EntityManager createJTAEntityManager() {return emf.createEntityManager(SynchronizationType.SYNCHRONIZED); }

    private void closeDefaultEntityManager(@Disposes @Default EntityManager em) { em.close();}*/
}
