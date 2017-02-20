package com.lokithor.geotracking.service;

import com.lokithor.geotracking.domain.Device;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DeviceService {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    public List<Device> findAll() {
        TypedQuery<Device> query = em.createQuery("select d from Device d", Device.class);
        return query.getResultList();
    }


    public Device create(Device device) {
        em.persist(device);
        return device;
    }
}