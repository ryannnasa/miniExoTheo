public class ActiveBehavior implements Behavior {
    @Override
    public void execute(AdaptiveCreature creature, Weather weather) {
        System.out.println(
                creature.name + " devient actif (" + weather.getCondition() + ", " + weather.getTemperature() + "°C)");
        creature.changeEnergy(-5);
    }
}
