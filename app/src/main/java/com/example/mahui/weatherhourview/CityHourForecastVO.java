package com.example.mahui.weatherhourview;

import java.util.List;

public class CityHourForecastVO {


    private String data_time;
    private String city_name;

    private List<DetailBean> detail;

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public List<DetailBean> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailBean> detail) {
        this.detail = detail;
    }

    public static class DetailBean {
        private String time;
        private int timelimit;
        private double temperature;
        private String weather_icon;
        private double wind_direction;
        private double wind_speed;
        private double humidity;
        private double total_rain;
        private double visibility;
        private double air_pressure;
        private double total_cloud;
        private String weather_info;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getTimelimit() {
            return timelimit;
        }

        public void setTimelimit(int timelimit) {
            this.timelimit = timelimit;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public String getWeather_icon() {
            return weather_icon;
        }

        public void setWeather_icon(String weather_icon) {
            this.weather_icon = weather_icon;
        }

        public double getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(double wind_direction) {
            this.wind_direction = wind_direction;
        }

        public double getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getTotal_rain() {
            return total_rain;
        }

        public void setTotal_rain(double total_rain) {
            this.total_rain = total_rain;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public double getAir_pressure() {
            return air_pressure;
        }

        public void setAir_pressure(double air_pressure) {
            this.air_pressure = air_pressure;
        }

        public double getTotal_cloud() {
            return total_cloud;
        }

        public void setTotal_cloud(double total_cloud) {
            this.total_cloud = total_cloud;
        }

        public String getWeather_info() {
            return weather_info;
        }

        public void setWeather_info(String weather_info) {
            this.weather_info = weather_info;
        }
    }
}
