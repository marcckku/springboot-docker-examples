


Creation of the Docker image using the Compose file - SpringBoot, Connection to MySql Database
=============
---

[`SPRINGBOOT`] ![ICON SPRINGBOOT](https://start.spring.io/icon_144x144.7d360c62a3c2b77823306d48e19a144b.png)   [`DOCKER`] ![ICON DOCKER](https://avatars.githubusercontent.com/u/7739233?s=200&v=4) 

[`MARIADB-MYSQL-PHPMYADMIN`] ![03_mariadb-mysql-phpmyadmin.png](03_mariadb-mysql-phpmyadmin.png)




- Minimal [Spring Boot v.3](http://projects.spring.io/spring-boot/)  ![SPRINGBOOT-INITIALIZR](https://spring.io/favicon-32x32.png?v=96334d577af708644f6f0495dd1c7bc8)  sample app
- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3.9.6](https://maven.apache.org)

- [Windows (WSL 2) Subsystem for Linux Documentation](https://learn.microsoft.com/en-us/windows/wsl/)
    * ![Windows - WSL2 Ubuntu 22.04](01_image_wsl.png)

- [Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/) after download and created account on Docker, it's necessary bind to subsystem WSL Windows.
    * ![Docker Desktop for Windows](02_image_docker_desktop.png)

- https://hub.docker.com/_/mariadb 
    * ![image-mariadb-server.png](11_image-mariadb-server.png)


### Commands
[Base Command Docker](https://docs.docker.com/reference/cli/docker/)

--- 

## IMAGE AND CONTAINER CREATION


#### **Step by step**
1. Create your project with [**Spring Initailizr**](https://start.spring.io/)  ![SPRINGBOOT-INITIALIZR](https://spring.io/favicon-32x32.png?v=96334d577af708644f6f0495dd1c7bc8)
  and create jar with [`mvn clean install`].

2. Create your Docker File named [`Dockerfile`] without extension at project level folder

    ```
     FROM openjdk:17-alpine
     EXPOSE 8181
     ADD target/*.jar springboot-app.jar
     ENTRYPOINT ["java","-jar","/springboot-app.jar"]
    ```
    Manual Docker : https://docs.docker.com/reference/dockerfile/ 
     - FROM — We need the JDK for the Spring application to run.
     - EXPOSE — tells which port it will run on.
     - ADD — the resulting jar is copied to the file named "springboot-app.jar".
     - ENTRYPOINT — set image main command - runs the previously copied jar file.

3. Create compose file with yaml extension [`docker-compose.yaml`].
  After defining the compose file, IntelliJ helps you execute it so as to create the Images: 
  [`SpringBoot App`, `MariaDB Server`, `PhpMyAdmin Client`]. A Container will be created and run, 
  with these images inside.
     
    ![play-docker-compose-file.png](04_play-docker-compose-file.png)

   - On IntelliJ IDEA you can see the results of the execution
     ![output-exec-compose-file.png](05_output-exec-compose-file-IntelliJ.png)

   - Also in Docker Desktop Client you can see the result:
      ![docker-desktop-client.png](06_output-exec-compose-file-docker-desktop.png)

   * PhpMyAdmin Client is up on localhost at port 8080 :
  
     ![phpmyadmin-console.png](07_phpmyadmin-console.png)

       - Server `db` created.
       - Database `demo_db` created.
       - Current User default `root`.
         ![phpmyadmin.png](08_phpmyadmin.png)

    * SpringBoot App is now running locally.
     ![img.png](09_app-running-locally.png)

    - Locally go to url http://localhost:8181/api/ip. 
      This endpoint adds the info as a new row in the database.
      ```
      {
        "msg": "Localhost Info!!",
        "ip": "177.10.0.2",
        "hostname": "a6e865e1oeba"
      }
      ``` 

   * MariaDB Server is running on port 3306 
     ![mariadb-server-default-port.png](10_mariadb-server-default-port.png)