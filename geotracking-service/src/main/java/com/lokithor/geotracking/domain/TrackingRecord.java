package com.lokithor.geotracking.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = TrackingRecord.QUERY_LAST_ACTIVE_RECORDS,
                query = "select t from TrackingRecord t where t.time = (select max(tt.time) from TrackingRecord tt where tt.device.id = t.device.id)"),
        @NamedQuery(name = TrackingRecord.QUERY_LAST_RECORDS,
                query = "select new com.lokithor.geotracking.domain.TrackingRecordItemDTO(r.latitude,r.longitude,r.altitude,r.time) from TrackingRecord r where r.device.deviceId = :deviceId order by r.time")
})
@Entity
public class TrackingRecord {

    public static final String QUERY_LAST_RECORDS = "queryLastRecords";

    public static final String QUERY_LAST_ACTIVE_RECORDS = "queryLastActiveRecords";

    @Id
    @Expose
    private String id;
    @Expose
    private Float latitude;
    @Expose
    private Float longitude;
    @Expose
    private Float altitude;
    @ManyToOne
    @JoinColumn(name = "deviceId")
    @Expose(serialize = false, deserialize = false)
    private Device device;
    @Expose
    private Date time;
    @Expose
    @Column(name = "deviceId", updatable = false, insertable = false)
    private String deviceId;

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        if (device != null) {
            this.deviceId = device.getDeviceId();
        }
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
