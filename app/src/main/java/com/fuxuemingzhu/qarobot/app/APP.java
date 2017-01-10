package com.fuxuemingzhu.qarobot.app;

import android.app.Application;

import com.fuxuemingzhu.qarobot.BuildConfig;
import com.fuxuemingzhu.qarobot.MyActivityLifeCycleDelegate;
import com.jude.beam.Beam;
import com.jude.http.RequestManager;
import com.jude.utils.JUtils;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JUtils.initialize(this);
        JUtils.setDebug(BuildConfig.DEBUG, "RobotLog");
        RequestManager.getInstance().init(this);
        RequestManager.getInstance().setDebugMode(BuildConfig.DEBUG, "RobotNet");
        Beam.init(this);
        Beam.setActivityLifeCycleDelegateProvider(MyActivityLifeCycleDelegate::new);
    }
}
