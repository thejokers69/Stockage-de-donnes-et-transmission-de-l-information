package ma.mundiapolis.tpHDFS;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.*;
import java.net.URI;

public class App2 {
    public static void main(String[] args) throws IOException {
        // Configuration HDFS
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:8020"); // Assurez-vous que cela correspond à votre cluster
        FileSystem fs = FileSystem.get(URI.create("hdfs://namenode:8020"), conf);

        // 1. Créer un répertoire /user/hadoop/appData s’il n’existe pas
        // Commande : hdfs dfs -mkdir -p /user/hadoop/appData
        Path appDataPath = new Path("/user/hadoop/appData");
        if (!fs.exists(appDataPath)) {
            fs.mkdirs(appDataPath);
            System.out.println("Répertoire /user/hadoop/appData créé.");
        } else {
            System.out.println("Répertoire /user/hadoop/appData existe déjà.");
        }

        // 2. Lister tous les fichiers et répertoires dans /user/hadoop/appData
        // Commande : hdfs dfs -ls /user/hadoop/appData
        System.out.println("\nListe des fichiers/répertoires dans /user/hadoop/appData :");
        FileStatus[] fileStatuses = fs.listStatus(appDataPath);
        for (FileStatus status : fileStatuses) {
            System.out.println(status.getPath().getName() + " - " + (status.isDirectory() ? "Répertoire" : "Fichier"));
        }

        // 3. Créer un fichier data.txt et y écrire du texte
        // Commande : echo "Bienvenue sur HDFS avec Java" | hdfs dfs -put - /user/hadoop/appData/data.txt
        Path dataPath = new Path("/user/hadoop/appData/data.txt");
        FSDataOutputStream outputStream = fs.create(dataPath, true); // true pour écraser si existe
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("Bienvenue sur HDFS avec Java.");
        writer.close();
        System.out.println("\nFichier data.txt créé et texte écrit.");

        // 4. Lire et afficher le contenu de data.txt
        // Commande : hdfs dfs -cat /user/hadoop/appData/data.txt
        System.out.println("\nContenu de /user/hadoop/appData/data.txt :");
        FSDataInputStream inputStream = fs.open(dataPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // 5. Copier un fichier local test.txt dans HDFS
        // Commande : hdfs dfs -put test.txt /user/hadoop/appData/test.txt
        Path localTestPath = new Path("test.txt"); // Assurez-vous que ce fichier existe localement
        Path hdfsTestPath = new Path("/user/hadoop/appData/test.txt");
        fs.copyFromLocalFile(localTestPath, hdfsTestPath);
        System.out.println("\nFichier test.txt copié dans HDFS.");

        // 6. Télécharger le fichier test.txt depuis HDFS vers le système local
        // Commande : hdfs dfs -get /user/hadoop/appData/test.txt test_downloaded.txt
        Path localDownloadPath = new Path("test_downloaded.txt");
        fs.copyToLocalFile(hdfsTestPath, localDownloadPath);
        System.out.println("Fichier test.txt téléchargé depuis HDFS.");

        // 7. Renommer data.txt en data_v1.txt
        // Commande : hdfs dfs -mv /user/hadoop/appData/data.txt /user/hadoop/appData/data_v1.txt
        Path renamedDataPath = new Path("/user/hadoop/appData/data_v1.txt");
        fs.rename(dataPath, renamedDataPath);
        System.out.println("Fichier data.txt renommé en data_v1.txt.");

        // 8. Supprimer le fichier data_v1.txt
        // Commande : hdfs dfs -rm /user/hadoop/appData/data_v1.txt
        fs.delete(renamedDataPath, false); // false pour ne pas supprimer récursivement
        System.out.println("Fichier data_v1.txt supprimé.");

        // 9. Récupérer et afficher les métadonnées de test.txt
        // Commande : hdfs dfs -stat /user/hadoop/appData/test.txt
        FileStatus testFileStatus = fs.getFileStatus(hdfsTestPath);
        System.out.println("\nMétadonnées de /user/hadoop/appData/test.txt :");
        System.out.println("Taille : " + testFileStatus.getLen() + " octets");
        System.out.println("Propriétaire : " + testFileStatus.getOwner());
        System.out.println("Groupe : " + testFileStatus.getGroup());
        System.out.println("Permissions : " + testFileStatus.getPermission());
        System.out.println("Date de modification : " + testFileStatus.getModificationTime());

        // 10. Vérifier l’espace disponible dans HDFS
        // Commande : hdfs dfsadmin -report
        FsStatus fsStatus = fs.getStatus();
        long capacity = fsStatus.getCapacity();
        long used = fsStatus.getUsed();
        long remaining = fsStatus.getRemaining();
        System.out.println("\nEspace HDFS :");
        System.out.println("Capacité totale : " + capacity + " octets");
        System.out.println("Espace utilisé : " + used + " octets");
        System.out.println("Espace restant : " + remaining + " octets");

        // 11. Déplacer test.txt vers /user/hadoop/archive/
        // Commande : hdfs dfs -mkdir -p /user/hadoop/archive
        // Commande : hdfs dfs -mv /user/hadoop/appData/test.txt /user/hadoop/archive/test.txt
        Path archivePath = new Path("/user/hadoop/archive/");
        if (!fs.exists(archivePath)) {
            fs.mkdirs(archivePath);
        }
        Path newTestPath = new Path("/user/hadoop/archive/test.txt");
        fs.rename(hdfsTestPath, newTestPath);
        System.out.println("Fichier test.txt déplacé vers /user/hadoop/archive/.");

        // 12. Écrire un fichier CSV products.csv
        // Commande : echo "ID,Nom,Prix\n1,Laptop,999.99\n2,Smartphone,499.99\n3,Tablette,299.99" | hdfs dfs -put - /user/hadoop/appData/products.csv
        Path csvPath = new Path("/user/hadoop/appData/products.csv");
        FSDataOutputStream csvOutput = fs.create(csvPath, true);
        BufferedWriter csvWriter = new BufferedWriter(new OutputStreamWriter(csvOutput));
        csvWriter.write("ID,Nom,Prix\n");
        csvWriter.write("1,Laptop,999.99\n");
        csvWriter.write("2,Smartphone,499.99\n");
        csvWriter.write("3,Tablette,299.99\n");
        csvWriter.close();
        System.out.println("\nFichier products.csv créé dans HDFS.");

        // 13. Lire et afficher le contenu de products.csv ligne par ligne
        // Commande : hdfs dfs -cat /user/hadoop/appData/products.csv
        System.out.println("\nContenu de /user/hadoop/appData/products.csv :");
        FSDataInputStream csvInput = fs.open(csvPath);
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(csvInput));
        while ((line = csvReader.readLine()) != null) {
            System.out.println(line);
        }
        csvReader.close();

        // Fermer la connexion au FileSystem
        fs.close();
        System.out.println("\nOpérations terminées.");
    }
}
