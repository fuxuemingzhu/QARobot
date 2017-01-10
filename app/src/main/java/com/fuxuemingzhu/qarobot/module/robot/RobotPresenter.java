package com.fuxuemingzhu.qarobot.module.robot;

import android.os.Bundle;

import com.fuxuemingzhu.qarobot.RobotModel;
import com.fuxuemingzhu.qarobot.model.bean.Answer;
import com.fuxuemingzhu.qarobot.model.bean.ChatBean;
import com.fuxuemingzhu.qarobot.model.callback.DataCallback;
import com.fuxuemingzhu.qarobot.utils.DateUtil;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;

/**
 * 包名：com.fuxuemingzhu.qarobot.module.robot
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 20:05
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 20:05
 * 修改备注：
 *
 * @version 1.0
 */
public class RobotPresenter extends BeamListFragmentPresenter<RobotFragment, ChatBean> {


    @Override
    protected void onCreate(RobotFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        initChat();
    }

    @Override
    public DataAdapter getAdapter() {
        return super.getAdapter();
    }

    private void initChat() {
        getAdapter().clear();
        ChatBean chatBean = new ChatBean("欢迎来陪我聊天，我是小A，我有问必答哦！", "小A：", DateUtil.getCurrentDate3());
        updateView(chatBean);
    }

    private void updateView(ChatBean chatBean) {
        getAdapter().add(chatBean);
    }

    public void setMsg(String msg) {
        ChatBean chatBean = new ChatBean(msg, "我：", DateUtil.getCurrentDate3());
        getView().getListView().scrollToPosition(getAdapter().getCount() - 1);
        getAdapter().add(chatBean);
        RobotModel.getInstance().getAnswer(msg, new DataCallback() {
            @Override
            public void success(Answer data) {
                ChatBean chatBean = new ChatBean(data.getText(), "小A：", DateUtil.getCurrentDate3());
                updateView(chatBean);
                getView().getListView().scrollToPosition(getAdapter().getCount() - 1);
            }

            @Override
            public void error(String errorInfo) {
                super.error(errorInfo);
                ChatBean chatBean = new ChatBean("网络似乎有问题，稍后再试吧", "小A：", DateUtil.getCurrentDate3());
                updateView(chatBean);
                getView().getListView().scrollToPosition(getAdapter().getCount() - 1);
            }

        });
    }
}
