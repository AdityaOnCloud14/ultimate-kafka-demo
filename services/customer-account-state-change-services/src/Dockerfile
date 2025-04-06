FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/customer-account-state-change-services.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]