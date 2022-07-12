package com.qianhuan.logic.config;

public class WeatherConfig {
    /** 当前城市编码 */
    private String currentCity = "101090201";

    private String websiteSK = "http://www.weather.com.cn/data/sk/";

    private String websiteWeek = "http://mobile.weather.com.cn/data/forecast/";

    private String requestFormat = ".html";

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getWebsite() {
        return websiteSK;
    }

    public void setWebsite(String website) {
        this.websiteSK = website;
    }

    public String getWebsiteWeek() {
        return websiteWeek;
    }

    public void setWebsiteWeek(String websiteWeek) {
        this.websiteWeek = websiteWeek;
    }

    public String getRequestFormat() {
        return requestFormat;
    }

    public void setRequestFormat(String requestFormat) {
        this.requestFormat = requestFormat;
    }

    public String getRequestUrl() {
        return websiteSK + currentCity + requestFormat;
    }
}
