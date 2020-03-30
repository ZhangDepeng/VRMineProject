package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/6-21:36
 */
public class Tunnel {
    private Integer tunnelId;

    private Double latitude;

    private Double longitude;

    private Double altitude;

    private String tunnelName;

    private String note;

    private String airflowType;

    private String shape;

    private double wide;

    private double height;

    private String supportPattern;

    private int aa;

    private String tunnelType;

    public Tunnel() {
    }

    public Tunnel(Integer tunnelId, Double latitude, Double longitude, Double altitude, String tunnelName, String note, String airflowType, String shape, double wide, double height, String supportPattern, int aa, String tunnelType) {
        this.tunnelId = tunnelId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.tunnelName = tunnelName;
        this.note = note;
        this.airflowType = airflowType;
        this.shape = shape;
        this.wide = wide;
        this.height = height;
        this.supportPattern = supportPattern;
        this.aa = aa;
        this.tunnelType = tunnelType;
    }

    public Integer getTunnelId() {
        return tunnelId;
    }

    public void setTunnelId(Integer tunnelId) {
        this.tunnelId = tunnelId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getTunnelName() {
        return tunnelName;
    }

    public void setTunnelName(String tunnelName) {
        this.tunnelName = tunnelName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAirflowType() {
        return airflowType;
    }

    public void setAirflowType(String airflowType) {
        this.airflowType = airflowType;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSupportPattern() {
        return supportPattern;
    }

    public void setSupportPattern(String supportPattern) {
        this.supportPattern = supportPattern;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public String getTunnelType() {
        return tunnelType;
    }

    public void setTunnelType(String tunnelType) {
        this.tunnelType = tunnelType;
    }
}
