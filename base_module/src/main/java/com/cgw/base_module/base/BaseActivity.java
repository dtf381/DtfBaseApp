package com.cgw.base_module.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.cgw.base_module.BuildConfig;
import com.cgw.base_module.utils.ToastUtils;
import com.socks.library.KLog;


/**
 * dongtengfei on 2018/9/19 09:35
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        KLog.init(BuildConfig.DEBUG);
        context = getApplicationContext();
        initView();
        initData();
    }


    /**
     * 初始化视图文件
     *
     * @return
     */
    public abstract int initLayoutId();

    /**
     * 初始化视图布局效果
     */
    public abstract void initView();

    /**
     * 初始化视图数据
     */
    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * toast提示框
     *
     * @param msg
     */
    protected void showToast(String msg) {
        ToastUtils.showToast(getApplication().getApplicationContext(), msg);
    }

    protected void showToast(int msg) {
        ToastUtils.showToast(getApplication().getApplicationContext(), getResources().getString(msg));
    }

    /**
     * 定义全局单例模式的系统对象
     *
     * @return
     */
    public static synchronized Context context() {
        return context.getApplicationContext();
    }

    /**
     * 设置透明状态栏
     *
     * @param on
     */
    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    /**
     * 获取当前设备状态栏高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
