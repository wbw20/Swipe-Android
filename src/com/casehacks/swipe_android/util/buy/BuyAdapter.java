package com.casehacks.swipe_android.util.buy;

import android.view.View;
import android.view.ViewGroup;

import com.casehacks.swipe_android.model.Buy;
import com.casehacks.swipe_android.util.GenericAdapter;

public class BuyAdapter extends GenericAdapter<Buy> {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (views().get(entities().get(position)) == null) {
            
        }

        return views().get(entities().get(position));
    }
}