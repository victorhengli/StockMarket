package com.alphawizard.StockMarket.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * ListView适配器基类:抽取ListView的Adapter,免去每个Activity类重复的写getCount,getItem,getItemId
 *                    因为只有getView是不同的,故所以定义抽象类让使用者去实现细节逻辑
 *                    如果getView业务逻辑简单(如只有找到View和设置数据),就建议用BaseSuperAdapter
 * Created by victor on 2018/3/16
 */
public abstract class BaseListViewAdapter<T> extends android.widget.BaseAdapter {

    public List<T> list;
    public Context context;

    public BaseListViewAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent) ;

}
