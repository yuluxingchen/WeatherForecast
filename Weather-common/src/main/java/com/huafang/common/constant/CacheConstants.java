package com.huafang.common.constant;

/**
 * 缓存的Key常量
 *
 * @author yuluxingchen
 */
public class CacheConstants {
    /**
     * 登录用户的 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码的 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理的 redis key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理的 redis key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 防重提交的 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流的 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";
}
