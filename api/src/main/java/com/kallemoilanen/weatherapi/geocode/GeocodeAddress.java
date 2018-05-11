package com.kallemoilanen.weatherapi.geocode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.kallemoilanen.weatherapi.weather.Coord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GeocodeAddress {
    private String apiKey;

    public GeocodeAddress(@Value("${googleMaps.apiKey:}") String apiKey) {
        this.apiKey = apiKey;
    }

    public Coord GetCoordForAddress(String address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, address).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results));
        return new Coord(results[0].geometry.location.lng, results[0].geometry.location.lat);
    }
}
