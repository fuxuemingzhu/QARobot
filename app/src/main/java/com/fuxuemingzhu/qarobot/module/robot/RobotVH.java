package com.fuxuemingzhu.qarobot.module.robot;

import android.view.ViewGroup;
import android.widget.TextView;

import com.fuxuemingzhu.qarobot.R;
import com.fuxuemingzhu.qarobot.model.bean.ChatBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 包名：com.fuxuemingzhu.qarobot.module.robot
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 20:06
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 20:06
 * 修改备注：
 *
 * @version 1.0
 */
public class RobotVH extends BaseViewHolder<ChatBean> {

    @Bind(R.id.tv_adapter_answer_source)
    TextView tv_sourse;

    @Bind(R.id.tv_adapter_answer_time)
    TextView tv_time;

    @Bind(R.id.tv_adapter_answer_content)
    TextView tv_content;


    public RobotVH(ViewGroup parent) {
        super(parent, R.layout.adapter_answer);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void setData(ChatBean data) {
        tv_sourse.setText(data.getSourse());
        tv_time.setText(data.getTime());
        tv_content.setText(data.getContent());
    }

}
