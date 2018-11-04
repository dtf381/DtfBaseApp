package com.cgw.base_module.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 提示框
 * dongdd on 2016/2/6 12:28
 */
public class ToastUtils {

    private static Toast toast;

    /**
     * 弹出默认的短时间Toast
     *
     * @param context
     * @param msg
     */
    public static void showToastDefault(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param context
     * @param message Toast.LENGTH_SHORT = 2s Toast.LENGTH_LONG = 3.5s
     */
    public static void showToast(Context context, String message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * @param context
     * @param message Toast.LENGTH_SHORT = 2s Toast.LENGTH_LONG = 3.5s
     */
    public static void showToast(Context context, int message) {
        if (toast == null) {
            toast = Toast.makeText(context, context.getResources().getString(message), Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

}
