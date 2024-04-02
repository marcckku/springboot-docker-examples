FROM openjdk:17

EXPOSE 8181

ADD target/*.jar docker-composer-springboot.jar

ENTRYPOINT ["java", "-jar", "/docker-composer-springboot.jar"]
