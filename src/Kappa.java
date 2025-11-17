public class Kappa extends Animal implements Swimmer {
    public Kappa(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : croâ ! (ribbit)");
    }

    @Override
    public void swim() {
        System.out.println(name + " nage et éclabousse.");
        changeEnergy(-5);
    }
}
