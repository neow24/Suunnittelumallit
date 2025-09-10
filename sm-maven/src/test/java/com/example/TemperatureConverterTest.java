package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import main.TemperatureConverter;

public class TemperatureConverterTest {

    @Test
    public void testFahrenheitToCelcius() {
        assertEquals(-15, TemperatureConverter.fahrenheitToCelcius(5));
    }

    @Test
    public void testCelciusToFahrenheit() {
        assertEquals(48.2, TemperatureConverter.celciusToFahrenheit(9));
    }

    @Test
    public void testIsExtremeTemperature() {
        assertFalse(TemperatureConverter.isExtremeTemperature(-40));
        assertTrue(TemperatureConverter.isExtremeTemperature(-41));
        assertFalse(TemperatureConverter.isExtremeTemperature(20));
        assertFalse(TemperatureConverter.isExtremeTemperature(50));
        assertTrue(TemperatureConverter.isExtremeTemperature(51));
    }

    @Test
    public void testOverallConversionAccuracy() {
        assertEquals(100, TemperatureConverter.celciusToFahrenheit(TemperatureConverter.fahrenheitToCelcius(100)), 01);
    }
}
