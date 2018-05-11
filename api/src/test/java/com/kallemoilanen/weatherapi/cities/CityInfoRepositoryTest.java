package com.kallemoilanen.weatherapi.cities;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class CityInfoRepositoryTest {
    @Test
    public void ShouldReadFileContentAsString() {
        CityInfoRepository repository = new CityInfoRepository();

        Stream<CityInfo> cities = null;
        try {
            cities = repository.GetCityInfo("Helsinki");
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Pitäis pystyä lukemaan tiedosto");
        }

        Assert.assertEquals(1, cities.count());
    }
}
