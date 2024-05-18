FROM maven:3.6.3-jdk-11 AS build

LABEL org.opencontainers.image.source="https://github.com/vmfx/lab4"

COPY . /app
WORKDIR /app

COPY pom.xml .

RUN mvn clean package

FROM openjdk:11-jre-slim

COPY --from=build /app/target/*.jar /app.jar

CMD ["java", "-jar", "/app.jar"]

