package com.lokithor.lokithor.service;

import com.lokithor.lokithor.domain.TrackingRecord;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Stateless
public class TrackingRecordService {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    public TrackingRecord push(TrackingRecord trackingRecord) {
        trackingRecord.setId(UUID.randomUUID().toString());
        em.persist(trackingRecord);
        return trackingRecord;
    }
}
