package com.kallemoilanen.weatherapi.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WeatherHandler {
    private WeatherFetcher fetcher;

    @Autowired
    public WeatherHandler(WeatherFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public Mono<ServerResponse> weather(ServerRequest request) {
        Coord coord = ParseCoordFromParams(request.queryParams());
        Mono<CurrentWeather> report;
        if (coord != null) {
            report = Mono.just(fetcher.FetchCurrent(coord));
        }
        else {
            return ServerResponse.badRequest()
                    .body(Mono.empty(), CurrentWeather.class);
        }
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(report, CurrentWeather.class);
    }

    private Coord ParseCoordFromParams(MultiValueMap<String, String> params) {
        String longitudeString = params.getFirst("lon");
        String latitudeString = params.getFirst("lat");
        if (longitudeString == null || latitudeString == null) return null;
        double lon;
        double lat;
        try {
            lon = Double.parseDouble(longitudeString);
            lat = Double.parseDouble(latitudeString);
            return new Coord(lon, lat);
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

