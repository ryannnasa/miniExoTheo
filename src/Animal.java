public abstract class Animal extends Creature {
    public Animal(String name, String species) {
        super(name, species);
    }

    public abstract void makeSound();
}
