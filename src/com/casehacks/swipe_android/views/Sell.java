package com.casehacks.swipe_android.views;

import com.casehacks.swipe_android.R;
import com.casehacks.swipe_android.util.sell.SellHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class Sell extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);

        findViewById(R.id.offer).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                SellHelper.post((ListView)findViewById(R.id.list), 
                    new com.casehacks.swipe_android.model.Sell(text(R.id.offer_name), num(R.id.offer_price)));
            }
        });

        SellHelper.populate((ListView)findViewById(R.id.list));
    }

    private String text(Integer id) {
        return ((EditText)findViewById(id)).getText().toString();
    }

    private Double num(Integer id) {
        return Double.parseDouble(((EditText)findViewById(id)).getText().toString());
    }
}
