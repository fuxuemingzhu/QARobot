package com.fuxuemingzhu.qarobot.module.robot;

import android.view.ViewGroup;

import com.fuxuemingzhu.qarobot.model.bean.ChatBean;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

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

@RequiresPresenter(RobotPresenter.class)
public class RobotFragment extends BeamListFragment<RobotPresenter, ChatBean> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new RobotVH(viewGroup);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(false)
                .setRefreshAble(false)
                .setNoMoreAble(false)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);

    }
}
