# Excercice1 - Projet 3 OpenClassrooms

Application Spring Boot pour la gestion de locations (ChaTop).

## 📋 Prérequis

- **Java** : Version 17 ou supérieure
- **Maven** : Version 3.6+ (wrapper inclus dans le projet)
- **MySQL** : Version 8.0+
- **IDE** : VS Code, IntelliJ IDEA, Eclipse (recommandé : VS Code)

## 🔧 Technologies utilisées

- **Spring Boot** : 4.0.1-SNAPSHOT
- **Spring Data JPA** : Gestion de la persistance
- **Spring Security** : Sécurisation de l'application
- **JWT (JSON Web Tokens)** : Authentification (jjwt 0.11.5)
- **MySQL Connector** : Driver de base de données
- **Lombok** : Réduction du code boilerplate
- **Hibernate** : ORM (via JPA)

## 📁 Structure du projet

```
excercice1/
├── src/
│   ├── main/
│   │   ├── java/com/openclassrooms/projet3/excercice1/
│   │   │   ├── entity/          # Entités JPA (User, Rental, Message)
│   │   │   └── Excercice1Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## ⚙️ Configuration de la base de données

### 1. Créer la base de données MySQL

```sql
CREATE DATABASE chatop_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'kevin'@'localhost' IDENTIFIED BY 'votre_mot_de_passe';
GRANT ALL PRIVILEGES ON chatop_db.* TO 'kevin'@'localhost';
FLUSH PRIVILEGES;
```

### 2. Configurer la variable d'environnement

**Windows (PowerShell)** :
```powershell
[System.Environment]::SetEnvironmentVariable('DB_PASSWORD', 'votre_mot_de_passe', 'User')
```

**Windows (cmd)** :
```cmd
setx DB_PASSWORD "votre_mot_de_passe"
```

**Linux/Mac** :
```bash
export DB_PASSWORD="votre_mot_de_passe"
```

> ⚠️ **Important** : Redémarrez votre terminal après avoir défini la variable d'environnement système.

### 3. Configuration actuelle (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/chatop_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=kevin
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🚀 Installation et démarrage

### 1. Cloner ou télécharger le projet

```bash
cd c:\StarsheepStudio\Professionel\OpenClassrooms\Projet3\excercice1
```

### 2. Vérifier que MySQL est démarré

```powershell
# Windows
Get-Service MySQL*
```

### 3. Compiler le projet

```powershell
.\mvnw.cmd clean install
```

### 4. Lancer l'application

**Option 1 : Avec Maven Wrapper** (recommandé)
```powershell
.\mvnw.cmd spring-boot:run
```

**Option 2 : Avec Java directement**
```powershell
.\mvnw.cmd package
java -jar target\excercice1-0.0.1-SNAPSHOT.jar
```

### 5. Vérifier le démarrage

L'application démarre par défaut sur le port **8080**.

```
Console : http://localhost:8080
```

Si Tomcat démarre correctement, vous verrez :
```
Tomcat started on port 8080 (http)
Started Excercice1Application in X.XXX seconds
```

## 🧪 Tests

Lancer les tests unitaires :

```powershell
.\mvnw.cmd test
```

## 📦 Packaging

Créer un fichier JAR exécutable :

```powershell
.\mvnw.cmd clean package
```

Le fichier JAR sera généré dans : `target/excercice1-0.0.1-SNAPSHOT.jar`

## 🐛 Résolution des problèmes courants

### Erreur : "Public Key Retrieval is not allowed"

✅ **Solution** : Le paramètre `allowPublicKeyRetrieval=true` est déjà ajouté dans l'URL de connexion.

### Erreur : "class file has wrong version"

✅ **Solution** : Vérifiez que vous utilisez Java 17+ :
```powershell
java -version
```

### Erreur : "Access denied for user"

✅ **Solution** : Vérifiez que :
1. La variable `DB_PASSWORD` est correctement définie
2. L'utilisateur MySQL `kevin` existe avec les bons droits
3. Le mot de passe est correct

### L'application ne démarre pas

1. Vérifiez que MySQL est en cours d'exécution
2. Vérifiez que le port 8080 n'est pas déjà utilisé
3. Consultez les logs dans la console

## 📝 Entités disponibles

- **User** : Utilisateurs de l'application
- **Rental** : Locations disponibles
- **Message** : Messages entre utilisateurs

## 🔐 Sécurité

L'application utilise :
- **Spring Security** pour la sécurisation des endpoints
- **JWT** pour l'authentification stateless
- **Variable d'environnement** pour le mot de passe de la base de données

## 📄 Licence

Projet d'exercice OpenClassrooms - Projet 3

## 👤 Auteur

Kevin Renault

---

**Note** : Ce projet est en cours de développement. Les endpoints REST et la documentation API seront ajoutés prochainement.
