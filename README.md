# Stockage de données et transmission de l'information

## Introduction
Ce projet regroupe les travaux pratiques du module "Stockage de données et transmission de l'information", axés sur la manipulation de HDFS avec Java et Hadoop 3.3.6 dans un environnement Docker. Il contient deux sous-projets :  
- **`HDFS_demo`** : Inclut TP1 (lecture/écriture HDFS) et TP2 (manipulation avancée de HDFS).  
- **`Hdfs`** : Spécifique à TP1 avec des ressources supplémentaires.  
**Note importante** : Le code de TP2 se trouve dans `HDFS_demo/src/main/java/ma/mundiapolis/tpHDFS/App2.java`.

## Statut
⚠️ **Statut : TP2 en progression** ⚠️

## Structure du projet
```
.
├── HDFS_demo
│   ├── HDFSCluster/
│   │   ├── config/
│   │   ├── docker-compose.yaml
│   │   ├── jars/
│   │   │   ├── HDFS-1.0-SNAPSHOT.jar
│   │   │   └── test.txt
│   │   └── test.sh
│   ├── README.md
│   ├── pom.xml
│   ├── src/main/java/ma/mundiapolis/tpHDFS/
│   │   ├── App1.java (TP1 - Lecture HDFS)
│   │   ├── App2.java (TP2 - Manipulation HDFS)
│   │   └── AppWriter.java (TP1 - Écriture HDFS)
│   └── target/ (fichiers compilés)
└── Hdfs
    ├── README.md
    ├── assets/ (images pour TP1)
    ├── config/
    ├── docker-compose.yaml
    ├── guideme.md
    ├── jars/
    └── test.sh
```

## Objectifs de TP2
- Créer `/user/hadoop/appData` dans HDFS s’il n’existe pas.
- Lister les fichiers/répertoires dans `/user/hadoop/appData`.
- Créer `data.txt` dans `/user/hadoop/appData` avec "Bienvenue sur HDFS avec Java".
- Lire et afficher `data.txt`.
- Copier `test.txt` local dans `/user/hadoop/appData/test.txt`.
- Télécharger `/user/hadoop/appData/test.txt` localement.
- Renommer `data.txt` en `data_v1.txt`.
- Supprimer `data_v1.txt`.
- Afficher les métadonnées de `test.txt`.
- Vérifier l’espace disponible dans HDFS.
- Déplacer `test.txt` vers `/user/hadoop/archive/`.
- Écrire `products.csv` avec une liste de produits (ID, Nom, Prix).
- Lire et afficher `products.csv` ligne par ligne.

## Prérequis
- Docker & Docker Compose 🐳
- Java JDK 8+ ☕
- Maven 📦
- IDE (ex. IntelliJ IDEA) 💻

## Installation et configuration
1. **Démarrer le cluster Hadoop** :
   - Allez dans `HDFS_demo/HDFSCluster/`.
   - Exécutez : `docker-compose up -d`.
   - Vérifiez : [http://localhost:9870](http://localhost:9870).
2. **Compiler TP2** :
   - Dans `HDFS_demo/`, exécutez : `mvn clean package`.
3. **Préparer `test.txt`** :
   - `echo "Ceci est un test" > test.txt`.

## Exécution de TP2
Dans `HDFS_demo/`, exécutez :
```bash
java -cp target/HDFS-1.0-SNAPSHOT.jar ma.mundiapolis.tpHDFS.App2
```
Cela lance `App2.java`, qui exécute toutes les tâches de TP2.

## Exemple de sortie
```
Répertoire /user/hadoop/appData créé.
Contenu de /user/hadoop/appData/data.txt :
Bienvenue sur HDFS avec Java.
Fichier test.txt copié dans HDFS.
[...]
```

## Notes pour les camarades
✅ TP2 est dans `HDFS_demo/src/main/java/ma/mundiapolis/tpHDFS/App2.java`. Ne confondez pas avec `Hdfs`, qui est uniquement pour TP1 !

## Problèmes connus
- ⚠️ Assurez-vous que `test.txt` existe localement, sinon erreur `FileNotFoundException`.

## Conclusion
Ce module explore le stockage distribué avec HDFS et Java. TP2, en cours de progression, renforce ces compétences avec des opérations avancées. 🚀
