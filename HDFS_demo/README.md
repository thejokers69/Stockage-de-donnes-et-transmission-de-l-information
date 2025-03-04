# TP2 : Manipulation de HDFS avec une Application Java

⚠️ **Statut : En progression** ⚠️

## Introduction

Ce projet fait partie d’un TP sur la manipulation de HDFS avec Java, utilisant Hadoop 3.3.6 et Maven, dans un environnement Docker.

## Objectifs

Les objectifs du TP2 sont les suivants :
- Créer un répertoire /user/hadoop/appData dans HDFS s’il n’existe pas.
- Lister tous les fichiers et répertoires dans /user/hadoop/appData.
- Créer un fichier data.txt dans /user/hadoop/appData et y écrire "Bienvenue sur HDFS avec Java".
- Lire et afficher le contenu de /user/hadoop/appData/data.txt.
- Copier un fichier local test.txt dans HDFS sous /user/hadoop/appData/test.txt.
- Télécharger le fichier /user/hadoop/appData/test.txt depuis HDFS vers le système local.
- Renommer le fichier /user/hadoop/appData/data.txt en /user/hadoop/appData/data_v1.txt.
- Supprimer le fichier /user/hadoop/appData/data_v1.txt.
- Récupérer et afficher les métadonnées du fichier /user/hadoop/appData/test.txt.
- Vérifier l’espace disponible dans HDFS.
- Déplacer le fichier /user/hadoop/appData/test.txt dans /user/hadoop/archive/.
- Écrire un fichier CSV products.csv avec une liste de produits (ID, Nom, Prix).
- Lire et afficher le contenu de products.csv ligne par ligne.

## Prérequis

Assurez-vous d'avoir les outils suivants installés :
- Docker
- Java JDK 8+
- Maven
- IntelliJ IDEA (recommandé)

## Structure du projet

Le projet est structuré comme suit :
```
HDFS_demo/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── ma/
│               └── mundiapolis/
│                   └── tphdfs/
│                       └── App2.java
└── HDFSCluster/
    ├── config
    └── docker-compose.yaml
```

## Installation et configuration

### Étape 1 : Démarrer le cluster Hadoop avec Docker

```bash
docker-compose up -d
```

### Étape 2 : Vérifier via l’interface web

Accédez à l'interface web de HDFS à l'adresse : [http://localhost:9870](http://localhost:9870)

### Étape 3 : Commandes Maven pour compiler et exécuter

```bash
mvn clean package
java -jar target/HDFS-1.0-SNAPSHOT.jar
```

## Utilisation

Pour exécuter le programme, suivez les étapes ci-dessous :
1. Démarrez le cluster Hadoop avec Docker.
2. Compilez et exécutez le programme avec Maven.
3. Suivez les instructions affichées dans la console pour chaque opération.

## Exemple de sortie

Voici un extrait de la sortie console attendue :

```
Répertoire /user/hadoop/appData créé.
Liste des fichiers/répertoires dans /user/hadoop/appData :
data.txt - Fichier
test.txt - Fichier
Contenu de /user/hadoop/appData/data.txt :
Bienvenue sur HDFS avec Java.
Fichier test.txt copié dans HDFS.
Fichier test.txt téléchargé depuis HDFS.
Fichier data.txt renommé en data_v1.txt.
Fichier data_v1.txt supprimé.
Métadonnées de /user/hadoop/appData/test.txt :
Taille : 14 octets
Propriétaire : hadoop
Groupe : supergroup
Permissions : rw-r--r--
Date de modification : 1633024800000
Espace HDFS :
Capacité totale : 5000000000 octets
Espace utilisé : 1000000000 octets
Espace restant : 4000000000 octets
Fichier test.txt déplacé vers /user/hadoop/archive/.
Fichier products.csv créé dans HDFS.
Contenu de /user/hadoop/appData/products.csv :
ID,Nom,Prix
1,Laptop,999.99
2,Smartphone,499.99
3,Tablette,299.99
Opérations terminées.
```

## Problèmes connus

Le fichier local `test.txt` doit exister pour éviter une erreur `FileNotFoundException`.

## Conclusion

Ce TP2 est utile pour apprendre à manipuler HDFS avec Java, en utilisant un environnement Docker et des outils comme Maven et IntelliJ IDEA. Il couvre une variété d'opérations HDFS essentielles pour comprendre le fonctionnement des systèmes de fichiers distribués.
