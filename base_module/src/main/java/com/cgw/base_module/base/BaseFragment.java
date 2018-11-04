package com.cgw.base_module.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.cgw.base_module.utils.ToastUtils;


/**
 * dongtengfei on 2018/9/19 09:35
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(initLayoutId(), container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        initView();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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

    /**
     * toast提示框
     *
     * @param msg
     */
    protected void showToast(String msg) {
        ToastUtils.showToast(getActivity().getApplication().getApplicationContext(), msg);
    }

    protected void showToast(int msg) {
        ToastUtils.showToast(getActivity().getApplication().getApplicationContext(), getResources().getString(msg));
    }

    /**
     * 设置透明状态栏
     *
     * @param on
     */
    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getActivity().getWindow();
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
