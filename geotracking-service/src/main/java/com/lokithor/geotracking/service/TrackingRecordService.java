package com.lokithor.geotracking.service;

import com.lokithor.geotracking.domain.TrackingRecord;

import javax.ejb.Stateless;
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
