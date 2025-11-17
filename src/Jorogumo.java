public class Jorogumo extends Animal {
    public Jorogumo(String name, String species) {
        super(name, species);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " fait : sss... (jorogumo)");
    }

    public void bite(Animal target) {
        System.out.println(name + " pique " + target.name + " !");
        target.changeEnergy(-6);
    }

    @Override
    public void move() {
        System.out.println(name + " se faufile et tisse sa toile.");
        changeEnergy(-7);
    }
}
