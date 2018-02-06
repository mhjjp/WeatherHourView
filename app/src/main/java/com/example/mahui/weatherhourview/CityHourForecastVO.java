package cn.nmc.data;

import java.util.List;

/**
 * Created by caozhangheng on 16/7/20.
 */
public class CityHourForecastVO {

    /**
     * data_time : 2016-08-30 20:00
     * city_name : 北京
     * detail : [{"time":"2016-08-30 23:00","timelimit":3,"temperature":22.8,"weather_icon":"0","wind_direction":313.7,"wind_speed":2,"humidity":69.4,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":0,"weather_info":"晴"},{"time":"2016-08-31 02:00","timelimit":6,"temperature":20.2,"weather_icon":"0","wind_direction":337.4,"wind_speed":2.9,"humidity":66.2,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10,"weather_info":"晴"},{"time":"2016-08-31 05:00","timelimit":9,"temperature":19.2,"weather_icon":"0","wind_direction":345.6,"wind_speed":3.3,"humidity":63.5,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":0,"weather_info":"晴"},{"time":"2016-08-31 08:00","timelimit":12,"temperature":23.2,"weather_icon":"0","wind_direction":336.1,"wind_speed":2.4,"humidity":51.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":0,"weather_info":"晴"},{"time":"2016-08-31 11:00","timelimit":15,"temperature":30.4,"weather_icon":"1","wind_direction":327.7,"wind_speed":3.1,"humidity":34,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.1,"weather_info":"多云"},{"time":"2016-08-31 14:00","timelimit":18,"temperature":32.8,"weather_icon":"1","wind_direction":326.8,"wind_speed":4.2,"humidity":27.4,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":15.5,"weather_info":"多云"},{"time":"2016-08-31 17:00","timelimit":21,"temperature":31.8,"weather_icon":"1","wind_direction":335.4,"wind_speed":3.3,"humidity":27,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.1,"weather_info":"多云"},{"time":"2016-08-31 20:00","timelimit":24,"temperature":24.6,"weather_icon":"1","wind_direction":344.5,"wind_speed":3.3,"humidity":36.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":14.5,"weather_info":"多云"},{"time":"2016-08-31 23:00","timelimit":27,"temperature":22.2,"weather_icon":"2","wind_direction":329.3,"wind_speed":2.9,"humidity":36.5,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-01 02:00","timelimit":30,"temperature":20.9,"weather_icon":"2","wind_direction":312.3,"wind_speed":3,"humidity":37.7,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-01 05:00","timelimit":33,"temperature":20.2,"weather_icon":"2","wind_direction":309.1,"wind_speed":2.8,"humidity":40.1,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":83.2,"weather_info":"阴"},{"time":"2016-09-01 08:00","timelimit":36,"temperature":22.2,"weather_icon":"2","wind_direction":315.6,"wind_speed":3.2,"humidity":35.1,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":100,"weather_info":"阴"},{"time":"2016-09-01 11:00","timelimit":39,"temperature":24.2,"weather_icon":"2","wind_direction":325.1,"wind_speed":3.8,"humidity":34.3,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":85.1,"weather_info":"阴"},{"time":"2016-09-01 14:00","timelimit":42,"temperature":24.8,"weather_icon":"2","wind_direction":332.1,"wind_speed":4.5,"humidity":37,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":100,"weather_info":"阴"},{"time":"2016-09-01 17:00","timelimit":45,"temperature":23.8,"weather_icon":"2","wind_direction":341.7,"wind_speed":4,"humidity":39.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":97,"weather_info":"阴"},{"time":"2016-09-01 20:00","timelimit":48,"temperature":22.7,"weather_icon":"2","wind_direction":329.7,"wind_speed":3.9,"humidity":33.7,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":94.9,"weather_info":"阴"},{"time":"2016-09-01 23:00","timelimit":51,"temperature":19.7,"weather_icon":"2","wind_direction":334.3,"wind_speed":2.9,"humidity":55.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":92.9,"weather_info":"阴"},{"time":"2016-09-02 02:00","timelimit":54,"temperature":18.6,"weather_icon":"2","wind_direction":320.6,"wind_speed":2.3,"humidity":62.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":96,"weather_info":"阴"},{"time":"2016-09-02 05:00","timelimit":57,"temperature":18.2,"weather_icon":"2","wind_direction":327.2,"wind_speed":2.4,"humidity":65.4,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":84.3,"weather_info":"阴"},{"time":"2016-09-02 08:00","timelimit":60,"temperature":21.2,"weather_icon":"2","wind_direction":327.4,"wind_speed":1.8,"humidity":57.5,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-02 11:00","timelimit":63,"temperature":25.8,"weather_icon":"3","wind_direction":329.6,"wind_speed":2.2,"humidity":48.8,"total_rain":2.3,"visibility":999.9,"air_pressure":999.9,"total_cloud":70,"weather_info":"阵雨"},{"time":"2016-09-02 14:00","timelimit":66,"temperature":27.8,"weather_icon":"3","wind_direction":321.1,"wind_speed":1.7,"humidity":46,"total_rain":2.3,"visibility":999.9,"air_pressure":999.9,"total_cloud":71,"weather_info":"阵雨"},{"time":"2016-09-02 17:00","timelimit":69,"temperature":27.1,"weather_icon":"3","wind_direction":330.4,"wind_speed":1.2,"humidity":49.7,"total_rain":2.3,"visibility":999.9,"air_pressure":999.9,"total_cloud":94.4,"weather_info":"阵雨"},{"time":"2016-09-02 20:00","timelimit":72,"temperature":23.7,"weather_icon":"3","wind_direction":349.7,"wind_speed":1.7,"humidity":43.6,"total_rain":2.3,"visibility":999.9,"air_pressure":999.9,"total_cloud":94.7,"weather_info":"阵雨"},{"time":"2016-09-02 23:00","timelimit":75,"temperature":23.6,"weather_icon":"2","wind_direction":356.4,"wind_speed":2.3,"humidity":75.9,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-03 02:00","timelimit":78,"temperature":21.7,"weather_icon":"2","wind_direction":352,"wind_speed":2.2,"humidity":80.2,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-03 05:00","timelimit":81,"temperature":20.2,"weather_icon":"2","wind_direction":347,"wind_speed":1.7,"humidity":83.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-03 08:00","timelimit":84,"temperature":22.5,"weather_icon":"2","wind_direction":341.4,"wind_speed":1.2,"humidity":79.3,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-03 11:00","timelimit":87,"temperature":28.4,"weather_icon":"1","wind_direction":337.8,"wind_speed":0.6,"humidity":71.4,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":47.5,"weather_info":"多云"},{"time":"2016-09-03 14:00","timelimit":90,"temperature":28.8,"weather_icon":"1","wind_direction":10.1,"wind_speed":0.8,"humidity":71.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":59.5,"weather_info":"多云"},{"time":"2016-09-03 17:00","timelimit":93,"temperature":28.4,"weather_icon":"1","wind_direction":37.4,"wind_speed":0.7,"humidity":72.5,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":54.1,"weather_info":"多云"},{"time":"2016-09-03 20:00","timelimit":96,"temperature":25.7,"weather_icon":"1","wind_direction":55.9,"wind_speed":1.1,"humidity":66.2,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":16,"weather_info":"多云"},{"time":"2016-09-03 23:00","timelimit":99,"temperature":23.6,"weather_icon":"1","wind_direction":34.9,"wind_speed":1,"humidity":80.4,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":15.1,"weather_info":"多云"},{"time":"2016-09-04 02:00","timelimit":102,"temperature":22.6,"weather_icon":"1","wind_direction":18.2,"wind_speed":1.6,"humidity":84.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.5,"weather_info":"多云"},{"time":"2016-09-04 05:00","timelimit":105,"temperature":20.2,"weather_icon":"1","wind_direction":2.1,"wind_speed":1.2,"humidity":90.2,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.1,"weather_info":"多云"},{"time":"2016-09-04 08:00","timelimit":108,"temperature":23.6,"weather_icon":"1","wind_direction":1.5,"wind_speed":0.1,"humidity":80.4,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.1,"weather_info":"多云"},{"time":"2016-09-04 11:00","timelimit":111,"temperature":28.1,"weather_icon":"2","wind_direction":184.5,"wind_speed":2.7,"humidity":54.2,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-04 14:00","timelimit":114,"temperature":28.8,"weather_icon":"2","wind_direction":228.7,"wind_speed":2.4,"humidity":47.1,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-04 17:00","timelimit":117,"temperature":23.2,"weather_icon":"2","wind_direction":204.6,"wind_speed":2.2,"humidity":54.1,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-04 20:00","timelimit":120,"temperature":22.3,"weather_icon":"2","wind_direction":168.7,"wind_speed":0.7,"humidity":61,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-04 23:00","timelimit":123,"temperature":19.2,"weather_icon":"2","wind_direction":82,"wind_speed":0.6,"humidity":86.9,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-05 02:00","timelimit":126,"temperature":19.9,"weather_icon":"2","wind_direction":345.5,"wind_speed":2,"humidity":86.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-05 05:00","timelimit":129,"temperature":21.6,"weather_icon":"2","wind_direction":24.7,"wind_speed":0.4,"humidity":85.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":92.6,"weather_info":"阴"},{"time":"2016-09-05 08:00","timelimit":132,"temperature":23.3,"weather_icon":"2","wind_direction":7,"wind_speed":1.8,"humidity":73.3,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":80,"weather_info":"阴"},{"time":"2016-09-05 11:00","timelimit":135,"temperature":29.8,"weather_icon":"1","wind_direction":159.9,"wind_speed":3,"humidity":63,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":65.6,"weather_info":"多云"},{"time":"2016-09-05 14:00","timelimit":138,"temperature":28.4,"weather_icon":"1","wind_direction":333.9,"wind_speed":2.1,"humidity":62.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":39.6,"weather_info":"多云"},{"time":"2016-09-05 17:00","timelimit":141,"temperature":24.1,"weather_icon":"1","wind_direction":195.6,"wind_speed":1.7,"humidity":65.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":79.9,"weather_info":"多云"},{"time":"2016-09-05 20:00","timelimit":144,"temperature":21.6,"weather_icon":"1","wind_direction":359.5,"wind_speed":1.6,"humidity":69.5,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":12.6,"weather_info":"多云"},{"time":"2016-09-05 23:00","timelimit":147,"temperature":21.2,"weather_icon":"0","wind_direction":307.1,"wind_speed":1.6,"humidity":71.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10,"weather_info":"晴"},{"time":"2016-09-06 02:00","timelimit":150,"temperature":21.4,"weather_icon":"0","wind_direction":333.6,"wind_speed":2.4,"humidity":82.2,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":2.4,"weather_info":"晴"},{"time":"2016-09-06 05:00","timelimit":153,"temperature":22.7,"weather_icon":"0","wind_direction":309.2,"wind_speed":2.8,"humidity":63.8,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10,"weather_info":"晴"},{"time":"2016-09-06 08:00","timelimit":156,"temperature":23.9,"weather_icon":"0","wind_direction":337.2,"wind_speed":2.1,"humidity":50.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":4.7,"weather_info":"晴"},{"time":"2016-09-06 11:00","timelimit":159,"temperature":28.8,"weather_icon":"1","wind_direction":313.7,"wind_speed":4.2,"humidity":30.5,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":15.6,"weather_info":"多云"},{"time":"2016-09-06 14:00","timelimit":162,"temperature":28.1,"weather_icon":"1","wind_direction":282.7,"wind_speed":2.3,"humidity":44,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.1,"weather_info":"多云"},{"time":"2016-09-06 17:00","timelimit":165,"temperature":23.6,"weather_icon":"1","wind_direction":262.3,"wind_speed":3.1,"humidity":41.3,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":10.1,"weather_info":"多云"},{"time":"2016-09-06 20:00","timelimit":168,"temperature":22.6,"weather_icon":"1","wind_direction":337.2,"wind_speed":1.3,"humidity":38.6,"total_rain":0,"visibility":999.9,"air_pressure":999.9,"total_cloud":79.9,"weather_info":"多云"}]
     */

    private String data_time;
    private String city_name;
    /**
     * time : 2016-08-30 23:00
     * timelimit : 3
     * temperature : 22.8
     * weather_icon : 0
     * wind_direction : 313.7
     * wind_speed : 2
     * humidity : 69.4
     * total_rain : 0
     * visibility : 999.9
     * air_pressure : 999.9
     * total_cloud : 0
     * weather_info : 晴
     */

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
