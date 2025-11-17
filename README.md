# Java Pond Creatures (Créatures de la mythologie japonaise)

Petit projet Java qui montre des classes `Animal` adaptées de créatures de la mythologie japonaise,
avec héritage, interfaces et polymorphisme.

Fichiers présents:

- `src/Animal.java`
- `src/Kappa.java` (grenouille/kappa)
- `src/Ningyo.java` (poisson/ningyo) — implémente `Swimmer` et `Predator`
- `src/Tombo.java` (libellule)
- `src/Jorogumo.java` (yōkai araignée / mosquito-like)
- `src/Katatsumuri.java` (escargot)
- `src/Swimmer.java`, `src/Flyer.java`, `src/Predator.java`
- `src/Utils.java` (utilitaire `makeSwim`)
- `src/Main.java`

Compilation et exécution (Windows PowerShell):

```powershell
# Compiler tous les fichiers java du dossier 'src' dans 'out'
javac -d out src\*.java
# Exécuter
java -cp out Main
```

Exemple de sortie attendue (partielle) :

```
René fait : kwa kwa ! (kappa croak)
Michelle fait : glou glou (ningyō)
Jacques fait : zzzzz (libellule)
Suzuna fait : sss... (jorogumo)
Alfred fait : ... (silence d'escargot)
René va nager via Utils.makeSwim()
René énergie avant nage: 100
René nage et éclabousse.
René énergie après nage: 94
Michelle va nager via Utils.makeSwim()
Michelle énergie avant nage: 100
Michelle nage en ondulant gracieusement.
Michelle énergie après nage: 96
René avant piqûre : 94
Suzuna pique René !
René après piqûre : 88
Alfred énergie avant déplacement: 100
Alfred se déplace très lentement en laissant une trace de mucus.
Alfred énergie après déplacement: 99
Michelle énergie avant chasse: 96
René énergie avant d'être chassé: 88
Michelle attire puis attaque René !
René énergie après chasse: 58
Michelle énergie après chasse: 100
```

Notes détaillées

- Modèle d'énergie

  - Chaque créature a une énergie comprise entre `0` et `100`.
  - `move()` / `swim()` / `fly()` / `bite()` / `hunt()` ajustent l'énergie via `changeEnergy(delta)`.
  - `rest()` restaure `+20` d'énergie (max 100).

- Coûts et comportements (par espèce)

  - `Kappa` (grenouille/kappa)

    - Son: `"kwa kwa ! (kappa croak)"`
    - `swim()`: cost `-6` (affiche "nage et éclabousse").
    - `move()`: redirigé vers `swim()` (se déplace en nageant).

  - `Ningyo` (poisson mythologique)

    - Son: `"glou glou (ningyō)"`
    - `swim()`: cost `-4` (nage gracieuse).
    - `hunt(prey)`: inflige `-30` à la proie et récupère `+12`.
    - `move()`: redirigé vers `swim()`.

  - `Tombo` (libellule / `Tombo`)

    - Son: `"zzzzz (libellule)"`
    - `fly()`: cost `-5` (virevolte).
    - `move()`: redirigé vers `fly()`.

  - `Jorogumo` (yōkai araignée-like)

    - Son: `"sss... (jorogumo)"`
    - `bite(target)`: inflige `-6` à la cible.
    - `move()`: décrit tissage/faufilage, cost `-7`.

  - `Katatsumuri` (escargot)
    - Son: `"... (silence d'escargot)"`
    - `move()`: très lent, cost `-1`, message: "se déplace très lentement en laissant une trace de mucus".

- Interfaces utiles
  - `Swimmer` : `swim()` — implémenté par `Kappa`, `Ningyo`.
  - `Flyer` : `fly()` — implémenté par `Tombo`.
  - `Predator` : `hunt(prey)` — implémenté par `Ningyo`.
  - `Utils.makeSwim(Swimmer)` : utilitaire pour appeler `swim()` sur n'importe quel nageur.

Diagramme de classes (Mermaid)

```mermaid
classDiagram
    class Creature {
        - energy: int = 100
        + name: String
        + species: String
        + Creature(name, species)
        + move()
        + rest()
        + getEnergy(): int
        # changeEnergy(delta)
    }

    class Animal {
        <<abstract>>
        + Animal(name, species)
        + makeSound()
    }

    interface Swimmer {
        + swim()
    }

    interface Flyer {
        + fly()
    }

    interface Predator {
        + hunt(prey: Animal)
    }

    class Kappa {
        + Kappa(name, species)
        + makeSound()
        + swim()
        + move()
    }

    class Ningyo {
        + Ningyo(name, species)
        + makeSound()
        + swim()
        + hunt(prey)
        + move()
    }

    class Tombo {
        + Tombo(name, species)
        + makeSound()
        + fly()
        + move()
    }

    class Jorogumo {
        + Jorogumo(name, species)
        + makeSound()
        + bite(target: Animal)
        + move()
    }

    class Katatsumuri {
        + Katatsumuri(name, species)
        + makeSound()
        + move()
    }

    class Utils {
        + makeSwim(creature: Swimmer)
    }

    Creature <|-- Animal
    Animal <|-- Kappa
    Animal <|-- Ningyo
    Animal <|-- Tombo
    Animal <|-- Jorogumo
    Animal <|-- Katatsumuri

    Swimmer <|.. Kappa
    Swimmer <|.. Ningyo
    Flyer <|.. Tombo
    Predator <|.. Ningyo

    Utils ..> Swimmer : uses
    Jorogumo ..> Animal : bite()
    Ningyo ..> Animal : hunt()
```

Notes pratiques

- Pour éviter les problèmes d'affichage d'accents dans PowerShell (mojibake), utilisez UTF-8:

  ```powershell
  chcp 65001
  [Console]::OutputEncoding = [System.Text.Encoding]::UTF8
  $OutputEncoding = [System.Text.Encoding]::UTF8
  javac -encoding UTF-8 -d out src\*.java
  java -Dfile.encoding=UTF-8 -cp out Main
  ```

- Si vous voulez une image du diagramme Mermaid (PNG/SVG) dans le repo, je peux la générer et l'ajouter.

- Pour les réglages de coûts énergétiques, je peux extraire des constantes par classe (`private static final int SWIM_COST = X`) pour rendre les valeurs faciles à modifier.

Diagramme de classes (Mermaid)

```mermaid
classDiagram
  class Creature {
    - energy: int = 100
    + name: String
    + species: String
    + Creature(name, species)
    + move()
    + rest()
    + getEnergy(): int
    # changeEnergy(delta)
  }

  class Animal {
    <<abstract>>
    + Animal(name, species)
    + makeSound()
  }

  interface Swimmer {
    + swim()
  }

  interface Flyer {
    + fly()
  }

  interface Predator {
    + hunt(prey: Animal)
  }

  class Kappa {
    + Kappa(name, species)
    + makeSound()
    + swim()
  }

  class Ningyo {
    + Ningyo(name, species)
    + makeSound()
    + swim()
    + hunt(prey)
  }

  class Tombo {
    + Tombo(name, species)
    + makeSound()
    + fly()
  }

  class Jorogumo {
    + Jorogumo(name, species)
    + makeSound()
    + bite(target: Animal)
  }

  class Katatsumuri {
    + Katatsumuri(name, species)
    + makeSound()
    + move()  // override très lent
  }

  class Utils {
    + makeSwim(creature: Swimmer)
  }

  Creature <|-- Animal
  Animal <|-- Kappa
  Animal <|-- Ningyo
  Animal <|-- Tombo
  Animal <|-- Jorogumo
  Animal <|-- Katatsumuri

  Swimmer <|.. Kappa
  Swimmer <|.. Ningyo
  Flyer <|.. Tombo
  Predator <|.. Ningyo

  Utils ..> Swimmer : uses
  Jorogumo ..> Animal : bite()
  Ningyo ..> Animal : hunt()
```

Notes pratiques

- Pour éviter les problèmes d'affichage d'accents dans PowerShell (mojibake), utilisez UTF-8:

  ```powershell
  chcp 65001
  [Console]::OutputEncoding = [System.Text.Encoding]::UTF8
  $OutputEncoding = [System.Text.Encoding]::UTF8
  javac -encoding UTF-8 -d out src\*.java
  java -Dfile.encoding=UTF-8 -cp out Main
  ```

- Le fichier contenant le diagramme est `src/diagram.puml` (si vous voulez utiliser PlantUML plutôt que Mermaid).

- Si vous voulez que j'exporte le diagramme Mermaid en PNG/SVG (via un rendu local ou un service), dites-le-moi.

# Java Pond Creatures (Créatures de la mythologie japonaise)

Petit projet Java qui montre la classe `Creature` convertie depuis TypeScript/JS en Java.

Fichiers créés:

- `src/Animal.java`
- `src/Frog.java`
- `src/Fish.java`
- `src/Dragonfly.java`
- `src/Mosquito.java`
- `src/Snail.java`
- `src/Main.java`

Compilation et exécution (Windows PowerShell):

```powershell
# Compiler tous les fichiers java du dossier 'src' dans 'out'
javac -d out src\*.java
# Exécuter
java -cp out Main
```

Exemple de sortie attendue (partielle) :

```
René fait : croâ ! (ribbit)
Mimi fait : blub blub
Tsubasa fait : ziziz... (buzz)
Suzu fait : bzzzz (mosquito)
Koro fait : ... (silence d'escargot)
René avant piqûre : 100
Suzu pique René !
René après piqûre : 95
Koro énergie avant déplacement: 100
Koro se déplace très lentement...
Koro énergie après déplacement: 99
```

Notes:

- `move()` réduit l'énergie de 10 (min 0).
  -- `rest()` augmente l'énergie de 20 (max 100).
  -- Les classes montrent héritage, méthodes spécifiques et polymorphisme.
