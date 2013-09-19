package com.casehacks.swipe_android.util.sell;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.widget.ListView;

import com.casehacks.swipe_android.model.Sell;
import com.casehacks.swipe_android.rest.RestCall;
import com.casehacks.swipe_android.util.sell.SellAdapter;
import com.google.gson.reflect.TypeToken;

public class SellHelper {

    public static void populate(final ListView view) {
        final SellAdapter adapter = new SellAdapter(view.getContext(), new ArrayList<Sell>());
        view.setAdapter(adapter);
        class Fetch extends AsyncTask<Object, Integer, List<Sell>> {
            @Override
            protected List<Sell> doInBackground(Object... params) {
                return RestCall.get("/sell", new TypeToken<ArrayList<Sell>>(){});
            }

            @Override
            protected void onPostExecute(List<Sell> list) {
                adapter.add(list);
            }
        }

        new Fetch().execute(new Object());
    }

    public static void post(final ListView view, Sell sell) {
        class Post extends AsyncTask<Sell, Integer, Sell> {
            @Override
            protected Sell doInBackground(Sell... params) {
                return RestCall.post("/buy", params[0]);
            }

            @Override
            protected void onPostExecute(Sell result) {
                ArrayList<Sell> list = new ArrayList<Sell>(); list.add(result);
                ((SellAdapter)view.getAdapter()).add(list);
            }
        }

        new Post().execute(sell);
    }
}
