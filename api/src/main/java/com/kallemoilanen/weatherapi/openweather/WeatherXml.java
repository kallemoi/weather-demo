package com.kallemoilanen.weatherapi.openweather;

import javax.xml.bind.annotation.XmlAttribute;

class WeatherXml {
    private int number;
    private String value;
    private String icon;

    public int getNumber() {
        return number;
    }

    @XmlAttribute
    public void setNumber(int number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public void setIcon(String icon) {
        this.icon = icon;
    }
}

