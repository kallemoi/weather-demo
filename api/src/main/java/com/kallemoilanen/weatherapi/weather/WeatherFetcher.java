package com.kallemoilanen.weatherapi.weather;

public interface WeatherFetcher {
    CurrentWeather FetchCurrent(Coord coord);
}
