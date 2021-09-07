package com.example.favordemo;

import java.util.ArrayList;
import java.util.List;

public class MainItemModelImpl implements IMainItemModel {

    @Override
    public void loadMainItem(MainItemOnLoadListener listener) {
        //加载数据
        List<MainItemBean> dataList = new ArrayList<>();
        dataList.add(new MainItemBean("水面上升", R.mipmap.water));
        dataList.add(new MainItemBean("漏斗图", R.mipmap.funnel));
        dataList.add(new MainItemBean("点赞飘心", R.mipmap.love));
        dataList.add(new MainItemBean("ViewPager切换", R.mipmap.viewpagerview));

        //返回数据
        listener.onComplete(dataList);
    }
}
