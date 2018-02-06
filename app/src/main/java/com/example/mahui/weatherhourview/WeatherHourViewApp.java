package com.example.mahui.weatherhourview;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by mahui on 2018/2/6.
 */

public class WeatherHourViewApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
