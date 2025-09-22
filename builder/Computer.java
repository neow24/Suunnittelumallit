package builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Component> components = new ArrayList<>();

    public Computer() {
        this.components = new ArrayList<>();
    }
    
    public void addComponent(Component component) {
        this.components.add(component);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components)
            sb.append(component.getName()).append("\n");
        return sb.toString();
    }
}
