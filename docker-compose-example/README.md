
[`SPRINGBOOT`] ![ICON SPRINGBOOT](https://start.spring.io/icon_144x144.7d360c62a3c2b77823306d48e19a144b.png)   [`DOCKER`] ![ICON DOCKER](https://avatars.githubusercontent.com/u/7739233?s=200&v=4)  [`MARIADB-MYSQL-PHPMYADMIN`] ![03_mariadb-mysql-phpmyadmin.png](03_mariadb-mysql-phpmyadmin.png)


---
Spring Boot App Mysql Database Connection - Docker Image Creation Orchestrated through Compose file
=============

# Required Setup

- [**Spring Boot v.3**](http://projects.spring.io/spring-boot/)  ![SPRINGBOOT-INITIALIZR](https://spring.io/favicon-32x32.png?v=96334d577af708644f6f0495dd1c7bc8) or above
- [**Install Java**](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/windows-install.html) locally and set environment variable system.
    - [Download JDK 17 ORACLE](https://www.oracle.com/java/technologies/downloads/#java17)
    - [Download JDK 17 AMAZON CORRETTO](https://github.com/corretto/corretto-17/releases)
- [**Maven 3.9.6**](https://maven.apache.org)
    1. **Installing Maven on Windows**:
        1. The environment variable for JAVA also needs to be set beforehand
        2. [**Download Maven zip**](https://maven.apache.org/download.cgi) **apache-maven-3.9.6-bin.zip** on your Computer locally.
        3. Unzip or Extract folder and put on at C disk level.
        4. Create the MAVEN_HOME system environment variable that points to the **_C:\apache-maven-3.9.6_** folder path.
           ![env_system_var.png.png](env_system_var.png)
       5. Verify the correct MAVEN installation by command [`mvn -v`] ![maven-verify-installation.png](maven-verify-installation.png)

- [Install Plugin Docker on IntelliJ IDEA](https://plugins.jetbrains.com/plugin/7724-docker)
    * ![docker-plugin-on-intellij.png](docker-plugin-on-intellij.png)

- [Windows (WSL 2) Subsystem for Linux Documentation](https://learn.microsoft.com/en-us/windows/wsl/)
    * ![Windows - WSL2 Ubuntu 22.04](01_image_wsl.png)

- [Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/) after download and created account on Docker, it's necessary bind to subsystem WSL Windows.
    * ![Docker Desktop for Windows](02_image_docker_desktop.png)

----

## IMAGE AND CONTAINER CREATION


### **Step by step**

##### [Docker - Base Commands](https://docs.docker.com/reference/cli/docker/)

1. Create  project with [**Spring Initailizr**](https://start.spring.io/)  ![SPRINGBOOT-INITIALIZR](https://spring.io/favicon-32x32.png?v=96334d577af708644f6f0495dd1c7bc8) and built project and create jar with [`mvn clean install`].

2. Create **Docker File** named [`Dockerfile`] without extension at project level folder 
   * ![12_Dockerfile-no-extension.png](12_Dockerfile-no-extension.png)
    
   *  Inside this file insert this simple configuration to create the image of our App.

       ```
        FROM openjdk:17-alpine
        EXPOSE 8181
        ADD target/*.jar springboot-app.jar
        ENTRYPOINT ["java","-jar","/springboot-app.jar"]
       ```
   * [Dockerfile reference](https://docs.docker.com/reference/dockerfile/)
     - FROM — We need the JDK for the Spring application to run.
     - EXPOSE — tells which port it will run on.
     - ADD — the resulting jar is copied to the file named "springboot-app.jar".
     - ENTRYPOINT — set image main command - runs the previously copied jar file.


3. Create **compose file** with yaml extension [`docker-compose.yaml`].
   IntelliJ helps you run and create images through Docker Plugin:
    - [`SpringBoot App`, `MariaDB Server`, `PhpMyAdmin Client`]. 
    - A Container will be created and run it with these images.
    - The Spring Boot App will be orchestrated by Dockerfile.
     
      ![play-docker-compose-file.png](04_play-docker-compose-file.png)

     - After executed the **Compose File** by Plugin on IntelliJ IDEA you can see the results of the execution :
       ![output-exec-compose-file.png](05_output-exec-compose-file-IntelliJ.png)

     - On Docker Desktop Client you can see the result:
        ![docker-desktop-client.png](06_output-exec-compose-file-docker-desktop.png)

       1. PhpMyAdmin Client is up on localhost at port 8080 :
         ![phpmyadmin-console.png](07_phpmyadmin-console.png)
           - Server `db` created.
           - Database `demo_db` created.
           - Current User default `root`.
             ![phpmyadmin.png](08_phpmyadmin.png)

       2. SpringBoot App is now running locally.
          ![09_app-running-locally.png](09_app-running-locally.png)
           - Locally go to url http://localhost:8181/api/ip. 
             This endpoint adds the info as a new row in the database.
            
            ```
              {
                "msg": "Localhost Info!!",
                "ip": "177.10.0.2",
                "hostname": "a6e865e1oeba"
              }
            ```
         
       3. MariaDB Server is running on port 3306 
        
          ![mariadb-server-default-port.png](10_mariadb-server-default-port.png)

           * As a result 3 images were created:
               1. [x] Spring Boot App (Inside of Container)
               2. [x] MariaDB Server (Database Mysql)
               3. [x] PhpMyAdmin Client
           - and one Container
               1. [x] container_docker_compose_example



****
In summary:
>  We have seen the creation of a Docker image from Spring Boot app that connects to a Mysql Database and its Client
orchestrated by Composer file and Dockerfile from Plugin Docker on IntelliJ IDE.


That's all!!...
*** 
