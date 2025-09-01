package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Singleton {

    private static Singleton instance;
    private BufferedWriter writer;
    private String fileName;

    private Singleton() {
        this.fileName = "singleton/singleton_log.txt";
        openFile(this.fileName);
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }

    private void closeFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
        }
    }

    public synchronized void setFileName(String newFileName) {
        closeFile();
        this.fileName = newFileName;
        openFile(this.fileName);
    }

    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public synchronized void close() {
        closeFile();
    }

    public static void main(String[] args) {
        Singleton logger = Singleton.getInstance();
        logger.setFileName("singleton/new_log.txt");
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close();
    }
}
