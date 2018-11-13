package com.snowofsunflower.android.ui.list;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by zhouztashin on 2018/10/31.
 */

public interface ItemViewHolder {
    <T extends View> T findView(@IdRes int id);

    int getPosition();

    ItemViewHolder setText(@IdRes int viewId, CharSequence value);
    ItemViewHolder setGone(@IdRes int viewId);
    ItemViewHolder setVisible(@IdRes int viewId);
    ItemViewHolder setInvisible(@IdRes int viewId);
}
