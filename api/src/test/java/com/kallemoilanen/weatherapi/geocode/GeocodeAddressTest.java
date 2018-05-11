package com.kallemoilanen.weatherapi.geocode;

import com.kallemoilanen.weatherapi.IntegrationTest;
import com.kallemoilanen.weatherapi.weather.Coord;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GeocodeAddressTest {

    @Ignore
    @Category(IntegrationTest.class)
    @Test
    public void ShouldFetchInfoFromGoogleMapsApi() {
        GeocodeAddress fetcher = new GeocodeAddress("AIzaSyCUvU5H8GTYrFoiSNwXehgOgKpfagb-3I0");

        Coord coord = fetcher.GetCoordForAddress("Vellamontie 12, 45740 Kouvola, Finland");

        Assert.assertEquals(new Coord(26.5959531, 60.8969526), coord);
    }
}
