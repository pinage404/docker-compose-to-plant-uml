# Goal

Generate a plantuml file that describe docker services and their dependencies, based on a given `docker-compose.yaml` file.

# Output

The result is written in stdout, with the following pattern :

    @startuml
    
    package <-Dpackage=value> {
        component1
        
        component2 --> component3
        component2 --> component4
        
        ...
    }
    
    @enduml

# Prerequisites

- JDK 1.8
- Maven

# Build it

```bash
    # Write it as is when you are at the root of the project directory
    mvn clean compile assembly:single
``` 
     
# Run it

```bash
    # Write it as is when you are at the root of the project directory
    java -Dpackage=<your_package> -Dfile="path/to/docker-compose.yaml" -jar target/dockerToPlant.jar
``` 