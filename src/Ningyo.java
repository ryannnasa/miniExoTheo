public class Ningyo extends Animal implements Swimmer, Predator {
    public Ningyo(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : blub blub");
    }

    @Override
    public void swim() {
        System.out.println(name + " nage doucement.");
        changeEnergy(-5);
    }

    @Override
    public void hunt(Animal prey) {
        System.out.println(name + " attire puis attaque " + prey.name + " !");
        prey.changeEnergy(-25);
        changeEnergy(10);
    }
}
