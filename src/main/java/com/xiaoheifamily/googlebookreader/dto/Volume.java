package com.xiaoheifamily.googlebookreader.dto;

public class Volume {

    private String id;
    private VolumeInfo volumeInfo = new VolumeInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}