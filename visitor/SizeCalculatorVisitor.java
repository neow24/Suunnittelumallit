package visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    public int getTotalSize() { return totalSize; }

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (File file : directory.getFiles()) file.accept(this);
        for (Directory dir : directory.getSubdirectories()) dir.accept(this);
    }
}
