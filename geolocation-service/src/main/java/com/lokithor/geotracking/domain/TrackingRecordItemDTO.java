package com.lokithor.geotracking.domain;

import java.util.Date;

public class TrackingRecordItemDTO {

    private Float latitude;
    private Float longitude;
    private Float altitude;
    private Date time;

    public TrackingRecordItemDTO(Float latitude, Float longitude, Float altitude, Date time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
