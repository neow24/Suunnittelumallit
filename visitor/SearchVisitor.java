package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String criterion;
    private List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String criterion) {
        this.criterion = criterion;
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(criterion)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (File file : directory.getFiles()) file.accept(this);
        for (Directory dir : directory.getSubdirectories()) dir.accept(this);
    }
}
