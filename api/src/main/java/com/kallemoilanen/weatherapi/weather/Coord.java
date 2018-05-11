package com.kallemoilanen.weatherapi.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("lon")
    @XmlAttribute(name = "lon")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("lat")
    @XmlAttribute(name = "lat")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Coord)) {
            return false;
        }

        Coord coord = (Coord) o;

        return coord.getLongitude() == longitude &&
            coord.getLatitude() == latitude;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + new Double(longitude).hashCode();
        result = 31 * result + new Double(latitude).hashCode();
        return result;
    }
}
