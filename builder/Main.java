package builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder = new GamingComputerBuilder();
        Director director = new Director(builder);
        director.constructComputer();
        Computer gamingComputer = builder.getComputer();
        System.out.println(gamingComputer);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        Director officeDirector = new Director(officeBuilder);
        officeDirector.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println(officeComputer);
    }
}
