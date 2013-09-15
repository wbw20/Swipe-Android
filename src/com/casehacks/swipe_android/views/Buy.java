package com.casehacks.swipe_android.views;

import com.casehacks.swipe_android.R;
import com.casehacks.swipe_android.util.buy.BuyHelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Buy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);

        BuyHelper.populate((ListView)findViewById(R.id.list));
    }
}
