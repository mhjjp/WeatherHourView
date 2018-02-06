package cn.nmc.weatherapp.activity.widgets.hour;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import cn.nmc.data.CityCode;
import cn.nmc.data.CityHourForecastVO;
import cn.nmc.network.Downloader;
import cn.nmc.utils.BitmapUtils;
import cn.nmc.utils.ConfigUtils;
import cn.nmc.utils.Converter;
import cn.nmc.utils.Encoder;
import cn.nmc.utils.IndicatorUtils;
import cn.nmc.utils.SharedPreferenceUtils;
import cn.nmc.utils.TimeUtils;
import cn.nmc.utils.WeatherLimitUtils;
import cn.nmc.utils.data.WindUtils;
import cn.nmc.weatherapp.BuildConfig;
import cn.nmc.weatherapp.activity.CityWeatherActivity;
import me.zhouzhuo.zzweatherview.PicUtil;

/**
 * Created by mac on 2018/1/4.
 */

public class HourWeatherDrawScrollerView extends View {

    private final String TAG = HourWeatherDrawScrollerView.class.getSimpleName();

    private Paint textPaint;
    private Paint rainPaint;
    private Paint rainTextPaint;
    private Paint dayPaint;
    private Paint bgPaint;

    private Path tempLine;

    IndicatorUtils indicator;

    private Context context;
    public List<HourCityModel> list = new ArrayList<HourCityModel>();
    public double max = 0;
    public double min = 0;
    public double rainMax = 0.0f;

    private float tempTopY;
    private float tempBottmY;
    double distance;
    float startX;
    float startY;
    float oldX;
    float oldY;

    private int everWidth = ConfigUtils.devicesWidth / 6;

    public HourWeatherDrawScrollerView(Context context) {
        this(context, null);
    }

    public HourWeatherDrawScrollerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        indicator = new IndicatorUtils(context);
        this.context = context;
        initPaint();
    }

    public HourWeatherDrawScrollerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void initPaint(){

        textPaint = new Paint();
        rainPaint = new Paint();
        rainTextPaint = new Paint();
        bgPaint = new Paint();

        dayPaint = new Paint();
        dayPaint.setColor(Color.WHITE);
        dayPaint.setStrokeWidth(Converter.dip2px(context, 2));
        dayPaint.setStyle(Paint.Style.STROKE);
        dayPaint.setAntiAlias(true);

        textPaint.setColor(Color.WHITE);
        textPaint.setStrokeWidth(4);
        textPaint.setTextSize(Converter.dip2px(context, 15));
        textPaint.setAntiAlias(true);

        rainPaint.setColor(Color.GREEN);
        rainPaint.setAntiAlias(true);

        rainTextPaint.setColor(Color.WHITE);
        rainTextPaint.setStrokeWidth(3);
        rainTextPaint.setTextSize(Converter.dip2px(context, 10));
        rainTextPaint.setAntiAlias(true);

        bgPaint.setColor(Color.parseColor("#00000000"));

        startX = 10;
        startY = 10;

        oldX = everWidth / 2;
        oldY = Converter.dip2px(context, 20);
        tempTopY = Converter.dip2px(context, 71);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawNomal(canvas);
    }

    private void drawNomal(Canvas canvas) {

        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));

        distance = max - min;

        //当有降水时  底部Y调高一些，防止降水量文字和线重合
        if (rainMax > 0.0f) {
            tempBottmY = Converter.dip2px(context, 130);
        } else {
            tempBottmY = Converter.dip2px(context, 150);
        }

        List<List<HourCityModel>> listList = new ArrayList<>();
        List<HourCityModel> hourCityModels = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            startX = everWidth/2 + everWidth * i;
            HourCityModel hourCityModel = list.get(i);


            //**************绘制图标，时间等**** start *************//
            // 画顶部时间
            canvas.drawText(hourCityModel.getTime() + "", startX - getTextWidth(textPaint, hourCityModel.getTime() + "") / 2, Converter.dip2px(context, 15), textPaint);
            startY = tempBottmY - (float) (((hourCityModel.getTemp() - min) / distance) * (tempBottmY - tempTopY));

            //画线上的点
            canvas.drawCircle(startX - Converter.dip2px(context, 2), startY, Converter.dip2px(context, 4), textPaint);
            drawRain(canvas, hourCityModel, startX, startY);
            //**************绘制图标，时间等*** end *****************//

            //处理线
            hourCityModel.setIndex(i);
            if(WeatherLimitUtils.weatherTemperture((float) hourCityModel.getTemp())){
                hourCityModels.add(hourCityModel);
            }else{
                listList.add(hourCityModels);
                hourCityModels = new ArrayList<>();
            }
        }

        listList.add(hourCityModels);
        for(int i=0; i<listList.size(); i++){
            drawHourLine(canvas, listList.get(i));
        }
    }


    /**
     * 单独划线
     * @param canvas
     * @param listTemp
     */
    public void drawHourLine(Canvas canvas, List<HourCityModel> listTemp){

        int count=0;
        tempLine = new Path();


        for (int i = 0; i < listTemp.size() ; i++) {

            count++;

            HourCityModel hourCityModel = listTemp.get(i);

            startX = (everWidth*hourCityModel.getIndex()) + everWidth/2;
            startY = tempBottmY - (float) (((hourCityModel.getTemp() - min) / distance) * (tempBottmY - tempTopY));

            if( hourCityModel.getTemp() > -99 && hourCityModel.getTemp() < 99){
                if(tempLine.isEmpty()){
                    tempLine.moveTo(startX, startY);
                }else {
                    tempLine.lineTo(startX, startY);
                }
            }

            if (count > 30) {

                canvas.drawPath(tempLine, dayPaint);


                tempLine = new Path();
                tempLine.moveTo(startX, startY);

                count = 0;
            }
        }

        if (count > 0) {
            canvas.drawPath(tempLine, dayPaint);
        }
    }


    boolean flag;
    public void drawRain(Canvas canvas, HourCityModel hourCityModel, float startX, float startY) {

        //首先绘制间隔色

        Rect rect = new Rect((int)(startX-everWidth/2),0,(int)(startX+everWidth/2), 1400);
        if(hourCityModel.getTime()!=null && hourCityModel.getTime().contains("日")){
            if(!flag) {
                bgPaint.setColor(Color.parseColor("#1fdddddd"));
                flag = true;
            }else{
                bgPaint.setColor(Color.parseColor("#00000000"));
                flag = false;
            }
        }

        canvas.drawRect(rect, bgPaint);


        /**
         * 画 天气图标
         */

        Matrix matrix = new Matrix();

        if (hourCityModel.getImgIcon() != null && !hourCityModel.getImgIcon().isEmpty() && !hourCityModel.getImgIcon().equalsIgnoreCase("9999")) {

            if (WeatherLimitUtils.weatherIconImgIsRight(hourCityModel.getImgIcon())) {

                Bitmap bitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), hourCityModel.getImgId()));
                float scaleWidth = ((float) Converter.dip2px(context, 25)) / bitmap.getWidth();
                float scaleHeight = ((float) Converter.dip2px(context, 25)) / bitmap.getHeight();

                /**
                 * 取得想要缩放的matrix参数
                 */
                matrix.postScale(scaleWidth, scaleHeight);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                canvas.drawBitmap(bitmap, startX - bitmap.getWidth() / 2, Converter.dip2px(context, 22), textPaint);
            }
        }

        /**
         * 画  温度
         *
         * 温度缺测 -99 99
         */
        if (hourCityModel.getTemp() > -99 && hourCityModel.getTemp() < 99) {
            String temp = Math.round(hourCityModel.getTemp()) + "°";
            canvas.drawText(temp, startX - getTextWidth(textPaint, temp) / 2, startY - Converter.dip2px(context, 8), textPaint);
        }

        /**
         * 降水
         * 缺测 0 300
         */
        if (hourCityModel.getRain() < 300.0f && hourCityModel.getRain() > 0.0f) {

            //这里采用 获取最大的降水值 一定的高度 然后按比例画出矩形的高度

            float left = startX - 20;
            float maxTop = Converter.dip2px(context, 140);
            float right = startX + 20;
            float bottom = Converter.dip2px(context, 150);

            double percent = hourCityModel.getRain() / rainMax;
            float top = bottom - (float) ((bottom - maxTop) * percent);

            RectF re1 = new RectF(left, top, right, bottom);
            canvas.drawRect(re1, rainPaint);

            String rainStr = hourCityModel.getRain() + "mm";
            canvas.drawText(rainStr, startX - getTextWidth(rainTextPaint, rainStr) / 2, top - 10, rainTextPaint);
        }

        /**
         * 画风和风级
         */
        if (hourCityModel.getWindDir() >= 0.0f && hourCityModel.getWindSpeed() <= 360.0f && hourCityModel.getWindSpeed() > 0.0f && hourCityModel.getWindSpeed() < 300.0f) {

            Bitmap windbitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), PicUtil.getWindImageId(getwindDirect((float) hourCityModel.getWindDir()))));

            matrix = new Matrix();
            float scaleWindWidth = ((float) Converter.dip2px(context, 15)) / windbitmap.getWidth();
            float scaleWindHeight = ((float) Converter.dip2px(context, 15)) / windbitmap.getHeight();
            matrix.postScale(scaleWindWidth, scaleWindHeight);
            windbitmap = Bitmap.createBitmap(windbitmap, 0, 0, windbitmap.getWidth(), windbitmap.getHeight(), matrix, true);

            String windLevel = WindUtils.GetWindLevel((float) hourCityModel.getWindSpeed());

            if("微风".equals(windLevel)){
                float AllW = getTextWidth(textPaint, windLevel) + windbitmap.getWidth() + Converter.dip2px(context, 10);
                canvas.drawText(windLevel, startX - AllW / 2 + Converter.dip2px(context, 8) + windbitmap.getWidth() / 2, Converter.dip2px(context, 170), textPaint);
            }else if(!"".equals(windLevel)){
                windLevel = windLevel + "级";
                float AllW = getTextWidth(textPaint, windLevel) + windbitmap.getWidth() + Converter.dip2px(context, 10);
                canvas.drawBitmap(windbitmap, startX - AllW / 2, Converter.dip2px(context, 158), textPaint);
                canvas.drawText(windLevel, startX - AllW / 2 + Converter.dip2px(context, 8) + windbitmap.getWidth() / 2, Converter.dip2px(context, 170), textPaint);
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // TODO Auto-generated method stub
        int width = 0;
        int height = 0;
        //获得宽度MODE
        int modeW = MeasureSpec.getMode(widthMeasureSpec);
        //获得宽度的值
        if (modeW == MeasureSpec.AT_MOST) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        }
        if (modeW == MeasureSpec.EXACTLY) {
            width = widthMeasureSpec;
        }
        if (modeW == MeasureSpec.UNSPECIFIED) {
            //宽度 =  所有的小时宽度 + 左右的边界 （20 + 20）
            width = list.size() * everWidth;
        }
        //获得高度MODE
        int modeH = MeasureSpec.getMode(height);
        //获得高度的值
        if (modeH == MeasureSpec.AT_MOST) {
            height = MeasureSpec.getSize(heightMeasureSpec);
        }
        if (modeH == MeasureSpec.EXACTLY) {
            height = heightMeasureSpec;
        }
        if (modeH == MeasureSpec.UNSPECIFIED) {
            //ScrollView和HorizontalScrollView
            height =  Converter.dip2px(context, 180);
        }
        //设置宽度和高度
        setMeasuredDimension(width, height);
    }

    public String getwindDirect(float dir) {

        String degree = "";
        if (dir == 0) {
            degree = "北风";
        } else if (0.0 < dir && dir < 90.0) {
            degree = "东北风";
        } else if (dir == 90) {
            degree = "东风";
        } else if (90 < dir && dir < 180) {
            degree = "东南风";
        } else if (dir == 180) {
            degree = "南风";
        } else if (180 < dir && dir < 270) {
            degree = "西南风";
        } else if (dir == 270) {
            degree = "西风";
        } else if (270 < dir && dir < 360) {
            degree = "西北风";
        }
        return degree;
    }

    /**
     *获取文字的宽度
     * @param paint 画笔
     * @param str 文字
     * @return 文字的宽度
     */
    public int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }
}
