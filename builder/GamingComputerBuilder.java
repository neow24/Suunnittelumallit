package builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("High-end Processor"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("16GB RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("1TB SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("High-end Graphics Card"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 10"));
    }

    public Computer getComputer() { return computer; }
}
