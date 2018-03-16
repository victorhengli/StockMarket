package com.alphawizard.StockMarket;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alphawizard.StockMarket.fragment.FirstLayerFragment;
import com.alphawizard.StockMarket.fragment.HomeFragment;
import com.alphawizard.StockMarket.fragment.MineFragment;
import com.alphawizard.StockMarket.fragment.OptionalFragment;
import com.alphawizard.StockMarket.fragment.TradeFragment;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.shizhefei.view.viewpager.SViewPager;
import com.alphawizard.StockMarket.R;

/**
 * Created by victor on 2018/3/16.
 */
public class TabMainActivity extends FragmentActivity {
    private IndicatorViewPager indicatorViewPager;
    private FixedIndicatorView indicator;

    private HomeFragment homeFragment;
    private TradeFragment tradeFragment;
    private OptionalFragment optionalFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_tabmain);
        SViewPager viewPager = (SViewPager) findViewById(R.id.tabmain_viewPager);
        indicator = (FixedIndicatorView) findViewById(R.id.tabmain_indicator);
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED, Color.GRAY));

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);
    }


    private class MyAdapter extends IndicatorFragmentPagerAdapter {
        private String[] tabNames = {"首页", "行情", "自选", "我的"};
        private int[] tabIcons = {R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
                R.drawable.maintab_4_selector};
        private LayoutInflater inflater;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_main, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            if (position == 0){
                homeFragment = new HomeFragment();
                return homeFragment;
            }else if(position == 1){
                tradeFragment = new TradeFragment();
                return tradeFragment;
            }else if(position == 2){
                optionalFragment = new OptionalFragment();
                return optionalFragment;
            }else {
                mineFragment = new MineFragment();
                return mineFragment;
            }
        }
    }
}
