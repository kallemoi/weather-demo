package com.kallemoilanen.weatherapi.weather;

import javax.xml.bind.annotation.XmlAttribute;

public class Coord {
    private double longitude;
    private double latitude;

    public Coord() {}

    public Coord(double longitude, double latitude)
    {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @XmlAttribute(name = "lon")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @XmlAttribute(name = "lat")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
