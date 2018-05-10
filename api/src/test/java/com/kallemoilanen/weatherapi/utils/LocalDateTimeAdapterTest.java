package com.kallemoilanen.weatherapi.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeAdapterTest {
    private LocalDateTimeAdapter adapter;

    @Before
    public void setUp() {
        adapter = new LocalDateTimeAdapter();
    }

    @Test
    public void ShouldConvertIsoDateTimeStringToLocalDateTime() {
        LocalDateTime expected = LocalDateTime.of(LocalDate.of(2018,5,9), LocalTime.of(1,21,49));

        LocalDateTime datetime;
        try {
            datetime = adapter.unmarshal("2018-05-09T01:21:49");
        }
        catch (Exception ex) {
            Assert.fail("Should be able to convert given string to LocalDateTime");
            datetime = null;
        }

        Assert.assertEquals(expected, datetime);
    }

    @Test
    public void ShouldConvertLocalDateTimeToIsoDateTimeString() {
        LocalDateTime given = LocalDateTime.of(LocalDate.of(2018,5,9), LocalTime.of(1,21,49));
        String expected = "2018-05-09T01:21:49";

        String result;
        try {
            result = adapter.marshal(given);
        }
        catch (Exception ex) {
            Assert.fail("Should be able to convert given LocalDateTime to String");
            result = null;
        }

        Assert.assertEquals(expected, result);
    }
}
