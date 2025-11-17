public class Katatsumuri extends Animal {
    public Katatsumuri(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : ... (silence d'escargot)");
    }

    @Override
    public void move() {
        System.out.println(name + " se déplace très lentement en laissant une trace de mucus.");
        changeEnergy(-1);
    }
}
