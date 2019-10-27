package com.snowofsunflower.android.ui.list

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by zhouztashin on 2018/10/31.
 * 列表适配器
 */

interface IRecyclerViewListAdapter<T> {


    val adapter: RecyclerView.Adapter<*>
    val itemLayoutId: Int
    fun doItem(itemViewHolder: ItemViewHolder, item: T)
    fun setNewData(list: List<T>)
    fun getItem(position: Int): T?
    fun <T> setOnItemClickListener(listener: (SimpleListAdapter<*>, Int, T) -> Unit)
}
