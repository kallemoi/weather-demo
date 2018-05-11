package com.kallemoilanen.weatherapi.cities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CityInfoRepository {
    public Stream<CityInfo> GetCityInfo(String cityStartsWith) throws IOException {
        List<CityInfo> cities = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:city.list.json");
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<CityInfo>> typeReference = new TypeReference<List<CityInfo>>(){};
            cities = mapper.readValue(file, typeReference);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        Stream<CityInfo> availableCities = cities.stream()
                .filter((city) -> city.getName().startsWith(cityStartsWith));
        return availableCities;
    }
}
