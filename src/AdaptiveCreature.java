import java.util.HashMap;
import java.util.Map;

public class AdaptiveCreature extends Animal implements WeatherObserver {
    private Behavior currentBehavior;
    private final Map<String, Behavior> behaviorMap = new HashMap<>();

    public AdaptiveCreature(String name, String species) {
        super(name, species);
        behaviorMap.put("sunny", new ActiveBehavior());
        behaviorMap.put("rainy", new SleepingBehavior());
        behaviorMap.put("stormy", new HidingBehavior());
        behaviorMap.put("night", new ActiveBehavior());
        this.currentBehavior = behaviorMap.get("sunny");
    }

    public void setBehaviorFor(String condition, Behavior b) {
        behaviorMap.put(condition, b);
    }

    public void setDefaultBehavior(Behavior b) {
        this.currentBehavior = b;
    }

    @Override
    public void onWeatherChange(Weather weather) {
        if (weather.getTemperature() < 0) {
            currentBehavior = new HidingBehavior();
        } else {
            Behavior b = behaviorMap.get(weather.getCondition());
            if (b != null) {
                currentBehavior = b;
            }
        }
        if (currentBehavior != null) {
            currentBehavior.execute(this, weather);
        }
    }

    @Override
    public void makeSound() {
        System.out.println(name + " (" + species + ") n'a pas de son spécial (adaptive)");
    }

    @Override
    public void move() {
        if (currentBehavior != null) {
            currentBehavior.execute(this, new Weather("manual", getEnergy()));
        } else {
            super.move();
        }
    }
}
