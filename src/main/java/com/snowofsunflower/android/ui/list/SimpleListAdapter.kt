package com.snowofsunflower.android.ui.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import java.util.*

/**
 * Created by zhouztashin on 2018/10/31.
 * 列表适配器
 */

abstract class SimpleListAdapter<T> : IRecyclerViewListAdapter<T> {
    private val mCymChadAdapterCymChadImpl: ListAdapterCymChadImpl<T> by lazy {
        ListAdapterCymChadImpl(this)
    }

    override val adapter: RecyclerView.Adapter<*>
        get() = mCymChadAdapterCymChadImpl

    override fun setNewData(list: List<T>) = mCymChadAdapterCymChadImpl.setNewData(list)

    override fun getItem(position: Int): T? {
        return mCymChadAdapterCymChadImpl.getItem(position)
    }

    override fun <T> setOnItemClickListener(listener: (SimpleListAdapter<*>, Int, T) -> Unit) {
        mCymChadAdapterCymChadImpl.onItemClickListener =
            BaseQuickAdapter.OnItemClickListener { adapter, _, position ->
                listener(
                    this@SimpleListAdapter,
                    position,
                    //暂无方案 API导致 Fix as 问题
                    adapter.getItem(position) as T
                )
            }
    }
}

//CymChad ListAdapter 实现类
class ListAdapterCymChadImpl<T>(private val mListAdapter: SimpleListAdapter<T>) :
    BaseQuickAdapter<T, BaseViewHolder>(ArrayList<T>()) {
    init {
        mLayoutResId = mListAdapter.itemLayoutId
    }

    override fun convert(helper: BaseViewHolder, item: T) {
        val cymChadItemViewHolder = ViewHolderCymChadImpl(helper)
        mListAdapter.doItem(cymChadItemViewHolder, item)
    }
}

//CymChad ViewHolder实现类
class ViewHolderCymChadImpl(private val cymChadViewHolder: BaseViewHolder) : ItemViewHolder {

    override val position: Int
        get() = cymChadViewHolder.adapterPosition

    override fun <T : View> findView(id: Int): T {
        return cymChadViewHolder.getView(id)
    }

    override fun setText(viewId: Int, value: CharSequence): ItemViewHolder {
        cymChadViewHolder.setText(viewId, value)
        return this
    }

    override fun setGone(viewId: Int): ItemViewHolder {
        findView<View>(viewId).visibility = View.GONE
        return this
    }

    override fun setVisible(viewId: Int): ItemViewHolder {
        findView<View>(viewId).visibility = View.VISIBLE
        return this
    }

    override fun setInvisible(viewId: Int): ItemViewHolder {
        findView<View>(viewId).visibility = View.INVISIBLE
        return this
    }
}
