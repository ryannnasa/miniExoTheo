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
        // Le ningyo inflige des dégâts importants mais récupère un peu d'énergie
        prey.changeEnergy(-30);
        changeEnergy(12);
    }

    @Override
    public void move() {
        // Le déplacement d'un ningyo correspond à la nage
        System.out.println(name + " se déplace en nageant (ningyo).");
        swim();
    }
}
