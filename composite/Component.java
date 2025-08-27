package composite;

public interface Component {
    String getName();
    double getSalary();
    void add(Component c);
    void remove(Component c);
    String toXML(String indent);
}
