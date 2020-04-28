package com.vrmine.vrmineproject.entity;

/**
 * @author PGL
 * @data 2020/4/16 18:26
 **/
public class Mine {
    private String mineName;
    private Integer mineId;
    private Double mineLongitude;
    private Double mineLatitude;




    public Mine() {
    }
    public Mine(String mineName, Integer mineId, Double mineLongitude, Double mineLatitude) {
        this.mineName = mineName;
        this.mineId = mineId;
        this.mineLongitude = mineLongitude;
        this.mineLatitude = mineLatitude;
    }



    public String getMineName() {
        return mineName;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public Integer getMineId() {
        return mineId;
    }

    public void setMineId(Integer mineId) {
        this.mineId = mineId;
    }

    public Double getMineLongitude() {
        return mineLongitude;
    }

    public void setMineLongitude(Double mineLongitude) {
        this.mineLongitude = mineLongitude;
    }

    public Double getMineLatitude() {
        return mineLatitude;
    }

    public void setMineLatitude(Double mineLatitude) {
        this.mineLatitude = mineLatitude;
    }
}

