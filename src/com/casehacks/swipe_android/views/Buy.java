package com.casehacks.swipe_android.views;

import com.casehacks.swipe_android.R;
import com.casehacks.swipe_android.util.buy.BuyHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class Buy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);

        findViewById(R.id.offer).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                BuyHelper.post((ListView)findViewById(R.id.list), 
                    new com.casehacks.swipe_android.model.Buy(text(R.id.offer_name), num(R.id.offer_price)));
            }
        });

        BuyHelper.populate((ListView)findViewById(R.id.list));
    }

    private String text(Integer id) {
        return ((EditText)findViewById(id)).toString();
    }

    private Double num(Integer id) {
        return Double.parseDouble(((EditText)findViewById(id)).toString());
    }
}
