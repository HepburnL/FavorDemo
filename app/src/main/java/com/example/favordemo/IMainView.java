package com.example.favordemo;

import android.os.Bundle;

import java.util.List;

public interface IMainView {
    void onCreate(Bundle savedInstanceState);
    void showData(List<MainItemBean> dataList);
}
