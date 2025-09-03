package decorator;

public abstract class PrinterDecorator implements Printer {
    protected Printer wrappedPrinter;

    public PrinterDecorator(Printer wrappedPrinter) {
        this.wrappedPrinter = wrappedPrinter;
    }

    @Override
    public abstract void print(String message);
}
