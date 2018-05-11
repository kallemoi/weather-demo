package com.kallemoilanen.weatherapi;

import com.kallemoilanen.weatherapi.geocode.GeocodeHandler;
import com.kallemoilanen.weatherapi.weather.WeatherHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> weatherRoute(WeatherHandler weatherHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/weather").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), weatherHandler::weather);
    }

    @Bean
    public RouterFunction<ServerResponse> geocodeRoute(GeocodeHandler geocodeHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/geocode").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), geocodeHandler::geocodes);
    }
}
