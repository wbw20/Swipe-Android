package com.casehacks.swipe_android.util.buy;

import java.util.ArrayList;
import java.util.List;

import com.casehacks.swipe_android.model.Buy;
import com.casehacks.swipe_android.rest.RestCall;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;
import android.widget.ListView;

public class BuyHelper {

    public static void populate(final ListView view) {
        final BuyAdapter adapter = new BuyAdapter(view.getContext(), new ArrayList<Buy>());
        view.setAdapter(adapter);
        class Fetch extends AsyncTask<Object, Integer, List<Buy>> {
            @Override
            protected List<Buy> doInBackground(Object... params) {
                return RestCall.get("/buy", new TypeToken<ArrayList<Buy>>(){});
            }

            @Override
            protected void onPostExecute(List<Buy> list) {
                adapter.add(list);
            }
        }

        new Fetch().execute(new Object());
    }

    public static void post(final ListView view, Buy buy) {
        class Post extends AsyncTask<Buy, Integer, Buy> {
            @Override
            protected Buy doInBackground(Buy... params) {
                return RestCall.post("/buy", params[0]);
            }

            @Override
            protected void onPostExecute(Buy result) {
                ArrayList<Buy> list = new ArrayList<Buy>(); list.add(result);
                ((BuyAdapter)view.getAdapter()).add(list);
            }
        }

        new Post().execute(buy);
    }
}
