package com.kallemoilanen.weatherapi.geocode;

import com.kallemoilanen.weatherapi.weather.Coord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GeocodeHandler {
    GeocodeAddress geocodeAddress;

    @Autowired
    public GeocodeHandler(GeocodeAddress geocodeAddress) {
        this.geocodeAddress = geocodeAddress;
    }

    public Mono<ServerResponse> geocodes(ServerRequest request) {
        String address = request.queryParam("address").orElse(null);
        if (address == null) {
            return ServerResponse.badRequest().body(BodyInserters.fromObject("Error, missing parameter 'address'"));
        }
        Mono<Coord> coord;
        coord = Mono.just(geocodeAddress.GetCoordForAddress(address));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(coord, Coord.class);
    }
}
