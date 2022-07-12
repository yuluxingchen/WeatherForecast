package com.qianhuan.logic.service.impl;

public interface ForecastImpl {
    /** 获取实时天气 */
    void getCurrentWeather();
    /** 获取最近七天的天气 */
    void getWeekWeather();
}
