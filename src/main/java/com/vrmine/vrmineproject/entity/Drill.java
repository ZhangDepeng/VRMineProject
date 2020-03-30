package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/14-22:17
 */
public class Drill {

    private int drillID;

    private String drillName;

    private double drillX;

    private double drillY;

    private double drillZ;

    private double drillZ2;

    private double diam;

    private String stratigraphicCode;

    private double holeDepth;

    private double layerThickness;

    private String strataName;

    private String rockCharacteristic;

    public Drill() {
    }

    public Drill(int drillID, String drillName, double drillX, double drillY, double drillZ, double drillZ2, double diam, String stratigraphicCode, double holeDepth, double layerThickness, String strataName, String rockCharacteristic) {
        this.drillID = drillID;
        this.drillName = drillName;
        this.drillX = drillX;
        this.drillY = drillY;
        this.drillZ = drillZ;
        this.drillZ2 = drillZ2;
        this.diam = diam;
        this.stratigraphicCode = stratigraphicCode;
        this.holeDepth = holeDepth;
        this.layerThickness = layerThickness;
        this.strataName = strataName;
        this.rockCharacteristic = rockCharacteristic;
    }

    public int getDrillID() {
        return drillID;
    }

    public void setDrillID(int drillID) {
        this.drillID = drillID;
    }

    public String getDrillName() {
        return drillName;
    }

    public void setDrillName(String drillName) {
        this.drillName = drillName;
    }

    public double getDrillX() {
        return drillX;
    }

    public void setDrillX(double drillX) {
        this.drillX = drillX;
    }

    public double getDrillY() {
        return drillY;
    }

    public void setDrillY(double drillY) {
        this.drillY = drillY;
    }

    public double getDrillZ() {
        return drillZ;
    }

    public void setDrillZ(double drillZ) {
        this.drillZ = drillZ;
    }

    public double getDrillZ2() {
        return drillZ2;
    }

    public void setDrillZ2(double drillZ2) {
        this.drillZ2 = drillZ2;
    }

    public double getDiam() {
        return diam;
    }

    public void setDiam(double diam) {
        this.diam = diam;
    }

    public String getStratigraphicCode() {
        return stratigraphicCode;
    }

    public void setStratigraphicCode(String stratigraphicCode) {
        this.stratigraphicCode = stratigraphicCode;
    }

    public double getHoleDepth() {
        return holeDepth;
    }

    public void setHoleDepth(double holeDepth) {
        this.holeDepth = holeDepth;
    }

    public double getLayerThickness() {
        return layerThickness;
    }

    public void setLayerThickness(double layerThickness) {
        this.layerThickness = layerThickness;
    }

    public String getStrataName() {
        return strataName;
    }

    public void setStrataName(String strataName) {
        this.strataName = strataName;
    }

    public String getRockCharacteristic() {
        return rockCharacteristic;
    }

    public void setRockCharacteristic(String rockCharacteristic) {
        this.rockCharacteristic = rockCharacteristic;
    }
}
