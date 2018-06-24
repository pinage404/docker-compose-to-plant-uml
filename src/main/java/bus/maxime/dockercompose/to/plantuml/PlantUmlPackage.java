package bus.maxime.dockercompose.to.plantuml;

import java.util.ArrayList;
import java.util.List;

public class PlantUmlPackage {
    private String name;
    private List<PlantUmlComponent> components = new ArrayList<PlantUmlComponent>();

    public PlantUmlPackage(String name) {
        this.name = name;
    }

    public void addComponent(PlantUmlComponent component) {
        components.add(component);
    }

    @Override
    public String toString() {
        StringBuilder plantUmlResult = new StringBuilder()
                .append("@startuml\n")
                .append("package ")
                .append(this.name)
                .append(" {\n");

        for (PlantUmlComponent component : components) {
            plantUmlResult = plantUmlResult.append(component.toString()).append("\n");
        }

        return plantUmlResult.append("}\n").append("@enduml").toString();
    }
}
