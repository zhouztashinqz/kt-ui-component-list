package com.snowofsunflower.android.ui.list;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by zhouztashin on 2018/10/31.
 */

public interface IRecyclerViewListAdapter<T> {


    RecyclerView.Adapter getAdapter();
    int getItemLayoutId();
    void doItem(ItemViewHolder itemViewHolder, T item);
    void setNewData(List<T> list);
    T getItem(int position);
    void setOnItemClickListener(OnItemClickListener listener);
}
