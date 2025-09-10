package main;

public class TemperatureConverter {

    public static double fahrenheitToCelcius(double f) {
        return (f-32)/1.8;
    }

    public static double celciusToFahrenheit(double c) {
        return c*1.8+32;
    }
    
    public static boolean isExtremeTemperature(double c) {
        return c < -40 || c > 50;
    }

    public static void main(String[] args) {
        //
    }
}