package com.snowofsunflower.android.ui.list

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * 简易的列表
 */
//TODO 支持多列表
interface IEnjoyList<T> {
    fun onItemClick(adapter: IRecyclerViewListAdapter<*>, position: Int, item: T) {
    }

    var mRecyclerView: RecyclerView
    var mAdapter: IRecyclerViewListAdapter<T>

    fun initListView() {
        mRecyclerView.layoutManager = layoutManager()
        mRecyclerView.adapter = mAdapter.adapter
        mAdapter.setOnItemClickListener(::onItemClick)
    }

    fun layoutManager() = LinearLayoutManager(mRecyclerView.context)

}