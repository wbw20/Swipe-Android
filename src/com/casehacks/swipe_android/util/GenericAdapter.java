package com.casehacks.swipe_android.util;

import java.util.List;
import java.util.Map;

import android.view.View;
import android.widget.BaseAdapter;

public abstract class GenericAdapter<T> extends BaseAdapter {

    List<T> entities;
    Map<T, View> views;

    protected List<T> entities() {
        return entities;
    }

    protected Map<T, View> views() {
        return views;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
