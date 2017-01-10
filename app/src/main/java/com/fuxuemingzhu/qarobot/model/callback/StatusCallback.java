package com.fuxuemingzhu.qarobot.model.callback;

import com.fuxuemingzhu.qarobot.config.API;
import com.jude.utils.JUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 包名：com.fuxuemingzhu.qarobot.model.callback
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 19:45
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 19:45
 * 修改备注：
 *
 * @version 1.0
 */
public abstract class StatusCallback extends LinkCallback {

    @Override
    public void onRequest() {
        super.onRequest();
    }

    @Override
    public void onSuccess(String response) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
            String status = jsonObject.getString(API.KEY.STATUS);
            if (status.equals(API.CODE.SUCCEED)) {
                success(status);
            } else {
                error(status);
            }
        } catch (JSONException e) {
            error("数据解析错误");
        }
        super.onSuccess(response);
    }

    @Override
    public void onError(String s) {
        result(-1, "网络错误");
        error("网络错误");
        super.onError(s);
    }

    public void result(int status, String info) {
    }

    public abstract void success(String info);

    public void error(String errorInfo) {
        JUtils.Toast(errorInfo);
    }
}
