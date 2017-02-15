package com.lokithor.geotracking.domain;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = TrackingRecord.QUERY_LAST_ACTIVE_RECORDS,
                query = "select t from TrackingRecord t"),
        @NamedQuery(name =  TrackingRecord.QUERY_LAST_RECORDS,
                query = "select new com.lokithor.geotracking.domain.TrackingRecordItemDTO(r.latitude,r.longitude,r.altitude,r.time) from TrackingRecord r where r.device.deviceId = :deviceId order by r.time")
})
@Entity
public class TrackingRecord {

    public static final String QUERY_LAST_RECORDS = "queryLastRecords";

    public static final String QUERY_LAST_ACTIVE_RECORDS = "queryLastActiveRecords";

    @Id
    private String id;
    private Float latitude;
    private Float longitude;
    private Float altitude;
    @ManyToOne
    @JoinColumn(name="deviceId")
    private Device device;
    private Date time;

    @Transient
    private String deviceId;

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
