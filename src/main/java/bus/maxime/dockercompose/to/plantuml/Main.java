package bus.maxime.dockercompose.to.plantuml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(constructPlantUmlPackage(parseDockerComposeFile()).toString());
    }

    private static PlantUmlPackage constructPlantUmlPackage(DockerCompose dockerCompose) {
        PlantUmlPackage plantUmlPackage = new PlantUmlPackage(System.getProperty("package"));

        for (String serviceName : dockerCompose.getServices().keySet()) {

            DockerComposeService dockerComposeService = dockerCompose.getServices().get(serviceName);

            PlantUmlComponent component = new PlantUmlComponent(serviceName);

            List<String> dependencies = dockerComposeService.getDependencies();

            if (dependencies != null) {
                for (String dependency : dependencies) {
                    component.dependsOn(new PlantUmlComponent(dependency));
                }
            }

            plantUmlPackage.addComponent(component);
        }
        return plantUmlPackage;
    }

    private static DockerCompose parseDockerComposeFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        return objectMapper.readValue(new File(System.getProperty("file")), DockerCompose.class);
    }
}
