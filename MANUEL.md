# Manuel d'utilisation - Application de Gestion de Locations

## 📋 Présentation

Cette application est une API REST développée avec Spring Boot pour gérer des locations immobilières. Elle permet aux utilisateurs de publier des annonces de location, de consulter les offres disponibles et d'échanger des messages.

## 🎯 Fonctionnalités principales

### Gestion des utilisateurs
- **Inscription** : Créer un compte utilisateur avec nom, email et mot de passe
- **Authentification** : Se connecter de manière sécurisée
- **Profil** : Consulter et modifier ses informations personnelles

### Gestion des locations
- **Publier une annonce** : Ajouter une nouvelle location avec :
  - Nom de la propriété
  - Surface (en m²)
  - Prix (par mois)
  - Photo
  - Description détaillée
- **Consulter les annonces** : Parcourir toutes les locations disponibles
- **Modifier une annonce** : Mettre à jour ses propres annonces
- **Supprimer une annonce** : Retirer une location de la plateforme

### Messagerie
- **Envoyer un message** : Contacter le propriétaire d'une location
- **Consulter les messages** : Voir tous les messages reçus concernant vos locations

## 🏗️ Architecture de l'application

L'application suit une architecture en couches :

```
┌─────────────────────────────────────┐
│         Contrôleurs (API)          │  ← Interface REST
├─────────────────────────────────────┤
│          Services                   │  ← Logique métier
├─────────────────────────────────────┤
│          Repositories               │  ← Accès aux données
├─────────────────────────────────────┤
│       Base de données               │  ← Stockage persistant
└─────────────────────────────────────┘
```

### Entités principales

1. **User** (Utilisateur)
   - Informations personnelles (nom, email)
   - Gestion des locations possédées
   - Historique des messages

2. **Rental** (Location)
   - Détails de la propriété
   - Référence au propriétaire
   - Liste des messages associés

3. **Message**
   - Lien entre un utilisateur et une location
   - Contenu du message
   - Horodatage

## 🔒 Sécurité

- **Validation des données** : Toutes les entrées sont validées (format email, tailles maximales, valeurs positives)
- **Mot de passe** : Les mots de passe sont chiffrés avant stockage
- **Authentification** : Système de tokens pour sécuriser les échanges
- **Autorisation** : Les utilisateurs ne peuvent modifier que leurs propres contenus

## 🛠️ Technologies utilisées

- **Framework** : Spring Boot 4.0.1
- **Langage** : Java 17
- **Base de données** : JPA/Hibernate
- **Validation** : Jakarta Validation
- **Build** : Maven

## 📦 Structure du projet

```
src/main/java/
├── entity/          → Modèles de données (User, Rental, Message)
├── dto/             → Objets de transfert (validation des données)
├── mapper/          → Conversion Entity ↔ DTO
├── service/         → Logique métier
├── controller/      → Endpoints API REST
└── repository/      → Accès à la base de données
```

## 🚀 Démarrage rapide

1. **Prérequis**
   - Java 17 installé
   - Maven installé
   - Base de données configurée

2. **Configuration**
   - Éditer `application.properties` avec vos paramètres de base de données

3. **Lancement**
   ```bash
   mvn spring-boot:run
   ```

4. **Accès**
   - L'API est accessible sur `http://localhost:8080`

## 📝 Exemples d'utilisation

### Créer un utilisateur
```json
POST /api/users
{
  "name": "Jean Dupont",
  "email": "jean.dupont@example.com",
  "password": "motdepasse123"
}
```

### Publier une location
```json
POST /api/rentals
{
  "name": "Appartement T3 Centre-ville",
  "surface": 75,
  "price": 850,
  "picture": "https://example.com/photo.jpg",
  "description": "Bel appartement lumineux proche commerces"
}
```

### Envoyer un message
```json
POST /api/messages
{
  "rentalId": 1,
  "userId": 2,
  "message": "Bonjour, l'appartement est-il toujours disponible ?"
}
```

## 📞 Support

Pour toute question ou problème, veuillez consulter la documentation technique dans le fichier `README.md` ou contacter l'équipe de développement.

---

**Version** : 0.0.1-SNAPSHOT  
**Dernière mise à jour** : Décembre 2025
