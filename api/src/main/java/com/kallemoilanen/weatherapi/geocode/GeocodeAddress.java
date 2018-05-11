package com.kallemoilanen.weatherapi.geocode;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.kallemoilanen.weatherapi.weather.Coord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeocodeAddress {
    private String apiKey;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public GeocodeAddress(@Value("${googleMaps.apiKey}") String apiKey) {
        this.apiKey = apiKey;
    }

    public Coord GetCoordForAddress(String address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        GeocodingResult[] results = new GeocodingResult[0];
        log.info("Fetching geolocation for address " + address + ". Using apikey: " + apiKey);
        try {
            results = GeocodingApi.geocode(context, address).await();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error geocoding address " + address, e);
        }
        return new Coord(results[0].geometry.location.lng, results[0].geometry.location.lat);
    }
}
