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

# Java Pond Creatures (Créatures de la mythologie japonaise)

Brève présentation

Petit projet Java démontrant l'héritage, les interfaces et le polymorphisme via des créatures inspirées de la mythologie japonaise.

Fichiers principaux (dans `src/`)

- `Animal.java`, `Creature.java`, `Main.java`
- Espèces : `Kappa.java`, `Ningyo.java`, `Tombo.java`, `Jorogumo.java`, `Katatsumuri.java`
- Interfaces : `Swimmer.java`, `Flyer.java`, `Predator.java`
- Utilitaires : `Utils.java`
- Diagramme : `diagram.puml` (source) et `src/diagram.svg` (rendu, si présent)

Compilation et exécution (Windows PowerShell)

```powershell
# Option simple : compiler puis exécuter
javac -d out src\*.java
java -cp out Main

# Si vous avez des problèmes d'encodage (accents) :
chcp 65001
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
$OutputEncoding = [System.Text.Encoding]::UTF8
javac -encoding UTF-8 -d out src\*.java
java -Dfile.encoding=UTF-8 -cp out Main
```

Comportement et notes rapides

- Chaque créature possède une énergie (0–100). Les actions (`move`, `swim`, `fly`, `bite`, `hunt`, etc.) modifient l'énergie via une méthode de changement d'énergie.
- `rest()` restaure de l'énergie (ex. +20, plafonné à 100).
- Interfaces utiles : `Swimmer` (nage), `Flyer` (vol), `Predator` (chasse).

Diagramme

- Le fichier source du diagramme est `src/diagram.puml`. Un rendu SVG peut se trouver dans `src/diagram.svg`.
- Si vous souhaitez que j'exporte ou régénère le diagramme en PNG/SVG, dites-moi quel format vous préférez.

Contributions et améliorations possibles

- Extraire les coûts d'énergie en constantes (`private static final`) pour faciliter les réglages.
- Ajouter des tests unitaires ou un petit script d'exécution pour scénarios d'exemple.

Besoin d'autre chose ?

- Je peux : générer le rendu du diagramme, extraire les constantes de coûts, ou raccourcir encore davantage ce README selon vos préférences.
