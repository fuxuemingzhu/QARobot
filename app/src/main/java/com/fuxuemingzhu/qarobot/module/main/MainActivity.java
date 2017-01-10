package com.fuxuemingzhu.qarobot.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.fuxuemingzhu.qarobot.R;
import com.fuxuemingzhu.qarobot.module.robot.RobotFragment;
import com.fuxuemingzhu.qarobot.module.setting.AboutUsActivity;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.umeng.update.UmengUpdateAgent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 包名：com.fuxuemingzhu.qarobot.module.main
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 19:58
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 19:58
 * 修改备注：
 *
 * @version 1.0
 */

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BeamBaseActivity<MainPresenter> {

    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.btn_send)
    Button btn_send;
    @Bind(R.id.met_content)
    MaterialEditText met_content;

    private FragmentManager fragmentManager;
    private RobotFragment robotFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fragmentManager = getSupportFragmentManager();

        robotFragment = new RobotFragment();

        addFragment(robotFragment);

        btn_send.setOnClickListener(view -> {
            robotFragment.getPresenter().setMsg(met_content.getText().toString());
        });

        UmengUpdateAgent.update(this);

    }

    private void addFragment(RobotFragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //是rl 不是ll
        //好可恶啊，整了好久  就是因为这个搞错了
        fragmentTransaction.replace(R.id.rl_main, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            startActivity(new Intent(this, AboutUsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
