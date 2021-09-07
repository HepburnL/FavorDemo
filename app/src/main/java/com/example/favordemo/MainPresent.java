package com.example.favordemo;

import java.lang.ref.WeakReference;
import java.util.List;

class MainPresent {
    WeakReference<IMainView> mainView;
    IMainItemModel mMainItemModel;

    public MainPresent(IMainView mainView) {
        this.mainView = new WeakReference<>(mainView);
        mMainItemModel = new MainItemModelImpl();
    }

    public void loadData(){
        if(mMainItemModel != null){
            mMainItemModel.loadMainItem(new IMainItemModel.MainItemOnLoadListener(){

                @Override
                public void onComplete(List<MainItemBean> list) {
                    mainView.get().showData(list);
                }
            });
        }
    }
}
