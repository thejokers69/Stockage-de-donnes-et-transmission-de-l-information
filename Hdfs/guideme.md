# Guide to Handling HDFS with a Java Application using IntelliJ IDEA

## Prerequisites
* Ensure you have Docker Desktop installed and running on your machine. 🐳
* Install IntelliJ IDEA on your machine. 💻
* Ensure you have Java JDK 8 or higher installed. ☕

## Step 1: Set up Hadoop environment using Docker
* Create a `docker-compose.yaml` file in your project directory with the following content to set up Hadoop services:
  ```yaml
  version: "2"
  services:
     namenode:
        image: apache/hadoop:3.3.6
        hostname: namenode
        command: ["hdfs", "namenode"]
        ports:
          - 9870:9870
          - 8020:8020
        env_file:
          - ./config
        environment:
            ENSURE_NAMENODE_DIR: "/tmp/hadoop-root/dfs/name"
        volumes:
          - ./jars:/opt/hadoop/jars          
     datanode1:
        image: apache/hadoop:3.3.6
        hostname: datanode1
        command: ["hdfs", "datanode"]
        env_file:
          - ./config
     datanode2:
            image: apache/hadoop:3.3.6
            hostname: datanode2
            command: ["hdfs", "datanode"]
            env_file:
              - ./config    
     datanode3:
            image: apache/hadoop:3.3.6
            hostname: datanode3
            command: ["hdfs", "datanode"]
            env_file:
              - ./config       
     datanode4:
            image: apache/hadoop:3.3.6
            hostname: datanode4
            command: ["hdfs", "datanode"]
            env_file:
              - ./config         
     datanode5:
            image: apache/hadoop:3.3.6
            hostname: datanode5
            command: ["hdfs", "datanode"]
            env_file:
              - ./config                                                                                    
     resourcemanager:
        image: apache/hadoop:3.3.6
        hostname: resourcemanager
        command: ["yarn", "resourcemanager"]
        ports:
           - 8088:8088
        env_file:
          - ./config
        volumes:
          - ./test.sh:/opt/test.sh
     nodemanager:
        image: apache/hadoop:3.3.6
        command: ["yarn", "nodemanager"]
        env_file:
          - ./config
  ```
* Create a `config` file in the same directory with the necessary Hadoop configurations:
  ```plaintext
  CORE-SITE.XML_fs.default.name=hdfs://namenode
  CORE-SITE.XML_fs.defaultFS=hdfs://namenode
  HDFS-SITE.XML_dfs.namenode.rpc-address=namenode:8020
  HDFS-SITE.XML_dfs.replication=3
  MAPRED-SITE.XML_mapreduce.framework.name=yarn
  MAPRED-SITE.XML_yarn.app.mapreduce.am.env=HADOOP_MAPRED_HOME=$HADOOP_HOME
  MAPRED-SITE.XML_mapreduce.map.env=HADOOP_MAPRED_HOME=$HADOOP_HOME
  MAPRED-SITE.XML_mapreduce.reduce.env=HADOOP_MAPRED_HOME=$HADOOP_HOME
  YARN-SITE.XML_yarn.resourcemanager.hostname=resourcemanager
  YARN-SITE.XML_yarn.nodemanager.pmem-check-enabled=false
  YARN-SITE.XML_yarn.nodemanager.delete.debug-delay-sec=600
  YARN-SITE.XML_yarn.nodemanager.vmem-check-enabled=false
  YARN-SITE.XML_yarn.nodemanager.aux-services=mapreduce_shuffle
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.maximum-applications=10000
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.maximum-am-resource-percent=0.1
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.resource-calculator=org.apache.hadoop.yarn.util.resource.DefaultResourceCalculator
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.queues=default
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.default.capacity=100
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.default.user-limit-factor=1
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.default.maximum-capacity=100
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.default.state=RUNNING
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.default.acl_submit_applications=*
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.root.default.acl_administer_queue=*
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.node-locality-delay=40
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.queue-mappings=
  CAPACITY-SCHEDULER.XML_yarn.scheduler.capacity.queue-mappings-override.enable=false
  ```

## Step 2: Start Hadoop services
* Open a terminal and navigate to the directory containing the `docker-compose.yaml` file.
* Run the following command to start the Hadoop services:
  ```bash
  docker-compose up -d
  ```
* Verify that the services are running by accessing the NameNode web interface at http://localhost:9870/. 🌐

## Step 3: Create a new Java project in IntelliJ IDEA
* Open IntelliJ IDEA and create a new Java project. 🆕
* Add the necessary Hadoop dependencies to your `pom.xml` file if you are using Maven:
  ```xml
  <dependency>
      <groupId>org.apache.hadoop</groupId>
      <artifactId>hadoop-client</artifactId>
      <version>3.3.6</version>
  </dependency>
  ```

## Step 4: Write Java code to interact with HDFS
* Create a new Java class in your project to handle HDFS operations. 📄
* Use the following sample code to connect to HDFS and perform basic file operations:
  ```java
  import org.apache.hadoop.conf.Configuration;
  import org.apache.hadoop.fs.FileSystem;
  import org.apache.hadoop.fs.Path;

  import java.io.IOException;
  import java.net.URI;

  public class HdfsExample {
      public static void main(String[] args) throws IOException {
          Configuration configuration = new Configuration();
          configuration.set("fs.defaultFS", "hdfs://localhost:9870");
          FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9870"), configuration);

          // Create a directory
          Path dirPath = new Path("/user/hadoop/example");
          if (!fileSystem.exists(dirPath)) {
              fileSystem.mkdirs(dirPath);
          }

          // Create a file
          Path filePath = new Path("/user/hadoop/example/file.txt");
          if (!fileSystem.exists(filePath)) {
              fileSystem.create(filePath);
          }

          // List files in the directory
          fileSystem.listStatus(dirPath);

          // Close the file system
          fileSystem.close();
      }
  }
  ```

## Step 5: Run the Java application
* In IntelliJ IDEA, right-click on the Java class and select "Run" to execute the application. ▶️
* Verify the operations by checking the HDFS web interface at http://localhost:9870/. 🌐

## Step 6: Additional HDFS operations
* You can extend the Java code to include more HDFS operations such as reading files, deleting files, and copying files between local and HDFS. 📂

## Considerations
* Ensure that the Hadoop services are running before executing the Java application. 🏃‍♂️
* Handle exceptions and errors appropriately in your Java code. ⚠️
* Use appropriate logging to monitor the operations and debug issues. 📝
