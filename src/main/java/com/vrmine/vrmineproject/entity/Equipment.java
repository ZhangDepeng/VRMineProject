package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/11-18:46
 */
public class Equipment {

    private int equipmentID;

    private String equipmentName;

    private String modelName;

    private String equipmentType;

    private int modelType;

    private int tableType;

    private String type;

    private String parameters;

    private String manufacturer;

    private String equipmentNum;

    private String equipmentDate;

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

    public Equipment() {
    }

    public Equipment(int equipmentID, String equipmentName, String modelName, String equipmentType, int modelType, int tableType, String type, String parameters, String manufacturer, String equipmentNum, String equipmentDate, String position, double posX, double posY, double posZ, double rotationX, double rotationY, double rotationZ, double scaleX, double scaleY, double scaleZ, double transX, double transY, double transZ) {
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.modelName = modelName;
        this.equipmentType = equipmentType;
        this.modelType = modelType;
        this.tableType = tableType;
        this.type = type;
        this.parameters = parameters;
        this.manufacturer = manufacturer;
        this.equipmentNum = equipmentNum;
        this.equipmentDate = equipmentDate;
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

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEquipmentNum() {
        return equipmentNum;
    }

    public void setEquipmentNum(String equipmentNum) {
        this.equipmentNum = equipmentNum;
    }

    public String getEquipmentDate() {
        return equipmentDate;
    }

    public void setEquipmentDate(String equipmentDate) {
        this.equipmentDate = equipmentDate;
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
