package com.snowofsunflower.android.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouztashin on 2018/10/31.
 * 列表适配器
 */

public abstract class SimpleListAdapter<T> implements IRecyclerViewListAdapter<T> {
    private InnerListAdapter mCymChadAdapter;

    public SimpleListAdapter() {
        mCymChadAdapter = new InnerListAdapter(this);
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return mCymChadAdapter;
    }

    @Override
    public void setNewData(List<T> list) {
        mCymChadAdapter.setNewData(list);
    }
}

class InnerListAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private SimpleListAdapter mWrapperAdapter;

    public InnerListAdapter(SimpleListAdapter adapter) {
        super(new ArrayList<T>());
        mWrapperAdapter = adapter;
        mLayoutResId = mWrapperAdapter.getItemLayoutId();
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        CymChadItemViewHolder cymChadItemViewHolder = new CymChadItemViewHolder(helper);
        mWrapperAdapter.doItem(cymChadItemViewHolder, item);
    }
}


class CymChadItemViewHolder implements ItemViewHolder {
    public BaseViewHolder baseViewHolder;

    public CymChadItemViewHolder(BaseViewHolder baseViewHolder) {
        this.baseViewHolder = baseViewHolder;
    }

    @Override
    public <T extends View> T findView(int id) {
        return baseViewHolder.getView(id);
    }

    @Override
    public int getPosition() {
        return baseViewHolder.getAdapterPosition();
    }

    @Override
    public ItemViewHolder setText(int viewId, CharSequence value) {
        baseViewHolder.setText(viewId,value);
        return this;
    }

    @Override
    public ItemViewHolder setGone(int viewId) {
        findView(viewId).setVisibility(View.GONE);
        return this;
    }

    @Override
    public ItemViewHolder setVisible(int viewId) {
        findView(viewId).setVisibility(View.VISIBLE);
        return this;
    }

    @Override
    public ItemViewHolder setInvisible(int viewId) {
        findView(viewId).setVisibility(View.INVISIBLE);
        return this;
    }
}
