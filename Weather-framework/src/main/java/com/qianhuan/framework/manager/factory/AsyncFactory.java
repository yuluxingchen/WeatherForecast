package com.qianhuan.framework.manager.factory;

import com.qianhuan.common.utils.ip.AddressUtils;
import com.qianhuan.common.utils.spring.SpringUtils;
import com.qianhuan.system.domain.SysOperLog;
import com.qianhuan.system.service.ISysOperLogService;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 * 
 * @author qianhuan
 */
public class AsyncFactory
{
    /**
     * 操作日志记录
     * 
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }
}
