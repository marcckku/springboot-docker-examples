


 Simple SpringBoot  Docker Image Example
=============
---

[`SPRINGBOOT`] ![ICON SPRINGBOOT](https://start.spring.io/icon_144x144.7d360c62a3c2b77823306d48e19a144b.png)   [`DOCKER`] ![ICON DOCKER](https://avatars.githubusercontent.com/u/7739233?s=200&v=4) 


- Minimal [Spring Boot v.3](http://projects.spring.io/spring-boot/)  ![SPRINGBOOT-INITIALIZR](https://spring.io/favicon-32x32.png?v=96334d577af708644f6f0495dd1c7bc8)  sample app
- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3.9.6](https://maven.apache.org)

- [Windows (WSL 2) Subsystem for Linux Documentation](https://learn.microsoft.com/en-us/windows/wsl/) 
   * ![Windows - WSL2 Ubuntu 22.04](01_image_wsl.png)

- [Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/) after download and created account on Docker, it's necessary bind to subsystem WSL Windows. 
  * ![Docker Desktop for Windows](02_image_docker_desktop.png)


### Step by step
* Create your project with [**Spring Initailizr**](https://start.spring.io/)  ![SPRINGBOOT-INITIALIZR](https://spring.io/favicon-32x32.png?v=96334d577af708644f6f0495dd1c7bc8) 
and create jar with [`mvn clean install`].

* Create your Docker File named [`Dockerfile`] without extension at project level folder 

 ```
  FROM openjdk:17-jdk-alpine
  VOLUME /tmp
  ARG JAVA_OPTS
  ENV JAVA_OPTS=$JAVA_OPTS
  COPY target/docker-0.0.1-SNAPSHOT.jar docker.jar
  EXPOSE 8181
  ENTRYPOINT exec java $JAVA_OPTS -jar docker.jar
```

## Commands
[Base Command Docker](https://docs.docker.com/reference/cli/docker/)

# CREATE IMAGE 
3. Command that creates a Image Docker with name. Execute at root level project.

     ```
        docker build -t docker-image:my-tag .
     ```
   
   -  Command images list
       ``` 
          docker images
       ``` 
   
       ``` 
      output: 
          PS docker-simple-example\docker> docker images   
          REPOSITORY        TAG             IMAGE ID       CREATED          SIZE
       -> docker-image      my-tag          635c7d0e3032   10 minutes ago   376MB
          myimage-1         mytag-1         9e3b555bbe6b   2 days ago       565MB
          eclipse-temurin   17-jdk-focal    b1b08304f7e3   7 days ago       411MB
          openjdk           17-jdk-alpine   264c9bdce361   2 years ago      326MB

      ```
     -  After creation image you can exec Container dinamically with random name 
        on specific PORT on hostname "localhost". Execute that command at root level project.
   
        ``` 
          docker run -p 8181:8181 -t docker-image:my-tag
        ```

# CREATE CONTAINER
[Docker Container CLI](https://docs.docker.com/reference/cli/docker/container/) 

1. Command create a Container for current Image Docker with specific name and IP with PORT. Execute at root level project.

      ``` 
        docker container create --name your_name_container -p 192.168.1.189:8181:8181 -it docker-image:my-tag
      ```   
   
   - After creation container execute it with : 
   
     ``` 
      docker start your_name_container
     ```


# RUN CONTAINER

1. This command is COMPLETE because it dynamically creates a Container with Name, IP 
and a specific Port for both the APP and the Container, and runs the container with 
the current Docker image [docker-image:my-tag]. Execute at root level project.

    > docker run -p [ip host]:[port app]:[port container] --name your_name_container [image-name]:[tag-name]

      ``` 
       docker run -p 192.168.1.187:8181:8181 --name your_name_container docker-image:my-tag
      ``` 