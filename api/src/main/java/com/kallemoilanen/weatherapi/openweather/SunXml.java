package com.kallemoilanen.weatherapi.openweather;

import com.kallemoilanen.weatherapi.utils.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

class SunXml {
    private LocalDateTime rise;
    private LocalDateTime set;

    public LocalDateTime getRise() {
        return rise;
    }

    @XmlAttribute(name = "rise")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public void setRise(LocalDateTime rise) {
        this.rise = rise;
    }

    public LocalDateTime getSet() {
        return set;
    }

    @XmlAttribute(name = "set")
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public void setSet(LocalDateTime set) {
        this.set = set;
    }
}
