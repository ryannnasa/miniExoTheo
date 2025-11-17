public class Kappa extends Animal implements Swimmer {
    public Kappa(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : kwa kwa ! (kappa croak)");
    }

    @Override
    public void swim() {
        System.out.println(name + " nage et éclabousse.");
        changeEnergy(-6);
    }

    @Override
    public void move() {
        System.out.println(name + " se déplace en nageant (kappa).");
        swim();
    }
}
