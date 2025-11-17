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
René fait : croâ ! (ribbit)
Michelle fait : blub blub
Jacques fait : ziziz... (buzz)
Suzuna fait : bzzzz (mosquito)
Alfred fait : ... (silence d'escargot)
René avant piqûre : 100
Suzuna pique René !
René après piqûre : 95
Alfred énergie avant déplacement: 100
Alfred se déplace très lentement...
Alfred énergie après déplacement: 99
```

Notes:

- `move()` réduit l'énergie de 10 (min 0).
- `rest()` augmente l'énergie de 20 (max 100).
- `Ningyo` est à la fois nageur (`Swimmer`) et prédateur (`Predator`) — il peut `swim()` et `hunt(prey)`.
- Les classes montrent héritage, interfaces, méthodes spécifiques et polymorphisme.

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
