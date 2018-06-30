FROM maven:3.5.4-jdk-8-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src src

RUN mvn clean compile assembly:single



FROM openjdk:8-jdk-slim

VOLUME [ "/input" ]
ENV DOCKER_COMPOSE_FILE_PATH "/input/docker-compose.yml"

WORKDIR /app
COPY --from=build /app/target/dockerToPlant.jar .

ENTRYPOINT java -Dpackage=your_package -Dfile=${DOCKER_COMPOSE_FILE_PATH} -jar ./dockerToPlant.jar
