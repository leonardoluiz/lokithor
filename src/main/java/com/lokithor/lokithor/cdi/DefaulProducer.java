package com.lokithor.lokithor.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class DefaulProducer {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;


    @Produces
    public EntityManager produceEntityManager() {
        return em;
    }


}
