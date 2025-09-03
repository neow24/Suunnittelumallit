package decorator;

public class EncryptedPrinter extends PrinterDecorator {
    public EncryptedPrinter(Printer wrappedPrinter) {
        super(wrappedPrinter);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        wrappedPrinter.print(encryptedMessage);
    }

    private String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((char) (c+4));
        }
        return sb.toString();
    }
}
