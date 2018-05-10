package com.kallemoilanen.weatherapi.openweather;

import javax.xml.bind.annotation.XmlAttribute;

public class TemperatureXml {
    private double value;
    private double min;
    private double max;
    private String unit;

    public double getValue() {
        return value;
    }

    @XmlAttribute(name = "value")
    public void setValue(double value) {
        this.value = value;
    }

    public double getMin() {
        return min;
    }

    @XmlAttribute(name = "min")
    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    @XmlAttribute(name = "max")
    public void setMax(double max) {
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    @XmlAttribute(name = "unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
