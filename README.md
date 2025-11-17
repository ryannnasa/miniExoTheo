# Java Creatures (Créatures de la mythologie japonaise)

Petit projet Java démontrant héritage, interfaces, polymorphisme, et quelques patterns (Observer + Strategy).

**Fichiers principaux (dans `src/`)**

- `Creature.java`, `Animal.java`, `Main.java`
- Espèces : `Kappa.java`, `Ningyo.java`, `Tombo.java`, `Jorogumo.java`, `Katatsumuri.java`
- Interfaces : `Swimmer.java`, `Flyer.java`, `Predator.java`
- Utilitaires : `Utils.java`
- Diagramme : `src/diagram.puml` (source) et `src/diagram.png` (rendu)

Nouveautés (Observer + Strategy)

- `Weather.java`, `WeatherObserver.java` — Observable météo + interface d'observation.
- `Behavior.java` et implémentations : `ActiveBehavior`, `SleepingBehavior`, `HidingBehavior`.
- `AdaptiveCreature.java` — étend `Animal` et change de `Behavior` selon la météo et la température.

Design et règles rapides

- Conditions de météo gérées : `sunny`, `rainy`, `stormy`, `night`.
- Cartographie par défaut : `sunny` → actif, `rainy` → dort, `stormy` → cache.
- Règle supplémentaire : si `temperature < 0` alors comportement forcé `HidingBehavior`.
- Les créatures adaptatives peuvent être personnalisées via `setBehaviorFor(condition, behavior)`.

Diagramme

- Source PlantUML : `src/diagram.puml`
- Rendu (PNG) :

![Diagramme de classes](src/diagram.png)

Restitution (exemple d'exécution)

```text
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

--- Démonstration météo / comportements adaptatifs ---

Météo: sunny, 20°C
Aiko devient actif (sunny, 20°C)
Umi devient actif (sunny, 20°C)
Yoru devient actif (sunny, 20°C)

Météo: rainy, 15°C
Aiko se met à dormir (rainy, 15°C)
Umi se met à dormir (rainy, 15°C)
Yoru se cache (rainy, 15°C)

Météo: stormy, 12°C
Aiko se cache (stormy, 12°C)
Umi se cache (stormy, 12°C)
Yoru se cache (stormy, 12°C)

Météo: night, 10°C
Aiko devient actif (night, 10°C)
Umi devient actif (night, 10°C)
Yoru devient actif (night, 10°C)

Météo: sunny, -5°C (très froid)
Aiko se cache (sunny, -5°C)
Umi se cache (sunny, -5°C)
Yoru se cache (sunny, -5°C)
```
