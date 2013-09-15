package com.casehacks.swipe_android.util.buy;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
            ((TextView)convertView.findViewById(R.id.name)).setText(entities().get(position).name());
            ((TextView)convertView.findViewById(R.id.price)).setText(entities().get(position).price().toString());
            views().put(entities().get(position), convertView);
        }

        return views().get(entities().get(position));
    }
}
