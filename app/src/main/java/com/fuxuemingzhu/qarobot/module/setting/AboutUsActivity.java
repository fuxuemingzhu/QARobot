package com.fuxuemingzhu.qarobot.module.setting;

import android.os.Bundle;
import android.widget.TextView;

import com.fuxuemingzhu.qarobot.R;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by fuxuemingzhu on 2015/8/14.
 */

@RequiresPresenter(AboutUsPresenter.class)
public class AboutUsActivity extends BeamBaseActivity<AboutUsPresenter> {

    @Bind(R.id.version)
    TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        version.setText("v" + JUtils.getAppVersionName());
    }


}
