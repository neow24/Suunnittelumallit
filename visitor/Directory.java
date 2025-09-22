package visitor;

public class Directory implements FileSystemElement {
    private String name;
    private File[] files;
    private Directory[] subdirectories;

    public Directory(String name) {
        this.name = name;
        this.files = new File[0];
        this.subdirectories = new Directory[0];
    }
    
    public String getName() { return name; }

    public File[] getFiles() { return files; }

    public Directory[] getSubdirectories() { return subdirectories; }
    
    public void addFile(File file) {
        File[] newFiles = new File[files.length + 1];
        System.arraycopy(files, 0, newFiles, 0, files.length);
        newFiles[files.length] = file;
        files = newFiles;
    }

    public void addSubdirectory(Directory dir) {
        Directory[] newDirs = new Directory[subdirectories.length + 1];
        System.arraycopy(subdirectories, 0, newDirs, 0, subdirectories.length);
        newDirs[subdirectories.length] = dir;
        subdirectories = newDirs;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
