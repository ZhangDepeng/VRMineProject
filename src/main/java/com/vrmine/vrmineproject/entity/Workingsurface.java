package com.vrmine.vrmineproject.entity;

/**
 * @author zdp
 * @data 2019/12/14-22:18
 */
public class Workingsurface {
    private int workingSurfaceID;

    private String workingSurfaceName;

    private double workingSurfaceX;

    private double workingSurfaceY;

    private double workingSurfaceH;

    private int workingSurfaceType;

    public Workingsurface() {
    }

    public Workingsurface(int workingSurfaceID, String workingSurfaceName, double workingSurfaceX, double workingSurfaceY, double workingSurfaceH, int workingSurfaceType) {
        this.workingSurfaceID = workingSurfaceID;
        this.workingSurfaceName = workingSurfaceName;
        this.workingSurfaceX = workingSurfaceX;
        this.workingSurfaceY = workingSurfaceY;
        this.workingSurfaceH = workingSurfaceH;
        this.workingSurfaceType = workingSurfaceType;
    }

    public int getWorkingSurfaceID() {
        return workingSurfaceID;
    }

    public void setWorkingSurfaceID(int workingSurfaceID) {
        this.workingSurfaceID = workingSurfaceID;
    }

    public String getWorkingSurfaceName() {
        return workingSurfaceName;
    }

    public void setWorkingSurfaceName(String workingSurfaceName) {
        this.workingSurfaceName = workingSurfaceName;
    }

    public double getWorkingSurfaceX() {
        return workingSurfaceX;
    }

    public void setWorkingSurfaceX(double workingSurfaceX) {
        this.workingSurfaceX = workingSurfaceX;
    }

    public double getWorkingSurfaceY() {
        return workingSurfaceY;
    }

    public void setWorkingSurfaceY(double workingSurfaceY) {
        this.workingSurfaceY = workingSurfaceY;
    }

    public double getWorkingSurfaceH() {
        return workingSurfaceH;
    }

    public void setWorkingSurfaceH(double workingSurfaceH) {
        this.workingSurfaceH = workingSurfaceH;
    }

    public int getWorkingSurfaceType() {
        return workingSurfaceType;
    }

    public void setWorkingSurfaceType(int workingSurfaceType) {
        this.workingSurfaceType = workingSurfaceType;
    }
}
