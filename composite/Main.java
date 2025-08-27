package composite;

public class Main {
    public static void main(String[] args) {

        Department headOffice = new Department("Head Office");

        Department hrDepartment = new Department("HR Department");
        hrDepartment.add(new Employee("Diana", 75000));
        hrDepartment.add(new Employee("Ethan", 72000));

        Department itDepartment = new Department("IT Department");
        itDepartment.add(new Employee("Alice", 70000));
        itDepartment.add(new Employee("Bob", 80000));

        headOffice.add(hrDepartment);
        headOffice.add(itDepartment);
        headOffice.add(new Employee("Charlie", 60000));

        System.out.println("Total Salary of Organization: " + headOffice.getSalary());

        System.out.println("\nOrganization Structure");
        System.out.println(headOffice.toXML(""));
    }
}
