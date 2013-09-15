package com.casehacks.swipe_android.util.buy;

import java.util.ArrayList;
import java.util.List;

import com.casehacks.swipe_android.model.Buy;
import com.casehacks.swipe_android.rest.RestCall;

import android.os.AsyncTask;
import android.widget.ListView;

public class BuyHelper {

    public static void populate(final ListView view) {
        final BuyAdapter adapter = new BuyAdapter(view.getContext(), new ArrayList<Buy>());
        view.setAdapter(adapter);
        class Fetch extends AsyncTask<Object, Integer, List<Buy>> {
            @Override
            protected List<Buy> doInBackground(Object... params) {
                List<Buy> buys = RestCall.get("/buy", Buy.class);
                adapter.add(buys);
                return buys;
            }
        }

        new Fetch().execute(new Object());
    }
}
