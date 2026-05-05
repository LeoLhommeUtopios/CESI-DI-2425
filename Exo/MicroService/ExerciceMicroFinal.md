
# Sujet de TP — Plateforme de gestion de tâches (architecture microservices)
## Objectif 
Concevoir et implémenter une application de gestion de tâches collaborative inspirée de Trello en utilisant une architecture microservices.

L’application devra permettre à plusieurs utilisateurs de créer des tableaux, organiser des tâches et collaborer en temps réel (simplifié).

# Implementation des services

## Service Utilisateurs 

### Règles à implémenter :

* Un email doit être **unique**
* Mot de passe :

  * longueur minimale (ex : 8 caractères)
* Un utilisateur peut être :

  * `ADMIN`
  * `MEMBER`

### Comportements métier :

* Impossible de supprimer un utilisateur s’il est assigné à des tâches actives
* Gestion d’un statut :

  * `ACTIVE`
  * `INACTIVE`

Cas concret :

* Si un utilisateur devient INACTIVE → il ne peut plus être assigné à une tâche

---

## Service Boards

### Règles :

* Un board doit avoir :

  * un nom unique
* Un board a un **propriétaire**
* Limite de membres (ex : max 10)

### Colonnes par défaut :

* `TODO`
* `IN_PROGRESS`
* `DONE`

### Comportements métier :

* Seul le propriétaire peut :

  * supprimer le board
  * ajouter des membres
* Un utilisateur ne peut voir que :

  * les boards auxquels il appartient

---

## Service Tâches

### Structure d’une tâche :

* titre (obligatoire)
* description
* statut (`TODO`, `IN_PROGRESS`, `DONE`)
* priorité (`LOW`, `MEDIUM`, `HIGH`)
* date limite (optionnelle)

---

### Règles métier importantes :

#### 1. Cycle de vie des tâches

* `TODO → IN_PROGRESS → DONE`
* Impossible de revenir en arrière :

  * DONE → TODO ❌

---

#### 2. Assignation

* Une tâche ne peut être assignée qu’à :

  * un membre du board
* Impossible d’assigner :

  * un utilisateur INACTIVE

---

#### 3. Limite de travail

* Un utilisateur ne peut pas avoir :

  * plus de **5 tâches en IN_PROGRESS**

---

#### 4. Priorité et deadlines

* Si date limite dépassée :

  * statut passe automatiquement en `OVERDUE` (bonus)
* Une tâche `HIGH` priorité :

  * doit être traitée avant les autres (logique de tri)

---

#### 5. Suppression

* Une tâche `DONE` depuis plus de X jours :

  * peut être archivée automatiquement (bonus)

---

## Service Gateway

### Structure des controller
* UserController (permet l'aces au endpoint du microService User)
* BoardController (permet l'aces au endpoint du microService Board)
* TacheController (permet l'aces au endpoint du microService Tache)
* NotificationController (permet l'aces au endpoint du microService Notification)

---


## Service Notifications (Bonus)

### Déclencheurs :

* Création de tâche
* Assignation
* Changement de statut

---

### Règles :

* Ne pas envoyer de notification :

  * si l’utilisateur est INACTIVE
* Regrouper les notifications :

  * éviter le spam (ex : batch toutes les 5 secondes)

---

### Types :

* `TASK_ASSIGNED`
* `TASK_COMPLETED`
* `DEADLINE_APPROACHING`

---

## Logique inter-services 

### Cas métier complet :

Création d’une tâche :

1. Vérifier que le board existe (Boards Service)
2. Vérifier que l’utilisateur est membre (Users + Boards)
3. Créer la tâche (Tasks)
4. Envoyer un événement → Notifications

---

Assignation d’une tâche :

1. Vérifier utilisateur actif (Users)
2. Vérifier membre du board (Boards)
3. Vérifier limite de tâches (Tasks)
4. Assigner
5. Notifier

---

## TESTS

### Tests unitaires :

* Refus assignation utilisateur INACTIVE
* Refus dépassement limite tâches
* Respect du workflow (TODO → DONE)

---

### Tests d’intégration :

* Création complète avec validations métier
* Assignation valide vs invalide


---

##  Déploiement

Chaque microservice est conteneurisé indépendamment :
>- users-service
>- boards-service
>- tasks-service
>- notifications-service


* Chaque service doit contenir un fichier Dockerfile.

* Créer un fichier docker-compose.yml pour lancer toute l’architecture.
