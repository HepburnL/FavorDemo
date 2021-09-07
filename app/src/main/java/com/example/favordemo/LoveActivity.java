package com.example.favordemo;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoveActivity extends Activity {

    private LoveLayout mLoveLayout;
    private Button mBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        mLoveLayout = (LoveLayout) findViewById(R.id.love_layout);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mLoveLayout.addIcon();
            }
        });

    }
}
