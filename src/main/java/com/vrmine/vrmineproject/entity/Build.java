package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/14-22:12
 */
public class Build {
    private int buildingID;

    private String buildingName;

    private String ModelName;

    private int modelType;

    private int tableType;

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

    public Build() {
    }

    public Build(int buildingID, String buildingName, String modelName, int modelType, int tableType, double posX, double posY, double posZ, double rotationX, double rotationY, double rotationZ, double scaleX, double scaleY, double scaleZ, double transX, double transY, double transZ) {
        this.buildingID = buildingID;
        this.buildingName = buildingName;
        ModelName = modelName;
        this.modelType = modelType;
        this.tableType = tableType;
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

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
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
