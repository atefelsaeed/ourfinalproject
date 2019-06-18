package com.agri.atef.myapplication.model;

public class ourVideoList {
    private String videoDescription;
    private int videoList;

    public ourVideoList() {
    }


    public ourVideoList(String videoDescription, int videoList) {
        this.videoDescription = videoDescription;
        this.videoList = videoList;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public int getVideoList() {
        return videoList;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public void setVideoList(int videoList) {
        this.videoList = videoList;
    }
}
