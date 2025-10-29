
## Exercice 2

### Partie 1

Créer un **CRUD** sur une entité **Ordinateur**.

```java
Ordinateur
    String : marque
    String : modele
    double : prix
    boolean : portable
```

---

### Partie 2

Ajouter à notre **Ordinateur** un objet **Identification** (adresse MAC et adresse IP)
qui sera relié à notre ordinateur via une **relation OneToOne** ou un **Embedded**.

```java
Identification
    String : adressImac
    String : adressIp
```

---

### Partie 3

Notre **Ordinateur** aura un **système d’exploitation** qui pourra être partagé entre plusieurs ordinateurs.

```java
SystemeExploitation
    String : nom
    String : version
    String : architecture
    String : developpeur
    String : noyau
    String : dateSortie
```

> `@ManyToOne` entre `Ordinateur` et `SystemeExploitation`
> (Un système d’exploitation peut être installé sur plusieurs ordinateurs.)

---

### Partie 4

Notre **Ordinateur** pourra posséder **plusieurs périphériques**,
et chaque **périphérique** pourra être associé à **plusieurs ordinateurs**.

On souhaite :

* Un **CRUD complet** sur les **périphériques**
* Un **affichage des ordinateurs associés à un périphérique**
* La **possibilité d’afficher les périphériques d’un ordinateur**

```java
Peripherique
    String : nom
    String : type
    String : modele
    String : typeConnexion
    boolean : sansFil
    boolean : entree
    boolean : sortie
```

> `@ManyToMany` entre `Ordinateur` et `Peripherique`.

