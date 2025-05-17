package com.ruoyi.DocSys.domain;

public class PatientSelect {
    private String name;
    private String phone;

    public PatientSelect() {
    }

    public PatientSelect(String name, String phone) {
        this.name = name;
        this.phone = phone;
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "PatientSelect{name = " + name + ", phone = " + phone + "}";
    }
}
