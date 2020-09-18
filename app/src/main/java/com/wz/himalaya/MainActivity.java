package com.wz.himalaya;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.nfc.Tag;
import android.os.Bundle;

import com.wz.himalaya.adapters.IndicatorAdapter;
import com.wz.himalaya.adapters.MainContentAdapter;
import com.wz.himalaya.utils.LogUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private MagicIndicator mMagicIndicator;
    private ViewPager mViewPager;
    private IndicatorAdapter mIndicatorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();


    }

    private void initEvent() {
        mIndicatorAdapter.setOnIndictorTapClickListener(new IndicatorAdapter.OnIndictorTapClickListener() {

            @Override
            public void onTabClick(int index) {
                LogUtil.d(TAG,"click ----> "+index);
                if (mViewPager != null) {
                    mViewPager.setCurrentItem(index);

                }
            }
        });
    }

    private void initView() {
        mMagicIndicator = this.findViewById(R.id.main_indicator);
        mMagicIndicator.setBackgroundColor(this.getResources().getColor(R.color.main_color));
        //创建适配器
        mIndicatorAdapter = new IndicatorAdapter(this);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        //自我调节
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(mIndicatorAdapter);

        mViewPager = this.findViewById(R.id.content_page);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainContentAdapter mainContentAdapter = new MainContentAdapter(fragmentManager);
        mViewPager.setAdapter(mainContentAdapter);
        mMagicIndicator.setNavigator(commonNavigator);
        //绑定
        ViewPagerHelper.bind(mMagicIndicator,mViewPager);
    }
}
