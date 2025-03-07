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

## Commandes pour chaque question de TP2

### 1. Créer un répertoire /user/hadoop/appData dans HDFS s’il n’existe pas
```bash
hdfs dfs -mkdir -p /user/hadoop/appData
```

### 2. Lister tous les fichiers et répertoires dans /user/hadoop/appData
```bash
hdfs dfs -ls /user/hadoop/appData
```

### 3. Créer un fichier data.txt dans /user/hadoop/appData et y écrire "Bienvenue sur HDFS avec Java"
```bash
echo "Bienvenue sur HDFS avec Java" | hdfs dfs -put - /user/hadoop/appData/data.txt
```

### 4. Lire et afficher le contenu de /user/hadoop/appData/data.txt
```bash
hdfs dfs -cat /user/hadoop/appData/data.txt
```

### 5. Copier un fichier local test.txt dans HDFS sous /user/hadoop/appData/test.txt
```bash
hdfs dfs -put test.txt /user/hadoop/appData/test.txt
```

### 6. Télécharger le fichier /user/hadoop/appData/test.txt depuis HDFS vers le système local
```bash
hdfs dfs -get /user/hadoop/appData/test.txt test_downloaded.txt
```

### 7. Renommer le fichier /user/hadoop/appData/data.txt en /user/hadoop/appData/data_v1.txt
```bash
hdfs dfs -mv /user/hadoop/appData/data.txt /user/hadoop/appData/data_v1.txt
```

### 8. Supprimer le fichier /user/hadoop/appData/data_v1.txt
```bash
hdfs dfs -rm /user/hadoop/appData/data_v1.txt
```

### 9. Récupérer et afficher les métadonnées du fichier /user/hadoop/appData/test.txt
```bash
hdfs dfs -stat /user/hadoop/appData/test.txt
```

### 10. Vérifier l’espace disponible dans HDFS
```bash
hdfs dfsadmin -report
```

### 11. Déplacer le fichier /user/hadoop/appData/test.txt dans /user/hadoop/archive/
```bash
hdfs dfs -mkdir -p /user/hadoop/archive
hdfs dfs -mv /user/hadoop/appData/test.txt /user/hadoop/archive/test.txt
```

### 12. Écrire un fichier CSV products.csv avec une liste de produits (ID, Nom, Prix)
```bash
echo "ID,Nom,Prix\n1,Laptop,999.99\n2,Smartphone,499.99\n3,Tablette,299.99" | hdfs dfs -put - /user/hadoop/appData/products.csv
```

### 13. Lire et afficher le contenu de products.csv ligne par ligne
```bash
hdfs dfs -cat /user/hadoop/appData/products.csv
```

## Problèmes connus

Le fichier local `test.txt` doit exister pour éviter une erreur `FileNotFoundException`.

## Conclusion

Ce TP2 est utile pour apprendre à manipuler HDFS avec Java, en utilisant un environnement Docker et des outils comme Maven et IntelliJ IDEA. Il couvre une variété d'opérations HDFS essentielles pour comprendre le fonctionnement des systèmes de fichiers distribués.
