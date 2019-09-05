package com.example.undertakes.entity;

/**
 * @author Carl
 * @ClassName test
 * @Description
 * @date 2019-09-02 16:19
 **/
public class test {

    /**
     * mainSupplierDay : 1
     * mainSupplierNum : 3
     * noMainSupplierPriceRateMax : 2.0
     * noMainSupplierPriceRateMin : 1.1
     * status : true
     * systemChargeRate : 0.9
     * taskSwitch : true
     */

    private int mainSupplierDay;
    private int mainSupplierNum;
    private double noMainSupplierPriceRateMax;
    private double noMainSupplierPriceRateMin;
    private boolean status;
    private double systemChargeRate;
    private boolean taskSwitch;

    public int getMainSupplierDay() {
        return mainSupplierDay;
    }

    public void setMainSupplierDay(int mainSupplierDay) {
        this.mainSupplierDay = mainSupplierDay;
    }

    public int getMainSupplierNum() {
        return mainSupplierNum;
    }

    public void setMainSupplierNum(int mainSupplierNum) {
        this.mainSupplierNum = mainSupplierNum;
    }

    public double getNoMainSupplierPriceRateMax() {
        return noMainSupplierPriceRateMax;
    }

    public void setNoMainSupplierPriceRateMax(double noMainSupplierPriceRateMax) {
        this.noMainSupplierPriceRateMax = noMainSupplierPriceRateMax;
    }

    public double getNoMainSupplierPriceRateMin() {
        return noMainSupplierPriceRateMin;
    }

    public void setNoMainSupplierPriceRateMin(double noMainSupplierPriceRateMin) {
        this.noMainSupplierPriceRateMin = noMainSupplierPriceRateMin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSystemChargeRate() {
        return systemChargeRate;
    }

    public void setSystemChargeRate(double systemChargeRate) {
        this.systemChargeRate = systemChargeRate;
    }

    public boolean isTaskSwitch() {
        return taskSwitch;
    }

    public void setTaskSwitch(boolean taskSwitch) {
        this.taskSwitch = taskSwitch;
    }
}
