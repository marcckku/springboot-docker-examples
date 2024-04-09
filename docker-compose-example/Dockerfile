# SIMPLE BASE JAVA EXEC
FROM openjdk:17-alpine
EXPOSE 8181
ADD target/*.jar springboot-app.jar
ENTRYPOINT ["java","-jar","/springboot-app.jar"]