package com.fuxuemingzhu.qarobot;

import android.content.Context;

import com.fuxuemingzhu.qarobot.config.API;
import com.fuxuemingzhu.qarobot.model.callback.DataCallback;
import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;

/**
 * 包名：com.fuxuemingzhu.qarobot
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 19:52
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 19:52
 * 修改备注：
 *
 * @version 1.0
 */
public class RobotModel extends AbsModel {
    public static RobotModel getInstance() {
        return getInstance(RobotModel.class);
    }

    @Override
    protected void onAppCreate(Context ctx) {
        super.onAppCreate(ctx);
    }

    public void getAnswer(String info, DataCallback callback) {
        RequestMap map = new RequestMap();
        map.put("info", info);
        map.put("dtype", "");
        map.put("loc", "");
        map.put("userid", "");
        map.put("key", "YOUR_KEY");
        RequestManager.getInstance().post(API.URL.ROBOT_URL, map, callback);
    }

}
