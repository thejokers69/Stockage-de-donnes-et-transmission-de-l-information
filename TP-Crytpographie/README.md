# TP-Cryptographie

## Résumé des tâches de cryptographie

Ce dossier contient plusieurs tâches de cryptographie réalisées dans le cadre du TP de cryptographie. Les tâches incluent le chiffrement et le déchiffrement de messages en utilisant les algorithmes AES et RSA.

## Objectif de chaque tâche de cryptographie

### 1. Chiffrement AES
L'objectif de cette tâche est de chiffrer un message en utilisant l'algorithme AES (Advanced Encryption Standard). Le message est chiffré avec une clé secrète et le résultat est encodé en Base64.

### 2. Déchiffrement AES
L'objectif de cette tâche est de déchiffrer un message chiffré en utilisant l'algorithme AES. Le message chiffré est décodé de Base64 et déchiffré avec la même clé secrète utilisée pour le chiffrement.

### 3. Chiffrement RSA
L'objectif de cette tâche est de chiffrer un message en utilisant l'algorithme RSA (Rivest-Shamir-Adleman). Le message est chiffré avec une clé publique générée et peut être déchiffré avec la clé privée correspondante.

## Instructions pour exécuter les tâches de cryptographie

### 1. Chiffrement AES
Pour exécuter la tâche de chiffrement AES, utilisez la classe `AESCryptoApp` :
```bash
java -cp target/TP-Crytpographie-1.0-SNAPSHOT.jar ma.mundiapolis.AESCryptoApp
```

### 2. Déchiffrement AES
Pour exécuter la tâche de déchiffrement AES, utilisez la classe `AESDecryptoApp` :
```bash
java -cp target/TP-Crytpographie-1.0-SNAPSHOT.jar ma.mundiapolis.AESDecryptoApp
```

### 3. Chiffrement RSA
Pour exécuter la tâche de chiffrement RSA, utilisez la classe `CryptRSAAPP` :
```bash
java -cp target/TP-Crytpographie-1.0-SNAPSHOT.jar ma.mundiapolis.CryptRSAAPP
```

## Exemples de sortie attendue pour chaque tâche

### 1. Chiffrement AES
```
1_Y-pHZIHAozaLEpdvzG3IlYshSosx6-tWJDwKJaqss=
```

### 2. Déchiffrement AES
```
Bonjour tout le monde
```

### 3. Chiffrement RSA
```
Bonjour tout le monde
```
