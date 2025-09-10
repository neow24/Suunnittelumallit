package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.TemperatureConverter;

public class TemperatureConverterTest {

    @Test
    public void fahrenheitToCelcius() {
        assertEquals(-15, TemperatureConverter.fahrenheitToCelcius(5));
    }

    @Test
    public void celciusToFahrenheit() {
        assertEquals(48.2, TemperatureConverter.celciusToFahrenheit(9));
    }

    @Test
    public void isExtremeTemperature() {
        assertEquals(false, TemperatureConverter.isExtremeTemperature(-40));
        assertEquals(true, TemperatureConverter.isExtremeTemperature(-41));
        assertEquals(false, TemperatureConverter.isExtremeTemperature(20));
        assertEquals(false, TemperatureConverter.isExtremeTemperature(50));
        assertEquals(true, TemperatureConverter.isExtremeTemperature(51));
    }
}
