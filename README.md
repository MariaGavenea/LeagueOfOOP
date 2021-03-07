# LeagueOfOOP

Actiunea jocului are loc pe o harta 2D. La inceput, pe harta, se vor afla eroi in diverse pozitii.

Jocul este impartit in runde. La fiecare runda vor avea loc batalii intre eroi care se afla in aceeasi locatie de pe harta. De asemenea, la finalul unei runde, vor aparea ingeri in diverse pozitii care vor ajuta sau incurca eroii din acele locatii. 

Un alt personaj important in acest joc este Marele Magician. El doreste sa observe cand un jucator moare/reinvie, cand un inger apare sau cand acesta ajuta/incurca pe cineva. La fiecare runda, sunt afisate informatiile dorite de Marele Magician. 

Jocul se incheie dupa un numar prestabilit de runde si sunt afisate statistici despre starea fiecarui jucator.

## I. Harta

Harta pe care se desfasoara jocul are forma dreptunghiulara si contine locatii de anumite tipuri:
- Land
- Volcanic
- Desert
- Woods

## II. Eroii

### 1. Tipuri de eroi:
- Knight
- Pyromancer
- Rogue
- Wizard

### 2. Proprietati eroi:
- HP (viata)
- XP (experienta)
- level

Initial, jucatorii au un anumit HP (specific fiecarui tip de erou), 0 puncte experienta si se afla la nivelul 0.
Atunci cand un erou avanseaza la urmatorul nivel, va reveni la 100% HP.

### 3. Abilitati

Fiecare tip de erou are un anumit set de abilitati ale caror efecte depind de terenul pe care se desfasoara lupta (land modifier) si de personajul asupra caruia actioneaza (race modifier).

Damage-ul dat de catre un erou creste odata cu nivelul.

#### a. Abilitati Pyromancer

- **Fireblast** - damage mare in runda curenta
- **Ignite** - damage in runda curenta si damage mai mic in urmatoarele 2 runde (abilitate cu **efect in timp**)

Teren ce amplifica puterile acestui erou: **Volcanic**

#### b. Abilitati Knight

- **Execute** - damage in runda curenta sau, daca adversarul are un numar de HP mai mic decat o anumita limita, va fi ucis instantaneu
- **Slam** - damage si imposibilitate de miscare a adversarului pentru urmatoarea runda

Teren ce amplifica puterile acestui erou: **Land**

#### c. Abilitati Wizard

- **Drain** - scade din viata adversarului proportional cu cat are deja
- **Deflect** - da damage egal cu un procent din damage-ul total (fara race modifiers) pe care il primeste de la adversar
              - nu are niciun efect asupra unui Wizard

Teren ce amplifica puterile acestui erou: **Desert**

#### d. Abilitati Rogue

- **Backstab** - damage in runda curenta
- **Paralysis** - damage prelungit + imposibilitatea de miscare a adversarului pentru un numar de runde  (abilitate cu **efect in timp**)

Teren ce amplifica puterile acestui erou: **Woods**

### 4. Strategii

Fiecare erou adopta o strategie de atac sau de aparare, in functie de situatie. Ei au considerat ca in anumite cazuri ar fi mai bine să scada din HP si sa dea mai mult damage, sau invers.

## III. Ingerii

Exista mai multe tipuri de ingeri care se impart in doua categorii, ingeri buni si rai. 

**Tipuri de ingeri buni**:
- care cresc HP-ul (LifeGiver, GoodBoy, SmallAngel)
- reinvie jucatori (Spawner)
- cresc modificatori de damage (DamageAngel, GoodBoy, LevelUpAngel, SmallAngel)
- cresc XP-ul (XPAngel)
- cresc XP-ul pana cand un jucator ajunge la urmatorul nivel (LevelUpAngel)

**Tipuri de ingeri rai**:
- scad HP-ul (DarkAngel, Dracula)
- omoara un jucator (TheDoomer)
- scad modificatorii de damage (Dracula)
