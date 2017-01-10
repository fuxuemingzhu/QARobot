package com.fuxuemingzhu.qarobot.utils;

import android.util.Log;

import com.fuxuemingzhu.qarobot.AppData;


/**
 * @author caifugui
 */
public class Logcat {
    public static final boolean DEBUG = AppData.getIsDebug();

    public static void d(String tag, String error) {
        if (DEBUG) {
            Log.d(tag, error);
        }
    }

    public static void e(String tag, String error) {
        if (DEBUG) {
            Log.e(tag, error);
        }
    }

    public static void i(String tag, String error) {
        if (DEBUG) {
            Log.i(tag, error);
        }
    }

    public static void w(String tag, String error) {
        if (DEBUG) {
            Log.w(tag, error);
        }
    }

    public static void v(String tag, String error) {
        if (DEBUG) {
            Log.v(tag, error);
        }
    }

}
