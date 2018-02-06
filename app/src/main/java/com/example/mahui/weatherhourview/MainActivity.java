package com.example.mahui.weatherhourview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    double max = 0;
    double min = 0;
    double maxRain = -1.0f;

    HorizontalScrollView horizontalScrollView;
    List<HourCityModel> list = new ArrayList<HourCityModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relative_container = (RelativeLayout)findViewById(R.id.relative_container);

        horizontalScrollView = new HorizontalScrollView(MainActivity.this);

        relative_container.addView(horizontalScrollView);

        //逐小时天气预报

        CityHourForecastVO cityHourForecastVO = JSON.parseObject(OpenAssetsFile(MainActivity.this, "weatherHour.json", "UTF-8"), CityHourForecastVO.class);

        ShowForecastInfo(cityHourForecastVO);

    }


    //城市的逐小时或者或者逐天预报
    private void ShowForecastInfo(CityHourForecastVO cityHourForecastVO) {


        // 判断 如果是00 就转换成日
        int startIndex = 0;
        int bgFlag = 0;

        /**
         * startIndex 的初始值可能大于8 这样就不会去执行下面的代码
         */

        boolean maxAndMinGeted = false;


        for (int i = startIndex; i < cityHourForecastVO.getDetail().size(); i++) {



            HourCityModel hourCityModel = new HourCityModel();

            CityHourForecastVO.DetailBean model = cityHourForecastVO.getDetail().get(i);


            if(model.getTemperature()>-99 && model.getTemperature()<99){

                if(maxAndMinGeted){

                    max = Math.max(max, model.getTemperature());
                    min = Math.min(min, model.getTemperature());

                }else {

                    max = model.getTemperature();
                    min = model.getTemperature();

                    maxAndMinGeted = true;
                }
            }

            if(model.getTotal_rain()>0.0f && model.getTotal_rain()<300.0f) {
                maxRain = Math.max(maxRain, model.getTotal_rain());
            }

            hourCityModel.setTemp(Math.round(model.getTemperature()));

            Date time = Converter.String2Date(model.getTime(), "yyyy-MM-dd HH:mm", TimeZone.getTimeZone("GMT+8:00"));

            Calendar c = Calendar.getInstance(TimeZone.getDefault());
            c.setTime(time);

            // X 轴坐标
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int currentDay = c.get(Calendar.DAY_OF_YEAR);
            int preDay = currentDay;

            if (i != startIndex) {

                Date preTime = Converter.String2Date(cityHourForecastVO.getDetail().get(i - 1).getTime(), "yyyy-MM-dd HH:mm", TimeZone.getTimeZone("GMT+8:00"));

                Calendar preC = Calendar.getInstance(TimeZone.getDefault());
                preC.setTime(preTime);

                preDay = preC.get(Calendar.DAY_OF_YEAR);
            }

            if (preDay != currentDay) {
                hourCityModel.setTime(Converter.Date2String(time, "dd日", TimeZone.getDefault()));
                bgFlag++;

            } else {

                //*****************************************//
                // 解决第一个00:00点出现的不是xx日问题
                String strDate = Converter.Date2String(time, "HH:mm", TimeZone.getDefault());
                if(strDate != null && strDate.contains("00:00")){
                    bgFlag++;
                    hourCityModel.setTime(Converter.Date2String(time, "dd日", TimeZone.getDefault()));


                }else{
                    hourCityModel.setTime(Converter.Date2String(time, "HH:mm", TimeZone.getDefault()));
                }
            }

            if(bgFlag %2 == 0){
                // itemView.setBgColor(Color.parseColor("#1fdddddd"));
            }

            // 设置天气图标
            String dn = (hour > 5 && hour < 20) ? "d" : "n";
            int resId = R.drawable.d00;
            hourCityModel.setImgId(resId);
            hourCityModel.setWindDir( model.getWind_direction());
            hourCityModel.setImgIcon(model.getWeather_icon());
            hourCityModel.setWindSpeed(model.getWind_speed());
            hourCityModel.setRain(model.getTotal_rain());

            list.add(hourCityModel);

        }

        HourWeatherDrawScrollerView hourWeatherDrawScrollerView = new HourWeatherDrawScrollerView(MainActivity.this);
        hourWeatherDrawScrollerView.list = list;
        hourWeatherDrawScrollerView.min = min;
        hourWeatherDrawScrollerView.max = max;
        hourWeatherDrawScrollerView.rainMax = maxRain;

        horizontalScrollView.addView(hourWeatherDrawScrollerView);

    }


    /**
     * 打开Assets文件夹下的文件内容
     *
     * @param context
     * @param file     相对于Assets目录的路径，可以直接的文件名
     * @param encoding
     * @return
     */
    public static String OpenAssetsFile(Context context, String file, String encoding) {

        InputStream in = null;

        try {
            in = context.getAssets().open(file);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            String txt = new String(buffer, encoding);
            return txt;
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {
                    Log.e(TAG, "无法关闭文件：" + ex.getMessage(), ex);
                }
            }
        }

        return "";
    }
}
