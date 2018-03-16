package com.alphawizard.StockMarket.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alphawizard.StockMarket.Base.BaseApplication;
import com.alphawizard.StockMarket.R;
import com.alphawizard.StockMarket.adapter.BaseListViewAdapter;
import com.shizhefei.fragment.LazyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 2018/3/16.
 */
public class TradeListFragment extends LazyFragment {

    public static final String TAG = TradeListFragment.class.getSimpleName();
    private TextView mTvTradeListName;
    private ListView mLvTradeList;
    private TradeListAdapter mTradeListAdapter;

    private List mTradeList = new ArrayList();


    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_trade_list);
        initView();
        initData();
        mTradeListAdapter = new TradeListAdapter(mTradeList, BaseApplication.getContext());
        mLvTradeList.setAdapter(mTradeListAdapter);
      //  mTvTradeListName =
        /*tabName = getArguments().getString(INTENT_STRING_TABNAME);
        position = getArguments().getInt(INTENT_INT_POSITION);
        setContentView(R.layout.fragment_tabmain_item);
        textView = (TextView) findViewById(R.id.fragment_mainTab_item_textView);
        textView.setText(tabName + " " + position + " 界面加载完毕");
        progressBar = (ProgressBar) findViewById(R.id.fragment_mainTab_item_progressBar);
        handler.sendEmptyMessageDelayed(1, 3000);*/
    }

    private void initView(){
        mTvTradeListName = (TextView) findViewById(R.id.tv_trade_list_name);
        mLvTradeList = (ListView) findViewById(R.id.lv_trade_list);
    }

    private void initData(){
        for (int i = 0; i<100 ; i++){
            mTradeList.add(1);
        }
    }


    private class TradeListAdapter extends BaseListViewAdapter{

        public TradeListAdapter(List list, Context context) {
            super(list, context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(getActivity()).inflate(R.layout.listview_item_trade_list, null);

            return convertView;
        }
    }



    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        handler.removeMessages(1);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {

        }
    };
}
