package com.kallemoilanen.weatherapi.openweather;

import com.kallemoilanen.weatherapi.weather.Coord;

import javax.xml.bind.annotation.XmlAttribute;

class CityXml {
    private int id;
    private String name;
    private Coord coord;
    private String country;
    private SunXml sun;

    public int getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public SunXml getSun() {
        return sun;
    }

    public void setSun(SunXml sun) {
        this.sun = sun;
    }
}
