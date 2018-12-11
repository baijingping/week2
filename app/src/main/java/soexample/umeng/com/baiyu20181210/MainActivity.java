package soexample.umeng.com.baiyu20181210;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import soexample.umeng.com.baiyu20181210.fragment.FoundFragment;
import soexample.umeng.com.baiyu20181210.fragment.JokesFragment;
import soexample.umeng.com.baiyu20181210.fragment.RecommendedFragment;
import soexample.umeng.com.baiyu20181210.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_user)
    ImageView btnUser;
    @BindView(R.id.btn_tui)
    ImageView btnTui;
    @BindView(R.id.btn_duan)
    ImageView btnDuan;
    @BindView(R.id.btn_fa)
    ImageView btnFa;
    @BindView(R.id.btn_shi)
    ImageView btnShi;
    @BindView(R.id.page)
    ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new RecommendedFragment());
        fragmentList.add(new JokesFragment());
        fragmentList.add(new FoundFragment());
        fragmentList.add(new VideoFragment());
        page.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        page.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.btn_user, R.id.btn_tui, R.id.btn_duan, R.id.btn_fa, R.id.btn_shi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user:
                Intent intent=new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tui:
                page.setCurrentItem(0);
                setColor(0);
                break;
            case R.id.btn_duan:
                page.setCurrentItem(1);
                setColor(1);
                break;
            case R.id.btn_fa:
                page.setCurrentItem(2);
                setColor(2);
                break;
            case R.id.btn_shi:
                page.setCurrentItem(3);
                setColor(3);
                break;
        }
    }
    public void setColor(int num){
        switch (num){
            case 0:
                btnTui.setImageResource(R.drawable.tuijie_l);
                btnDuan.setImageResource(R.drawable.duanzi_h);
                btnFa.setImageResource(R.drawable.found_h);
                btnShi.setImageResource(R.drawable.shiping_h);
                break;
            case 1:
                btnTui.setImageResource(R.drawable.tuijie_h);
                btnDuan.setImageResource(R.drawable.duanzi_l);
                btnFa.setImageResource(R.drawable.found_h);
                btnShi.setImageResource(R.drawable.shiping_h);
                break;
            case 2:
                btnTui.setImageResource(R.drawable.tuijie_h);
                btnDuan.setImageResource(R.drawable.duanzi_h);
                btnFa.setImageResource(R.drawable.found_l);
                btnShi.setImageResource(R.drawable.shiping_h);
                break;
            case 3:
                btnTui.setImageResource(R.drawable.tuijie_h);
                btnDuan.setImageResource(R.drawable.duanzi_h);
                btnFa.setImageResource(R.drawable.found_h);
                btnShi.setImageResource(R.drawable.shiping_l);
                break;
        }
    }
}
