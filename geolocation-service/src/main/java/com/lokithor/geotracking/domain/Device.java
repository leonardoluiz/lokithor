package com.lokithor.geotracking.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lcruz on 2/13/17.
 */
@Entity
public class Device {

    @Id
    private String deviceId;

    public Device(String deviceId) {
        this.setDeviceId(deviceId);
    }

    public Device() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
