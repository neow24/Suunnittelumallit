import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

interface WeatherObserver { void update(int temperature); }

interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

class WeatherStation extends Thread implements WeatherSubject {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private final int MIN_TEMP = -50;
    private final int MAX_TEMP =  50;
    private final Random random = new Random();

    public WeatherStation() {
        this.temperature = ThreadLocalRandom.current().nextInt(MIN_TEMP, MAX_TEMP + 1);
    }

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void changeTemperature() {
        int delta = random.nextBoolean() ? 1 : -1;
        int newTemp = temperature + delta;
        if (newTemp >= MIN_TEMP && newTemp <= MAX_TEMP) {
            temperature = newTemp;
        }
    }

    @Override
    public void run() {
        while (true) {
            changeTemperature();
            notifyObservers();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class PhoneDisplay implements WeatherObserver {
    private final String name;

    public PhoneDisplay(String name) { this.name = name; }

    @Override
    public void update(int temperature) {
        System.out.println("[PhoneDisplay - " + name + "] Current temperature: " + temperature + "°C");
    }
}

class TVDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("[TVDisplay] Current temperature: " + (temperature-274.15) + " Kelvin");
    }
}

class WebAppDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("[WebAppDisplay] Current temperature: " + (temperature*1.8+32) + "°F");
    }
}

public class Observer {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        WeatherObserver phone1 = new PhoneDisplay("Lorem");
        WeatherObserver phone2 = new PhoneDisplay("Ipsum");
        WeatherObserver tv     = new TVDisplay();
        WeatherObserver webApp = new WebAppDisplay();

        station.registerObserver(phone1);
        station.registerObserver(phone2);
        station.registerObserver(tv);
        station.registerObserver(webApp);

        station.start();

        try {
            Thread.sleep(15000);
            System.out.println("\n--- Removing Ipsum Phone Display ---\n");
            station.removeObserver(phone2);
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            station.interrupt();
        }
    }
}
