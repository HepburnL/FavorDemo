package com.example.favordemo;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends Activity implements IMainView{

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //加载数据
        new MainPresent(this).loadData();

    }

    //实现IMainView接口方法
    @Override
    public void showData(List<MainItemBean> dataList) {
        MainItemAdapter adapter = new MainItemAdapter(this,dataList);
        //设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        mRecyclerView.setAdapter(adapter);
        //设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter.setOnItemClickListener(new MainItemAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 2:
                        startActivity(new Intent(MainActivity.this, LoveActivity.class));
                }
            }
        });
    }


}
