package com.snowofsunflower.android.ui.list

import android.view.View
import androidx.annotation.IdRes

/**
 * Created by zhouztashin on 2018/10/31.
 * 列表项目处理
 */

interface ItemViewHolder {

    val position: Int
    fun <T : View> findView(@IdRes id: Int): T
    fun setText(@IdRes viewId: Int, value: CharSequence): ItemViewHolder
    fun setGone(@IdRes viewId: Int): ItemViewHolder
    fun setVisible(@IdRes viewId: Int): ItemViewHolder
    fun setInvisible(@IdRes viewId: Int): ItemViewHolder
}
