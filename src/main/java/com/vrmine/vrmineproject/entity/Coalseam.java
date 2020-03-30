package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/14-22:16
 */
public class Coalseam {

    private int coalSeamID;

    private String coalSeamNum;

    private double coalSeamX;

    private double coalSeamY;

    private double coalSeamH;

    private String coalSeamName;

    private String coalSeamType;

    public Coalseam() {
    }

    public Coalseam(int coalSeamID, String coalSeamNum, double coalSeamX, double coalSeamY, double coalSeamH, String coalSeamName, String coalSeamType) {
        this.coalSeamID = coalSeamID;
        this.coalSeamNum = coalSeamNum;
        this.coalSeamX = coalSeamX;
        this.coalSeamY = coalSeamY;
        this.coalSeamH = coalSeamH;
        this.coalSeamName = coalSeamName;
        this.coalSeamType = coalSeamType;
    }

    public int getCoalSeamID() {
        return coalSeamID;
    }

    public void setCoalSeamID(int coalSeamID) {
        this.coalSeamID = coalSeamID;
    }

    public String getCoalSeamNum() {
        return coalSeamNum;
    }

    public void setCoalSeamNum(String coalSeamNum) {
        this.coalSeamNum = coalSeamNum;
    }

    public double getCoalSeamX() {
        return coalSeamX;
    }

    public void setCoalSeamX(double coalSeamX) {
        this.coalSeamX = coalSeamX;
    }

    public double getCoalSeamY() {
        return coalSeamY;
    }

    public void setCoalSeamY(double coalSeamY) {
        this.coalSeamY = coalSeamY;
    }

    public double getCoalSeamH() {
        return coalSeamH;
    }

    public void setCoalSeamH(double coalSeamH) {
        this.coalSeamH = coalSeamH;
    }

    public String getCoalSeamName() {
        return coalSeamName;
    }

    public void setCoalSeamName(String coalSeamName) {
        this.coalSeamName = coalSeamName;
    }

    public String getCoalSeamType() {
        return coalSeamType;
    }

    public void setCoalSeamType(String coalSeamType) {
        this.coalSeamType = coalSeamType;
    }
}
