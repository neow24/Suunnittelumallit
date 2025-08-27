package composite;

public class Employee implements Component {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name   =   name;
        this.salary = salary;
    }

    @Override public String getName()   { return this.name   ; }
    @Override public double getSalary() { return this.salary ; }
    @Override public void add(Component c) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }
    @Override public void remove(Component c) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }
    @Override public String toXML(String indent) {
        return String.format("%s<employee name=\"%s\" salary=\"%.2f\"/>%n", indent, this.name, this.salary);
    }
}
