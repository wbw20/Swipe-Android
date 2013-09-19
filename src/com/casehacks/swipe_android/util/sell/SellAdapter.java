package com.casehacks.swipe_android.util.sell;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.casehacks.swipe_android.R;
import com.casehacks.swipe_android.model.Sell;
import com.casehacks.swipe_android.util.GenericAdapter;

public class SellAdapter extends GenericAdapter<Sell> {

    public SellAdapter(Context context, List<Sell> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (views().get(entities().get(position)) == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.sell_list_item, null);
            ((TextView)convertView.findViewById(R.id.name)).setText(entities().get(position).name());
            ((TextView)convertView.findViewById(R.id.price)).setText(entities().get(position).price().toString());
            views().put(entities().get(position), convertView);
        }

        return views().get(entities().get(position));
    }
}
