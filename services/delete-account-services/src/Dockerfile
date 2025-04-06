FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/delete-account-services.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]