package com.qianhuan.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 读取项目相关配置
 *
 * @author yuluxingchen
 */
@Component // 将此类标记为Spring容器中的一个Bean
@ConfigurationProperties(prefix = "qianhuan") //用于获取配置文件中的属性定义并绑定到Java Bean或属性中
public class QianHuanConfig {
    /** 项目名称 */
    private String name;

    /** 版本 */
    private String version;

    /** 版权年份 */
    private String copyrightYear;

    /** 实例演示开关 */
    private boolean demoEnabled;

    /** 上传路径 */
    private static String profile;

    /** 地址开关 */
    private static boolean addressEnabled;

    /** 验证码类型 */
    private static String captchaType;

    /** 获取项目名称 */
    public String getName()
    {
        return name;
    }

    /** 设置项目名称 */
    public void setName(String name)
    {
        this.name = name;
    }

    /** 获取版本 */
    public String getVersion()
    {
        return version;
    }

    /** 设置版本*/
    public void setVersion(String version)
    {
        this.version = version;
    }

    /** 获取版权年份 */
    public String getCopyrightYear()
    {
        return copyrightYear;
    }

    /** 设置版权年份 */
    public void setCopyrightYear(String copyrightYear)
    {
        this.copyrightYear = copyrightYear;
    }

    /** 获取实例演示开关 */
    public boolean isDemoEnabled()
    {
        return demoEnabled;
    }

    /** 设置实例演示开关 */
    public void setDemoEnabled(boolean demoEnabled)
    {
        this.demoEnabled = demoEnabled;
    }

    /** 获取上传路径 */
    public static String getProfile()
    {
        return profile;
    }

    /** 设置上传路径 */
    public void setProfile(String profile)
    {
        QianHuanConfig.profile = profile;
    }

    /** 获取地址开关 */
    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    /** 设置地址开关 */
    public void setAddressEnabled(boolean addressEnabled)
    {
        QianHuanConfig.addressEnabled = addressEnabled;
    }

    /** 获取验证码类型 */
    public static String getCaptchaType() {
        return captchaType;
    }

    /** 设置验证码类型*/
    public void setCaptchaType(String captchaType) {
        QianHuanConfig.captchaType = captchaType;
    }

    /**
     * 获取导入上传路径
     */
    public static String getImportPath()
    {
        return getProfile() + "/import";
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}
