package com.lokithor.geotracking.service;

import com.lokithor.geotracking.domain.Device;
import com.lokithor.geotracking.domain.TrackingRecord;
import com.lokithor.geotracking.domain.TrackingRecordDTO;
import com.lokithor.geotracking.domain.TrackingRecordItemDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Stateless
public class TrackingRecordService {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    public TrackingRecord push(String deviceId,TrackingRecord trackingRecord) throws ServiceException {

        Device device = em.find(Device.class,deviceId);

        if (device == null) {
            throw new ServiceException("Device not found!");
        }

        trackingRecord.setId(UUID.randomUUID().toString());
        trackingRecord.setTime(new Date());
        trackingRecord.setDevice(device);
        em.persist(trackingRecord);
        return trackingRecord;

    }

    public TrackingRecordDTO getLastRecords(String deviceId) {
        Device device = em.find(Device.class,deviceId);
        if (device == null) {
            return null;
        }

        TypedQuery<TrackingRecordItemDTO> q = em.createNamedQuery(TrackingRecord.QUERY_LAST_RECORDS,TrackingRecordItemDTO.class);
        q.setParameter("deviceId",deviceId);

        return new TrackingRecordDTO(deviceId,q.getResultList());
    }

    public List<TrackingRecord> getActiveDeviceRecords() {

        TypedQuery<TrackingRecord> query = em.createQuery(TrackingRecord.QUERY_LAST_ACTIVE_RECORDS, TrackingRecord.class);
        return query.getResultList();

    }
}
