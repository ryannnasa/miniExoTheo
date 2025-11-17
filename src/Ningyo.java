public class Ningyo extends Animal implements Swimmer, Predator {
    public Ningyo(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : glou glou (ningyō)");
    }

    @Override
    public void swim() {
        System.out.println(name + " nage en ondulant gracieusement.");
        changeEnergy(-4);
    }

    @Override
    public void hunt(Animal prey) {
        System.out.println(name + " attire puis attaque " + prey.name + " !");
        prey.changeEnergy(-30);
        changeEnergy(12);
    }

    @Override
    public void move() {
        System.out.println(name + " se déplace en nageant (ningyo).");
        swim();
    }
}
