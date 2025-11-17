public class Creature {
    private int energy = 100;
    public String name;
    public String species;

    public Creature(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public void move() {
        energy = Math.max(0, energy - 10);
    }

    public void rest() {
        energy = Math.min(100, energy + 20);
    }

    public int getEnergy() {
        return energy;
    }

    protected void changeEnergy(int delta) {
        energy = Math.max(0, Math.min(100, energy + delta));
    }

    @Override
    public String toString() {
        return name + " (" + species + ") energy=" + energy;
    }
}
