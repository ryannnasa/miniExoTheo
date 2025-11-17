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
        System.out.println();
        System.out.println("--- Démonstration météo / comportements adaptatifs ---");

        Weather weather = new Weather("sunny", 20);

        AdaptiveCreature ac1 = new AdaptiveCreature("Aiko", "adaptive-kappa");
        AdaptiveCreature ac2 = new AdaptiveCreature("Umi", "adaptive-ningyo");
        AdaptiveCreature ac3 = new AdaptiveCreature("Yoru", "adaptive-tombo");

        ac2.setBehaviorFor("night", new ActiveBehavior());
        ac3.setBehaviorFor("rainy", new HidingBehavior());

        weather.addObserver(ac1);
        weather.addObserver(ac2);
        weather.addObserver(ac3);

        System.out.println("\nMétéo: sunny, 20°C");
        weather.setWeather("sunny", 20);

        System.out.println("\nMétéo: rainy, 15°C");
        weather.setWeather("rainy", 15);

        System.out.println("\nMétéo: stormy, 12°C");
        weather.setWeather("stormy", 12);

        System.out.println("\nMétéo: night, 10°C");
        weather.setWeather("night", 10);

        System.out.println("\nMétéo: sunny, -5°C (très froid)");
        weather.setWeather("sunny", -5);
    }
}
