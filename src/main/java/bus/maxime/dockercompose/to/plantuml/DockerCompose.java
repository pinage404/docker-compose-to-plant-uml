package bus.maxime.dockercompose.to.plantuml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DockerCompose {
    Map<String, DockerComposeService> services;

    public Map<String, DockerComposeService> getServices() {
        return services;
    }

    public void setServices(Map<String, DockerComposeService> services) {
        this.services = services;
    }
}
