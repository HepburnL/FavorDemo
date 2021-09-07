package com.example.favordemo;

import java.util.List;

public interface IMainItemModel {
    //加载条目
    void loadMainItem(MainItemOnLoadListener listener);

    //条目加载监听
    interface MainItemOnLoadListener{
        void onComplete(List<MainItemBean> list);
    }
}
