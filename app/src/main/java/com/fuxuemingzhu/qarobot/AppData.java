package com.fuxuemingzhu.qarobot;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class AppData {

    private static AppData mInstance;

    public static final boolean IS_DEBUG = true;
    public static final String COMPANY_PROJECT_NAMESPACE = "com.fuxuemingzhu.qarobot";
    private static final String KEY_SHOW_WELCOME = "isFirstRun";
    private static final String DEFAULT_CONTENT = "default_content";
    public static SharedPreferences spf;
    public static Editor editor;

    /**
     * 设置分页内容的字体格式
     */
    public static final int NOTIFY_TEXT = 24;
    public static final int SELLP_TEXT = 18;

    /**
     * 创建一个新的实例 AppData.
     */
    private AppData(Context context) {
        spf = context.getSharedPreferences(COMPANY_PROJECT_NAMESPACE,
                Context.MODE_PRIVATE);
    }

    public static AppData getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AppData.class) {
                if (mInstance == null) {
                    mInstance = new AppData(context);
                    if (spf != null) {
                        editor = spf.edit();
                    }
                }
            }
        }
        return mInstance;
    }

    public static void initData(Context ctx) {
        spf = ctx.getSharedPreferences(COMPANY_PROJECT_NAMESPACE,
                Context.MODE_PRIVATE);
        if (spf != null) {
            editor = spf.edit();
        }
    }

    /**
     * saveData(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
     *
     * @param key void
     *
     * @since 1.0.0
     */
    public static void saveData(String key, boolean value) {
        // TODO Auto-generated method stub
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void saveData(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static void saveData(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public static String getData(String key) {
        return spf.getString(key, "");
    }

    /**
     * getBoolean(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
     *
     * @return boolean
     *
     * @since 1.0.0
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        // TODO Auto-generated method stub
        return spf.getBoolean(key, defaultValue);
    }

    /**
     * 清除指定数据
     *
     * @param key
     */
    public static void clearData(String key) {
        editor.remove(key);
        editor.commit();
    }

    public boolean isFirstRun() {
        return spf.getBoolean(KEY_SHOW_WELCOME, true);
    }

    public void disableFirstRun() {
        Editor editor = spf.edit();
        editor.putBoolean(KEY_SHOW_WELCOME, false);
        editor.apply();
    }

    public String getDefaultContent() {
        return spf.getString(DEFAULT_CONTENT, "");
    }

    public void setDefaultContent(String defaultContent) {
        Editor editor = spf.edit();
        editor.putString(DEFAULT_CONTENT, defaultContent);
        editor.apply();
    }

    public static boolean getIsDebug() {
        return IS_DEBUG;
    }
}
