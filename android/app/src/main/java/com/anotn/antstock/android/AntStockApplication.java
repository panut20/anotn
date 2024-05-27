package com.anotn.antstock.android;

import android.app.Application;
import android.util.Log;

public class AntStockApplication extends Application {
    final String kakaoToken = "KAKAO_TOKEN";

    void test() {
        String testStatement =  "나 여기 있어! "+ kakaoToken;
        Log.d("test", testStatement);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        test();
    }
}
