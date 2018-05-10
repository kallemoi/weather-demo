package com.kallemoilanen.weatherapi;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void ShouldReturnErrorIfNotGivenParameters() {
        webTestClient.get().uri("/weather")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().is4xxClientError();
    }

    @Ignore("Doesn't work without api-key")
    @Category(IntegrationTest.class)
    @Test
    public void ShouldReturnWeatherIfGivenCoord() {
        EntityExchangeResult<String> result = webTestClient.get().uri(uriBuilder -> uriBuilder.path("/weather")
            .queryParam("lon", "25")
            .queryParam("lat", "65")
            .build())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).returnResult();

        Assert.assertTrue("The response should start with the coords, the weather may be different so it's not asserted", result.getResponseBody().startsWith("{\"coord\":{\"longitude\":25.0,\"latitude\":65.0}"));
    }
}