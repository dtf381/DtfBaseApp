package com.cgw.user_module.base;

import android.app.Application;

import com.cgw.base_module.base.BaseApplication;


/**
 * Created by Dongdd on 2018/6/21 15:07.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplication.application = this;
        BaseApplication.context = getApplicationContext();
    }

}
