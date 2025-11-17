public class Tombo extends Animal implements Flyer {
    public Tombo(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : zzzzz (libellule)");
    }

    @Override
    public void fly() {
        System.out.println(name + " s'envole et virevolte.");
        changeEnergy(-5);
    }

    @Override
    public void move() {
        System.out.println(name + " se déplace en volant (tombo).");
        fly();
    }
}
