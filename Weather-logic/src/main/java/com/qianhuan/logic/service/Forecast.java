package com.qianhuan.logic.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.qianhuan.logic.config.WeatherConfig;
import com.qianhuan.logic.entity.WeatherSk;
import com.qianhuan.logic.service.impl.ForecastImpl;
import com.qianhuan.logic.utils.ApiUtils;

public class Forecast implements ForecastImpl {

    /** 读取网址 */
    public WeatherConfig config = new WeatherConfig();

    /**
     * 获取实时天气
     */
    @Override
    public void getCurrentWeather() {
        String url = config.getRequestUrl();
        String result = ApiUtils.doGet(url);
        JSONObject jsonObj = JSON.parseObject(result);
        String s = jsonObj.get("weatherinfo").toString();
        System.out.println(s);
        WeatherSk weather = JSON.parseObject(s, WeatherSk.class);
        System.out.println(weather.toString());
    }

    /**
     * 获取最近七天的天气
     */
    @Override
    public void getWeekWeather() {

    }
}
