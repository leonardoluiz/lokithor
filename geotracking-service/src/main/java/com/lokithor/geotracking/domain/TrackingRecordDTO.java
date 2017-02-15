package com.lokithor.geotracking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lcruz on 2/13/17.
 */
public class TrackingRecordDTO {

    private String deviceId;
    private List<TrackingRecordItemDTO> records;

    public TrackingRecordDTO(String deviceId,List<TrackingRecordItemDTO> records) {
        this.deviceId = deviceId;
        this.records = Collections.unmodifiableList(records);
    }


    public String getDeviceId() {
        return deviceId;
    }

    public List<TrackingRecordItemDTO> getRecords() {
        return records;
    }
}
