package com.kallemoilanen.weatherapi;

import com.kallemoilanen.weatherapi.weather.WeatherHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> weatherRoute(WeatherHandler weatherHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/weather").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), weatherHandler::weather);
    }
}
