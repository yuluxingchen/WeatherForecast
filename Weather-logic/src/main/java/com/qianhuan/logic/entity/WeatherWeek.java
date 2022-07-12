package com.qianhuan.logic.entity;

import com.qianhuan.common.annotation.Excel;

public class WeatherWeek extends WeatherBase{
    /** 预报日期 */
    @Excel(name = "预报日期")
    private String date;

    public WeatherWeek(String cityID, String cityName, String updateTime, String date, String wea, String wea_img, String temperature, String tempDay, String tempNight, String wind, String windDirection, String winSpeed, String air) {
        super(cityID, cityName, updateTime, wea, wea_img, temperature, tempDay, tempNight, wind, windDirection, winSpeed, air);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
