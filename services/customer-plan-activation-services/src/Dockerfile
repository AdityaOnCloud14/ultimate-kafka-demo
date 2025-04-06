FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/customer-plan-activation-services.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]