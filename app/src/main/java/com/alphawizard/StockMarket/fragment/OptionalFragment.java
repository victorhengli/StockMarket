package com.alphawizard.StockMarket.fragment;

import android.os.Bundle;

import com.alphawizard.StockMarket.R;
import com.shizhefei.fragment.LazyFragment;

/**
 * Created by victor on 2018/3/16.
 */
public class OptionalFragment extends LazyFragment {

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_home);
    }
}
