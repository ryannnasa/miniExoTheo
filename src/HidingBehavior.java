public class HidingBehavior implements Behavior {
    @Override
    public void execute(AdaptiveCreature creature, Weather weather) {
        System.out.println(
                creature.name + " se cache (" + weather.getCondition() + ", " + weather.getTemperature() + "°C)");
        creature.changeEnergy(-2);
    }
}
