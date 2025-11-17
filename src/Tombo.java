public class Tombo extends Animal implements Flyer {
    public Tombo(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : ziziz... (buzz)");
    }

    @Override
    public void fly() {
        System.out.println(name + " s'envole en bourdonnant.");
        changeEnergy(-5);
    }
}
