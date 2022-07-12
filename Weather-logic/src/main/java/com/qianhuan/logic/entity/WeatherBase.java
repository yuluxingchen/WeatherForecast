package com.qianhuan.logic.entity;

import com.qianhuan.common.annotation.Excel;

public class WeatherBase {
    /** 城市ID */
    @Excel(name = "城市ID")
    private String cityID;
    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;
    /** 更新时间 */
    @Excel(name = "更新时间")
    private String updateTime;
    /** 天气情况 */
    @Excel(name = "天气情况")
    private String wea;
    /** 天气对应图标 */
    @Excel(name = "天气对应图标")
    private String wea_img;
    /* 实时温度 */
    @Excel(name = "实时温度")
    private String temperature;
    /** 最高气温 */
    @Excel(name = "最高气温")
    private String tempDay;
    /** 最低气温 */
    @Excel(name = "最低气温")
    private String tempNight;
    /** 风向 */
    @Excel(name = "风向")
    private String wind;
    /** 风力 */
    @Excel(name = "风力")
    private String windDirection;
    /** 风速 */
    @Excel(name = "风速")
    private String winSpeed;
    /** 空气质量 */
    @Excel(name = "空气质量")
    private String air;

    public WeatherBase(String cityID, String cityName, String updateTime, String wea, String wea_img, String temperature, String tempDay, String tempNight, String wind, String windDirection, String winSpeed, String air) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.updateTime = updateTime;
        this.wea = wea;
        this.wea_img = wea_img;
        this.temperature = temperature;
        this.tempDay = tempDay;
        this.tempNight = tempNight;
        this.wind = wind;
        this.windDirection = windDirection;
        this.winSpeed = winSpeed;
        this.air = air;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public String getWea_img() {
        return wea_img;
    }

    public void setWea_img(String wea_img) {
        this.wea_img = wea_img;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTempDay() {
        return tempDay;
    }

    public void setTempDay(String tempDay) {
        this.tempDay = tempDay;
    }

    public String getTempNight() {
        return tempNight;
    }

    public void setTempNight(String tempNight) {
        this.tempNight = tempNight;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWinSpeed() {
        return winSpeed;
    }

    public void setWinSpeed(String winSpeed) {
        this.winSpeed = winSpeed;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }
}
