package com.casehacks.swipe_android.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class GenericAdapter<T> extends BaseAdapter {

    ArrayList<T> entities = new ArrayList<T>();
    HashMap<T, View> views = new HashMap<T, View>();
    protected Context context;

    public GenericAdapter(Context context, List<T> list) {
        this.context = context;

        for (T item : list) {
            entities.add(item);
        }
    }

    protected List<T> entities() {
        return entities;
    }

    protected Map<T, View> views() {
        return views;
    }

    public void add(Collection<T> toAdd) {
        for (T item : toAdd) {
            entities.add(item);
        }
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
