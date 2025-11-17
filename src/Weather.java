import java.util.ArrayList;
import java.util.List;

public class Weather {
    private String condition;
    private int temperature;
    private final List<WeatherObserver> observers = new ArrayList<>();

    public Weather(String condition, int temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }

    public void addObserver(WeatherObserver o) {
        observers.add(o);
    }

    public void removeObserver(WeatherObserver o) {
        observers.remove(o);
    }

    public String getCondition() {
        return condition;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setWeather(String condition, int temperature) {
        this.condition = condition;
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver o : new ArrayList<>(observers)) {
            o.onWeatherChange(this);
        }
    }
}
