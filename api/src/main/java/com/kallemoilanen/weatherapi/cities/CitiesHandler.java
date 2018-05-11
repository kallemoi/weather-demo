package com.kallemoilanen.weatherapi.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
public class CitiesHandler {
    CityInfoRepository cityInfoRepository;

    @Autowired
    public CitiesHandler(CityInfoRepository cityInfoRepository) {
        this.cityInfoRepository = cityInfoRepository;
    }

    public Mono<ServerResponse> cities(ServerRequest request) {
        String cityStartsWith = request.queryParam("city").orElse(null);
        if (cityStartsWith == null) {
            return ServerResponse.badRequest().body(BodyInserters.fromObject("Error, missing parameter 'city'"));
        }
        Flux<CityInfo> cities = null;
        try {
            cities = Flux.fromStream(cityInfoRepository.GetCityInfo(cityStartsWith));
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BodyInserters.fromObject("Error finding cities"));
        }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(cities, CityInfo.class);
    }
}
