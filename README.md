# DeepAI - Backend Plateforme IA (Java)

Projet de Programmation Orientée Objet (POO) en Java pour la plateforme **DeepAI**.

## Auteurs (Binôme)
- Étudiant : Abdenour GH
- Université de Corse - gueniot_f@univ-corse.fr

---

## 1. Description du Projet
DeepAI est une plateforme de backend pour modèles d'intelligence artificielle proposant :
- **Trois modèles d'IA** adaptés selon les cas d'usage :
  - `DeepFast` : Modèle rapide et économique (0,10 $ / MTok).
  - `DeepMedium` : Modèle polyvalent (0,50 $ / MTok).
  - `DeepThink` : Modèle à raisonnement avancé (1,00 $ / MTok).
- **Deux canaux d'accès** :
  - `DeepChat` : Interface de discussion interactive.
  - `DeepBot` : API pour agents autonomes (CLI / VSCode).
- **Monétisation au token** : Facturation transparente par token consommé, incluant le prompt système et l'intégralité de l'historique de la conversation.
- **Gestion utilisateurs** : Comptes avec solde provisionnable et profilage pour publicités ciblées.

---

## 2. Diagramme de Classes UML

```mermaid
classDiagram
    %% Hiérarchie des modèles
    ModeleIA <|-- DeepFast
    ModeleIA <|-- DeepMedium
    ModeleIA <|-- DeepThink

    %% Hiérarchie des services
    DeepService <|-- DeepChat
    DeepService <|-- DeepBot

    %% Compositions et associations
    Utilisateur "1" *-- "0..*" Conversation : possède
    Conversation "1" *-- "1..*" Message : contient
    Conversation "0..*" --> "1" ModeleIA : utilise

    %% Dépendances
    DeepService ..> Utilisateur : débite & profile
    DeepService ..> Conversation : met à jour
    DeepService ..> ModeleIA : sollicite

    class ModeleIA {
        <<abstract>>
        #String nom
        #double tarifParMTok
        +calculerPrix(int nbTokens) double
        +genererReponse(String prompt)* String
    }

    class DeepFast {
        +genererReponse(String prompt) String
    }

    class DeepMedium {
        +genererReponse(String prompt) String
    }

    class DeepThink {
        +genererReponse(String prompt) String
    }

    class Message {
        -String role
        -String contenu
        +estimerTokens() int
    }

    class Conversation {
        -String id
        -ModeleIA modele
        -List~Message~ messages
        +ajouterMessage(Message msg) void
        +calculerTokensTotaux() int
    }

    class Utilisateur {
        -String nom
        -String email
        -double solde
        -List~Conversation~ historique
        -List~String~ donneesPersonnelles
        +rechargerSolde(double montant) void
        +debiterSolde(double montant) boolean
        +ajouterDonneePub(String donnee) void
    }

    class DeepService {
        <<abstract>>
        #String promptSysteme
        +calculerTokens(Conversation c, String prompt) int
        +traiterRequete(Utilisateur u, Conversation c, String msg)* String
    }

    class DeepChat {
        +traiterRequete(Utilisateur u, Conversation c, String msg) String
    }

    class DeepBot {
        +executerMission(Utilisateur u, ModeleIA m, String mission) String
    }
```

---

## 3. Mention relative à l'usage de l'IA générative
Conformément aux consignes du cours, l'assistance d'outils d'IA générative a été utilisée avec parcimonie pour la structuration initiale de l'architecture UML et le brainstorming des cas de test. L'ensemble des règles de gestion orientée objet et du code Java a été implémenté et validé par le binôme.
