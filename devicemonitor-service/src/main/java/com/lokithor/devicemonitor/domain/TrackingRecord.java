package com.lokithor.devicemonitor.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Device tracking record
 *
 */
public class TrackingRecord {

    private String id;
    private Long latitude;
    private Long longitude;
    private Long altitude;
    private String deviceId;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getAltitude() {
        return altitude;
    }

    public void setAltitude(Long altitude) {
        this.altitude = altitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TrackingRecord{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", deviceId='" + deviceId + '\'' +
                ", time=" + time +
                '}';
    }
}
