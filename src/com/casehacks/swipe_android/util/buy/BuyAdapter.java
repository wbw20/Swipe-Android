package com.casehacks.swipe_android.util.buy;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.casehacks.swipe_android.R;
import com.casehacks.swipe_android.model.Buy;
import com.casehacks.swipe_android.util.GenericAdapter;

public class BuyAdapter extends GenericAdapter<Buy> {

    public BuyAdapter(Context context, List<Buy> buys) {
        super(context, buys);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (views().get(entities().get(position)) == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.buy_list_item, null);
        }

        return views().get(entities().get(position));
    }
}
