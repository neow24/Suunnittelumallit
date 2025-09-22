package builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Mid-range Processor"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("8GB RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("512GB SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("Integrated Graphics"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 10"));
    }

    public Computer getComputer() { return computer; }
}
