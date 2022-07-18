package com.qianhuan.web.controller.system;

import com.qianhuan.common.config.QianHuanConfig;
import com.qianhuan.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author yuluxingchen
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private QianHuanConfig QianHuanConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}，当前版本：v{}，请通过前端地址访问。", QianHuanConfig.getName(), QianHuanConfig.getVersion());
    }
}
