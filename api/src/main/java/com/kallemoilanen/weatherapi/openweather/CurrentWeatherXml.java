package com.kallemoilanen.weatherapi.openweather;

import com.kallemoilanen.weatherapi.weather.CurrentWeather;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="current")
class CurrentWeatherXml {
    private CityXml city;
    private TemperatureXml temperature;
    private WeatherXml weather;

    public CityXml getCity() {
        return city;
    }

    public void setCity(CityXml city) {
        this.city = city;
    }

    public TemperatureXml getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureXml temperature) {
        this.temperature = temperature;
    }

    public WeatherXml getWeather() {
        return weather;
    }

    public void setWeather(WeatherXml weather) {
        this.weather = weather;
    }

    public CurrentWeather toCurrentWeather() {
        CurrentWeather current = new CurrentWeather();
        current.setCoord(city.getCoord());
        current.setDescription(weather.getValue());
        current.setTemperature(temperature.getValue());
        return current;

    }
}
