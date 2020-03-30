package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/11-20:00
 */
public class Sensor {

    private int sensorID;

    private String sensorName;

    private String modelName;

    private String deviceName;

    private int modelType;

    private int tableType;

    private int sensorType;

    private String position;

    private double posX;

    private double posY;

    private double posZ;

    private double RotationX;

    private double RotationY;

    private double RotationZ;

    private double ScaleX;

    private double ScaleY;

    private double ScaleZ;

    private double TransX;

    private double TransY;

    private double TransZ;

    public Sensor() {
    }

    public Sensor(int sensorID, String sensorName, String modelName, String deviceName, int modelType, int tableType, int sensorType, String position, double posX, double posY, double posZ, double rotationX, double rotationY, double rotationZ, double scaleX, double scaleY, double scaleZ, double transX, double transY, double transZ) {
        this.sensorID = sensorID;
        this.sensorName = sensorName;
        this.modelName = modelName;
        this.deviceName = deviceName;
        this.modelType = modelType;
        this.tableType = tableType;
        this.sensorType = sensorType;
        this.position = position;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        RotationX = rotationX;
        RotationY = rotationY;
        RotationZ = rotationZ;
        ScaleX = scaleX;
        ScaleY = scaleY;
        ScaleZ = scaleZ;
        TransX = transX;
        TransY = transY;
        TransZ = transZ;
    }

    public int getSensorID() {
        return sensorID;
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getdeviceName() {
        return deviceName;
    }

    public void setdeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }

    public int getTableType() {
        return tableType;
    }

    public void setTableType(int tableType) {
        this.tableType = tableType;
    }

    public int getSensorType() {
        return sensorType;
    }

    public void setSensorType(int sensorType) {
        this.sensorType = sensorType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public double getRotationX() {
        return RotationX;
    }

    public void setRotationX(double rotationX) {
        RotationX = rotationX;
    }

    public double getRotationY() {
        return RotationY;
    }

    public void setRotationY(double rotationY) {
        RotationY = rotationY;
    }

    public double getRotationZ() {
        return RotationZ;
    }

    public void setRotationZ(double rotationZ) {
        RotationZ = rotationZ;
    }

    public double getScaleX() {
        return ScaleX;
    }

    public void setScaleX(double scaleX) {
        ScaleX = scaleX;
    }

    public double getScaleY() {
        return ScaleY;
    }

    public void setScaleY(double scaleY) {
        ScaleY = scaleY;
    }

    public double getScaleZ() {
        return ScaleZ;
    }

    public void setScaleZ(double scaleZ) {
        ScaleZ = scaleZ;
    }

    public double getTransX() {
        return TransX;
    }

    public void setTransX(double transX) {
        TransX = transX;
    }

    public double getTransY() {
        return TransY;
    }

    public void setTransY(double transY) {
        TransY = transY;
    }

    public double getTransZ() {
        return TransZ;
    }

    public void setTransZ(double transZ) {
        TransZ = transZ;
    }
}
