# Docker-Compose to PlantUML

## Goal

Generate a plantuml file that describe docker services and their dependencies, based on a given `docker-compose.yaml` file.

## Output

The result is written in stdout, with the following pattern :

```plantuml
@startuml

package <-Dpackage=value> {
    component1

    component2 --> component3
    component2 --> component4

    ...
}

@enduml
```

## Prerequisites

- JDK 1.8
- Maven

## Build it

```sh
# Write it as is when you are at the root of the project directory
mvn clean compile assembly:single
```

## Run it

```sh
# Write it as is when you are at the root of the project directory
java -Dpackage=<your_package> -Dfile="path/to/docker-compose.yaml" -jar target/dockerToPlant.jar
```

## Using Docker

```sh
ls /path/to/your/directory
# docker-compose.yml
docker run --volume /path/to/your/directory:/input maxime-bus/docker-compose-to-plant-uml
```

## Self Demo

```sh
# generate diagram
docker-compose up -d generator
# stop plantuml server and remove all containes
docker-compose down
# print generated PlantUML
cat /tmp/diagram.plantuml
# display generated image in your browser
eval $BROWSER /tmp/diagram.svg
```
