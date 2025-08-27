package composite;
import java.util.*;

public class Department implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();
    public Department(String name) { this.name = name; }
    @Override public String getName() { return this.name; }
    @Override public double getSalary() {
        double total = 0;
        for (Component c : this.children) { total += c.getSalary(); }
        return total;
    }
    @Override public void add(Component c) { this.children.add(c); }
    @Override public void remove(Component c) { this.children.remove(c); }
    @Override public String toXML(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
            "%s<department name=\"%s\" totalSalary=\"%.2f\">%n",
            indent, this.name, this.getSalary()
        ));
        for (Component c : this.children) { sb.append(c.toXML(indent + "  ")); }
        sb.append(String.format("%s</department>%n", indent));
        return sb.toString();
    }
}
