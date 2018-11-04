package com.cgw.base_module.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.cgw.base_module.base.BaseConfig;
import com.socks.library.KLog;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * App本地文件存储加解密处理
 * http://blog.csdn.net/lmj623565791/article/details/38965311
 * dongdd on 2017/5/31 17:38
 */

public class SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    public static String FILE_NAME = "share_data";

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param express
     */
    public static String put(Context context, String key, String express) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (express.length() > 0) {
            editor.putString(key, express);
        } else {
            editor.putString(key, express);
        }
        SPUtils.SharedPreferencesCompat.apply(editor);
        return key;
    }


    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        String ciphertext = sp.getString(key, ""); //  从本地文件中获取密文
        if (ciphertext == null || ciphertext.length() == 0) {
            return defaultObject; // 如果获取到的密文为空则直接返回默认值
        }
        try {
            String value = ciphertext; // 对密文进行解密
            if (value == null) {
                return defaultObject;
            }
            if (defaultObject instanceof String) {
                return value;
            } else if (defaultObject instanceof Integer) {
                return Integer.parseInt(value);
            } else if (defaultObject instanceof Boolean) {
                return Boolean.parseBoolean(value);
            } else if (defaultObject instanceof Float) {
                return Float.parseFloat(value);
            } else if (defaultObject instanceof Long) {
                return Long.parseLong(value);
            }
        } catch (Exception e) {
            KLog.e(BaseConfig.LOG, "SP解密异常：" + e.getMessage());
            return defaultObject;
        }
        return null;
    }


    /**
     * 移除某个key值已经对应的值
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SPUtils.SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SPUtils.SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (Exception e) {
            }
            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }

}
