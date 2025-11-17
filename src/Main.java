public class Main {
    public static void main(String[] args) {
        Animal[] pond = new Animal[] {
                new Kappa("René", "kappa"),
                new Ningyo("Michelle", "ningyo"),
                new Tombo("Jacques", "Tombo"),
                new Jorogumo("Suzuna", "Jorogumo"),
                new Katatsumuri("Alfred", "Katatsumuri")
        };

        for (Animal a : pond) {
            a.makeSound();
        }

        // Démonstration : faire nager toutes les créatures nageuses via
        // Utils.makeSwim()
        for (Animal a : pond) {
            if (a instanceof Swimmer) {
                System.out.println(a.name + " va nager via Utils.makeSwim()");
                System.out.println(a.name + " énergie avant nage: " + a.getEnergy());
                Utils.makeSwim((Swimmer) a);
                System.out.println(a.name + " énergie après nage: " + a.getEnergy());
            }
        }

        Jorogumo m = (Jorogumo) pond[3];
        Animal target = pond[0];
        System.out.println(target.name + " avant piqûre : " + target.getEnergy());
        m.bite(target);
        System.out.println(target.name + " après piqûre : " + target.getEnergy());

        Katatsumuri s = (Katatsumuri) pond[4];
        System.out.println(s.name + " énergie avant déplacement: " + s.getEnergy());
        s.move();
        System.out.println(s.name + " énergie après déplacement: " + s.getEnergy());

        Ningyo n = (Ningyo) pond[1];
        System.out.println(n.name + " énergie avant chasse: " + n.getEnergy());
        System.out.println(target.name + " énergie avant d'être chassé: " + target.getEnergy());
        n.hunt(target);
        System.out.println(target.name + " énergie après chasse: " + target.getEnergy());
        System.out.println(n.name + " énergie après chasse: " + n.getEnergy());
    }
}
