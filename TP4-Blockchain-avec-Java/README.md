# TP4 - Blockchain avec Java

## Résumé des tâches de blockchain

Ce dossier contient plusieurs tâches de blockchain réalisées dans le cadre du TP de blockchain avec Java. Les tâches incluent la création de blocs, le calcul de hachages, et la vérification de la validité de la chaîne de blocs.

## Objectif de chaque tâche de blockchain

### 1. Création de blocs
L'objectif de cette tâche est de créer des blocs contenant des données, un index, un horodatage, un hachage actuel et un hachage précédent. Chaque bloc est lié au bloc précédent par son hachage.

### 2. Calcul de hachages
L'objectif de cette tâche est de calculer le hachage de chaque bloc en utilisant l'algorithme SHA-256. Le hachage est calculé à partir de l'index, des données, de l'horodatage et du hachage précédent.

### 3. Vérification de la validité de la chaîne de blocs
L'objectif de cette tâche est de vérifier la validité de la chaîne de blocs en s'assurant que le hachage précédent de chaque bloc correspond au hachage actuel du bloc précédent.

## Instructions pour exécuter les tâches de blockchain

### 1. Création de blocs
Pour exécuter la tâche de création de blocs, utilisez la classe `Main` :
```bash
java -cp target/TP4-Blockchain-avec-Java-1.0-SNAPSHOT.jar ma.mundiapolis.Main
```

## Exemples de sortie attendue pour chaque tâche

### 1. Création de blocs
```
BlockChain{index=0, data='block 1', timestamp=2023-10-01 12:00:00.0, currentHash='abc123', previousHash='0'}
BlockChain{index=1, data='block 2', timestamp=2023-10-01 12:01:00.0, currentHash='def456', previousHash='abc123'}
BlockChain{index=2, data='block 3', timestamp=2023-10-01 12:02:00.0, currentHash='ghi789', previousHash='def456'}
BlockChain{index=3, data='block 4', timestamp=2023-10-01 12:03:00.0, currentHash='jkl012', previousHash='ghi789'}
BlockChain{index=4, data='block 5', timestamp=2023-10-01 12:04:00.0, currentHash='mno345', previousHash='jkl012'}
```

### 2. Vérification de la validité de la chaîne de blocs
```
BlockChain is valid
```
