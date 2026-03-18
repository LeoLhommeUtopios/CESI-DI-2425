Exercice : Adapter - Conversion de devises

Objectif :
Utilisez le pattern Adapter pour connecter une classe existante `CurrencyConverter` à une interface standardisée appelée `CurrencyAdapter`. 
La classe existante utilise des taux fixes pour convertir des devises, mais l'interface impose un modèle générique.

Tâches :
1. Créez l'interface `CurrencyAdapter` avec une méthode `convert(String fromCurrency, String toCurrency, double amount)`.
2. Implémentez l'adaptateur pour utiliser les méthodes spécifiques de `CurrencyConverter`.
3. Testez la conversion entre plusieurs devises dans une classe principale.