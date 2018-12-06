package com.snowofsunflower.android.ui.list;

/**
 * Created by zhouztashin on 2018/12/6.
 */

public interface OnItemClickListener<T> {
    public void onItemClick(SimpleListAdapter adapter,int position,T item);
}
