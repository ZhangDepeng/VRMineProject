package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/14-22:17
 */
public class Fault {

    private int faultID;

    private int faultName;

    private double faultX;

    private double faultY;

    private double faultH;

    private double faultDipAngle;

    private double faultUpHeight;

    private double faultDownHeight;

    public Fault() {
    }

    public Fault(int faultID, int faultName, double faultX, double faultY, double faultH, double faultDipAngle, double faultUpHeight, double faultDownHeight) {
        this.faultID = faultID;
        this.faultName = faultName;
        this.faultX = faultX;
        this.faultY = faultY;
        this.faultH = faultH;
        this.faultDipAngle = faultDipAngle;
        this.faultUpHeight = faultUpHeight;
        this.faultDownHeight = faultDownHeight;
    }

    public int getFaultID() {
        return faultID;
    }

    public void setFaultID(int faultID) {
        this.faultID = faultID;
    }

    public int getFaultName() {
        return faultName;
    }

    public void setFaultName(int faultName) {
        this.faultName = faultName;
    }

    public double getFaultX() {
        return faultX;
    }

    public void setFaultX(double faultX) {
        this.faultX = faultX;
    }

    public double getFaultY() {
        return faultY;
    }

    public void setFaultY(double faultY) {
        this.faultY = faultY;
    }

    public double getFaultH() {
        return faultH;
    }

    public void setFaultH(double faultH) {
        this.faultH = faultH;
    }

    public double getFaultDipAngle() {
        return faultDipAngle;
    }

    public void setFaultDipAngle(double faultDipAngle) {
        this.faultDipAngle = faultDipAngle;
    }

    public double getFaultUpHeight() {
        return faultUpHeight;
    }

    public void setFaultUpHeight(double faultUpHeight) {
        this.faultUpHeight = faultUpHeight;
    }

    public double getFaultDownHeight() {
        return faultDownHeight;
    }

    public void setFaultDownHeight(double faultDownHeight) {
        this.faultDownHeight = faultDownHeight;
    }
}
