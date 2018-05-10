package com.kallemoilanen.weatherapi.openweather;

import com.kallemoilanen.weatherapi.utils.FileUtils;
import com.kallemoilanen.weatherapi.weather.Coord;
import com.kallemoilanen.weatherapi.weather.CurrentWeather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
public class FetchWeatherFromOpenWeatherTest {
    private MockRestServiceServer mockServer;
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void shouldFetchWeatherFromOpenWeatherByCoordinate() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("OpenWeatherCurrentWeatherByCoord.xml").getFile());
        String mockResponse = "";
        try {
            mockResponse = FileUtils.readFile(file.getPath(), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("Error setting up the test. Sample XML-file could not be read!");
        }
        mockServer.expect(requestTo("http://api.openweathermap.org/data/2.5/weather?lon=30.0&lat=62.01&APPID=abckey&mode=xml"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(mockResponse, MediaType.APPLICATION_XML));

        FetchWeatherFromOpenWeather weatherFetcher = new FetchWeatherFromOpenWeather(restTemplate, "abckey");
        CurrentWeather result = weatherFetcher.FetchCurrent(new Coord(30, 62.01));

        Assert.assertEquals(30.0, result.getCoord().getLongitude(), 0.00001);
        Assert.assertEquals(62.01, result.getCoord().getLatitude(), 0.00001);
        Assert.assertEquals(288.15, result.getTemperature(), 0.00001);
        Assert.assertEquals("clear sky", result.getDescription());
    }
}
