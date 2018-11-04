package com.cgw.base_module.base;

import android.app.Application;
import android.content.Context;

import com.socks.library.KLog;

/**
 * 项目系统配置和初始化
 * dongdd on 2017/5/19 09:48
 */
public class BaseApplication {
    public static Application application = null;
    public static Context context = null;
    private static BaseApplication instance;

    /**
     * 终端设备号
     */
    public static String simCardNo;

    public static boolean flagMonitorOptimization = false;
    public static synchronized BaseApplication getInstance() {
        if (null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    /**
     * 定义全局单例模式的系统对象
     *
     * @return
     */
    public static synchronized Context context() {
        return (Context) context;
    }

    /**
     * 初始化日志
     */
    public void initLog(boolean isShowLog) {
        KLog.init(isShowLog);
    }



}
