package com.ruoyi.DocSys.domain;

import java.util.Date;

public class UserBasicInfo {
    private Long id;
    private String name;
    private Double weight;
    private Double height;
    private String gender;
    private Long age;
    private String smoking;
    private Double temp;
    private Double tempCut;
    private Long pulse;
    private Long sbp;
    private Long dbp;
    private String swelling;
    private Long knee;
    private Long step;
    private Long pain;
    private String decri;
    private Long predictResult;
    private Long doctorResult;
    private Date createTime;
    private Date updateTime;

    public UserBasicInfo() {
    }

    public UserBasicInfo(Long id, String name, Double weight, Double height, String gender, Long age, String smoking, Double temp, Double tempCut, Long pulse, Long sbp, Long dbp, String swelling, Long knee, Long step, Long pain, String decri, Long predictResult, Long doctorResult, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.smoking = smoking;
        this.temp = temp;
        this.tempCut = tempCut;
        this.pulse = pulse;
        this.sbp = sbp;
        this.dbp = dbp;
        this.swelling = swelling;
        this.knee = knee;
        this.step = step;
        this.pain = pain;
        this.decri = decri;
        this.predictResult = predictResult;
        this.doctorResult = doctorResult;
        this.createTime = createTime;
        this.updateTime = updateTime;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 获取
     * @return height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public Long getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * 获取
     * @return smoking
     */
    public String getSmoking() {
        return smoking;
    }

    /**
     * 设置
     * @param smoking
     */
    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    /**
     * 获取
     * @return temp
     */
    public Double getTemp() {
        return temp;
    }

    /**
     * 设置
     * @param temp
     */
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    /**
     * 获取
     * @return tempCut
     */
    public Double getTempCut() {
        return tempCut;
    }

    /**
     * 设置
     * @param tempCut
     */
    public void setTempCut(Double tempCut) {
        this.tempCut = tempCut;
    }

    /**
     * 获取
     * @return pulse
     */
    public Long getPulse() {
        return pulse;
    }

    /**
     * 设置
     * @param pulse
     */
    public void setPulse(Long pulse) {
        this.pulse = pulse;
    }

    /**
     * 获取
     * @return sbp
     */
    public Long getSbp() {
        return sbp;
    }

    /**
     * 设置
     * @param sbp
     */
    public void setSbp(Long sbp) {
        this.sbp = sbp;
    }

    /**
     * 获取
     * @return dbp
     */
    public Long getDbp() {
        return dbp;
    }

    /**
     * 设置
     * @param dbp
     */
    public void setDbp(Long dbp) {
        this.dbp = dbp;
    }

    /**
     * 获取
     * @return swelling
     */
    public String getSwelling() {
        return swelling;
    }

    /**
     * 设置
     * @param swelling
     */
    public void setSwelling(String swelling) {
        this.swelling = swelling;
    }

    /**
     * 获取
     * @return knee
     */
    public Long getKnee() {
        return knee;
    }

    /**
     * 设置
     * @param knee
     */
    public void setKnee(Long knee) {
        this.knee = knee;
    }

    /**
     * 获取
     * @return step
     */
    public Long getStep() {
        return step;
    }

    /**
     * 设置
     * @param step
     */
    public void setStep(Long step) {
        this.step = step;
    }

    /**
     * 获取
     * @return pain
     */
    public Long getPain() {
        return pain;
    }

    /**
     * 设置
     * @param pain
     */
    public void setPain(Long pain) {
        this.pain = pain;
    }

    /**
     * 获取
     * @return decri
     */
    public String getDecri() {
        return decri;
    }

    /**
     * 设置
     * @param decri
     */
    public void setDecri(String decri) {
        this.decri = decri;
    }

    /**
     * 获取
     * @return predictResult
     */
    public Long getPredictResult() {
        return predictResult;
    }

    /**
     * 设置
     * @param predictResult
     */
    public void setPredictResult(Long predictResult) {
        this.predictResult = predictResult;
    }

    /**
     * 获取
     * @return doctorResult
     */
    public Long getDoctorResult() {
        return doctorResult;
    }

    /**
     * 设置
     * @param doctorResult
     */
    public void setDoctorResult(Long doctorResult) {
        this.doctorResult = doctorResult;
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

    public String toString() {
        return "userBasicInfo{id = " + id + ", name = " + name + ", weight = " + weight + ", height = " + height + ", gender = " + gender + ", age = " + age + ", smoking = " + smoking + ", temp = " + temp + ", tempCut = " + tempCut + ", pulse = " + pulse + ", sbp = " + sbp + ", dbp = " + dbp + ", swelling = " + swelling + ", knee = " + knee + ", step = " + step + ", pain = " + pain + ", decri = " + decri + ", predictResult = " + predictResult + ", doctorResult = " + doctorResult + ", createTime = " + createTime + ", updateTime = " + updateTime + "}";
    }
}
