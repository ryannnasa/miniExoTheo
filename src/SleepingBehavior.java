public class SleepingBehavior implements Behavior {
    @Override
    public void execute(AdaptiveCreature creature, Weather weather) {
        System.out.println(creature.name + " se met à dormir (" + weather.getCondition() + ", "
                + weather.getTemperature() + "°C)");
        creature.rest();
    }
}
