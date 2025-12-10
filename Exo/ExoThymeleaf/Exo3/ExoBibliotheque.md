# Exercice Spring Boot : Application de Gestion de Bibliothèque

## Objectif
Créer une application web de gestion de bibliothèque utilisant Spring Data JPA, Thymeleaf et Spring Security.

## Contexte
Vous devez développer une application permettant de gérer une bibliothèque avec deux types d'utilisateurs : les **bibliothécaires** (ADMIN) et les **lecteurs** (USER).

## Fonctionnalités à implémenter

### 1. Gestion des utilisateurs (Spring Security)
- **Authentification** : formulaire de connexion
- **Rôles** :
  - `ROLE_USER` : peut consulter les livres et emprunter
  - `ROLE_ADMIN` : peut ajouter/modifier/supprimer des livres
- **Inscription** : page d'enregistrement pour les nouveaux lecteurs

### 2. Gestion des livres (Spring Data JPA)
- **Entité Livre** avec les attributs :
  - id (Long)
  - titre (String)
  - auteur (String)
  - isbn (String)
  - genre (Enum) - ex: Roman, Science-Fiction, Fantastique, Policier, Biographie, etc.
  - disponible (Boolean)
  - dateAjout (LocalDate)

- **Repository** : créer une interface qui étend JpaRepository
- **Requêtes personnalisées** :
  - Rechercher par titre (contient)
  - Rechercher par auteur
  - Rechercher par genre
  - Trouver tous les livres disponibles
  - Filtrer par genre et disponibilité

### 3. Interface utilisateur (Thymeleaf)

#### Pages à créer :
1. **Page de connexion** (`/login`)
2. **Page d'accueil** (`/`) - liste des livres
3. **Page d'ajout de livre** (`/livres/ajouter`) - réservée aux ADMIN
4. **Page de détail d'un livre** (`/livres/{id}`)
5. **Page de recherche** (`/livres/rechercher`)

## Bonus (optionnel)
- Implémenter un système d'emprunt de livres
- Ajouter la pagination avec `Pageable`
