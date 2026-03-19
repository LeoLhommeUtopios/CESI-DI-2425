# TP Java Spring Boot — Design Patterns en Pratique

---

## Contexte

Vous allez construire un module de gestion de commandes pour une plateforme e-commerce fictive appelée **ShopFlow**. Ce module gère le cycle de vie d'une commande (`PLACED → PAID → SHIPPED → DELIVERED`) en mettant en œuvre quatre design patterns GoF.

| Pattern | Catégorie | Rôle dans le projet |
|---|---|---|
| **Observer** | Comportemental | Notifier les services (email, SMS, stock) à chaque changement d'état |
| **Décorateur** | Structurel | Enrichir le service de notification (logging, retry, filtrage) |
| **Composite** | Structurel | Modéliser des articles simples et des packs dans une commande |
| **Factory** | Créationnel | Instancier le bon service de livraison selon le mode choisi |

---

## 01 — Mise en place du projet

### Dépendances Maven

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.0</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Structure du projet

```
src/main/java/com/shopflow/
├── ShopFlowApplication.java
│
├── model/
│   ├── Order.java
│   ├── OrderItem.java
│   └── OrderStatus.java
│
├── composite/
│   ├── OrderComponent.java       ← interface
│   ├── ProductItem.java          ← Feuille (Leaf)
│   └── ProductBundle.java        ← Composite
│
├── factory/
│   ├── DeliveryService.java      ← interface
│   ├── StandardDelivery.java
│   ├── ExpressDelivery.java
│   ├── PickupDelivery.java
│   └── DeliveryFactory.java      ← Factory
│
├── observer/
│   ├── OrderObserver.java        ← interface
│   ├── EmailNotificationObserver.java
│   ├── SmsNotificationObserver.java
│   ├── StockUpdateObserver.java
│   └── OrderEventPublisher.java  ← Subject
│
├── decorator/
│   ├── NotificationService.java  ← interface
│   ├── BaseNotificationService.java
│   ├── LoggingNotificationDecorator.java
│   └── RetryNotificationDecorator.java
│
├── service/
│   └── OrderService.java
│
└── controller/
    └── OrderController.java
```

---

## 02 — Pattern Composite — Articles & Packs

Une commande peut contenir des **articles simples** ou des **packs** (bundle de plusieurs articles). Les deux doivent exposer la même interface pour le calcul du prix total.

> **Principe :** Traiter uniformément objets individuels et compositions via une interface commune `OrderComponent`.


### Exercice 2.1 — Test du Composite

1. Créez un `ProductBundle` **"Pack Bureau"** (quantité 1) contenant :
   - Écran (299€ x1)
   - Clavier (49€ x1)
   - Souris (29€ x2)
2. Créez une `List<OrderComponent>` représentant une commande, ajoutez-y le pack et un article simple **"Câble HDMI"** (12€ x3).
3. Implémentez une méthode `double calculateOrderTotal(List<OrderComponent>)` et affichez la structure avec `display(0)`.
4. Vérifiez que le total affiché est **442€**.

---

## 03 — Pattern Factory — Services de livraison

Selon le mode de livraison choisi lors du passage de commande, on instancie le service approprié sans coupler le code client aux classes concrètes.

> **Principe :** La Factory encapsule la logique de création. Le client ne connaît que l'interface `DeliveryService`.


### Exercice 3.1 — Étendre la Factory

1. Créez un mode **`SAME_DAY`** (livraison le jour même, délai 0 jour, coût 24.99€).
2. Ajoutez une méthode `DeliveryService createCheapest(List<String> availableModes)` qui retourne le mode le moins cher parmi ceux fournis.

---

## 04 — Pattern Observer — Notifications de commande

À chaque changement d'état d'une commande, plusieurs services doivent être notifiés : envoi d'email, SMS, mise à jour du stock.

> **Principe :** L'Observable (`OrderEventPublisher`) maintient une liste d'Observers et les notifie automatiquement à chaque événement.


### Exercice 4.1 — Nouvel observateur conditionnel

1. Créez un observateur `FraudDetectionObserver` qui logue une alerte si le montant total dépasse **1000€** lors du passage en status `PAID`.
2. Enregistrez-le comme bean Spring (`@Component`) et vérifiez qu'il est bien découvert automatiquement.


---

## 05 — Pattern Décorateur — Service de notification enrichi

On veut ajouter des comportements transversaux au service de notification de base (logging des performances, retry automatique) **sans modifier** la classe de base.

> **Principe :** Chaque décorateur enveloppe un `NotificationService` et délègue l'appel tout en ajoutant son comportement avant/après.


### Exercice 5.1 — Décorateur de filtrage

1. Créez `SpamFilterNotificationDecorator` qui refuse d'envoyer si le sujet contient `"promo"`, `"gratuit"` ou `"offre"` (case-insensitive) et logue un avertissement.
2. Ajoutez ce décorateur en première couche dans `NotificationConfig`.
3. Dessinez sur papier la chaîne de décorateurs obtenue et indiquez l'ordre d'appel des méthodes `send()`.

---

## 06 — Intégration — OrderService

Le `OrderService` orchestre les quatre patterns : Factory pour la livraison, Composite pour le calcul du total, Observers pour les événements, Décorateur pour l'envoi de notification.

### Exercice 6.1 — Intégration complète

1. Complétez l'entité `Order.java` avec les annotations JPA (`@Entity`, `@Id`, `@GeneratedValue`, etc.).
2. Créez le DTO `CreateOrderRequest` avec Lombok.
3. Lancez l'application et testez via **curl** ou **Postman** :
   - `POST /api/orders` avec un body JSON (email, téléphone, mode de livraison, articles).
   - `PATCH /api/orders/1/status?status=PAID` et observez les logs des 4 observers.
4. Accédez à la console H2 (`http://localhost:8080/h2-console`) et vérifiez la persistance.

---
