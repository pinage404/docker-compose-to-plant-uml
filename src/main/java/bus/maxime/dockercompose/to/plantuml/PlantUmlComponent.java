package bus.maxime.dockercompose.to.plantuml;

import java.util.ArrayList;
import java.util.List;

public class PlantUmlComponent {
    private String name;
    private List<PlantUmlComponent> dependencies = new ArrayList<PlantUmlComponent>();

    public PlantUmlComponent(String name) {
        this.name = name;
    }

    public void dependsOn(PlantUmlComponent component) {
        this.dependencies.add(component);
    }

    public boolean hasDependencies() {
        return this.dependencies.size() > 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (this.hasDependencies()) {
            for (PlantUmlComponent dependency : dependencies) {
                stringBuilder = stringBuilder
                        .append("    ")
                        .append(this.wrapWithSquareBracket(this.name))
                        .append(" --> ")
                        .append(this.wrapWithSquareBracket(dependency.name))
                        .append("\n");
            }
        } else {
            stringBuilder = stringBuilder.append("    ").append(this.wrapWithSquareBracket(this.name));
        }

        return stringBuilder.toString();
    }

    private String wrapWithSquareBracket(String s) {
        return "[" + s + "]";
    }
}
