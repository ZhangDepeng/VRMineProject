package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/10-20:48
 */
public class Persorientatio {

    private int ID;

    private String Name;

    private String ModelName;

    private int modelType;

    private int tableType;

    private String Installationsite;

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

    private String tunnelName;

    public Persorientatio() {
    }

    public Persorientatio(int ID, String name, String modelName, int modelType, int tableType, String installationsite, double posX, double posY, double posZ, double rotationX, double rotationY, double rotationZ, double scaleX, double scaleY, double scaleZ, double transX, double transY, double transZ, String tunnelName) {
        this.ID = ID;
        Name = name;
        ModelName = modelName;
        this.modelType = modelType;
        this.tableType = tableType;
        Installationsite = installationsite;
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
        tunnelName = tunnelName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getInstallationsite() {
        return Installationsite;
    }

    public void setInstallationsite(String installationsite) {
        Installationsite = installationsite;
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

    public String getTunnelName() {
        return tunnelName;
    }

    public void setTunnelName(String tunnelName) {
        this.tunnelName = tunnelName;
    }
}
