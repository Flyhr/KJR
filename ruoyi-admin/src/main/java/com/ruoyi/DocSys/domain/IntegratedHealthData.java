package com.ruoyi.DocSys.domain;

import java.util.Date;

public class IntegratedHealthData {
    private Long id;
    private String deviceName;
    private String deviceMac;
    private Long userId;
    private Date createTime;
    private Date updateTime;
    private Double knee;         // 屈膝度，保留1位小数
    private Double temperature;  // 温度，保留1位小数
    private Integer walk;        // 步数
    private Double speed;
    private Double distance;
    private String remark;

    public IntegratedHealthData() {
    }

    public IntegratedHealthData(Long id, String deviceName, String deviceMac, Long userId, Date createTime, Date updateTime, Double knee, Double temperature, Integer walk, Double speed, Double distance, String remark) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceMac = deviceMac;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.knee = knee;
        this.temperature = temperature;
        this.walk = walk;
        this.speed = speed;
        this.distance = distance;
        this.remark = remark;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设置
     * @param deviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * 获取
     * @return deviceMac
     */
    public String getDeviceMac() {
        return deviceMac;
    }

    /**
     * 设置
     * @param deviceMac
     */
    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return knee
     */
    public Double getKnee() {
        return knee;
    }

    /**
     * 设置
     * @param knee
     */
    public void setKnee(Double knee) {
        this.knee = knee;
    }

    /**
     * 获取
     * @return temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * 设置
     * @param temperature
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * 获取
     * @return walk
     */
    public Integer getWalk() {
        return walk;
    }

    /**
     * 设置
     * @param walk
     */
    public void setWalk(Integer walk) {
        this.walk = walk;
    }

    /**
     * 获取
     * @return speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置
     * @param speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取
     * @return distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * 设置
     * @param distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "SensorData{id = " + id + ", deviceName = " + deviceName + ", deviceMac = " + deviceMac + ", userId = " + userId + ", createTime = " + createTime + ", updateTime = " + updateTime + ", knee = " + knee + ", temperature = " + temperature + ", walk = " + walk + ", speed = " + speed + ", distance = " + distance + ", remark = " + remark + "}";
    }

    // getters & setters
}
