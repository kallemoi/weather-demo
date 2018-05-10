package com.kallemoilanen.weatherapi.openweather;

import com.kallemoilanen.weatherapi.weather.Coord;
import com.kallemoilanen.weatherapi.weather.CurrentWeather;
import com.kallemoilanen.weatherapi.weather.WeatherFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@PropertySource(value = "classpath:apikeys.properties")
public class FetchWeatherFromOpenWeather implements WeatherFetcher {
    private String apiKey;
    private final String currentUrl = "http://api.openweathermap.org/data/2.5/weather";
    private RestTemplate restTemplate;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FetchWeatherFromOpenWeather(RestTemplate restTemplate, @Value("${openWeather.apiKey:}") String key) {
        this.restTemplate = restTemplate;
        this.apiKey = key;
        System.out.println(key);
    }

    public CurrentWeather FetchCurrent(Coord coord) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(currentUrl)
                .queryParam("lon", coord.getLongitude())
                .queryParam("lat", coord.getLatitude())
                .queryParam("APPID", apiKey)
                .queryParam("mode", "xml");
        String uriString = builder.toUriString();
        log.info("Fetching current weather data from OpenWeather: " + uriString);
        CurrentWeatherXml current = restTemplate.getForObject(uriString, CurrentWeatherXml.class);
        return current.toCurrentWeather();
    }
}
