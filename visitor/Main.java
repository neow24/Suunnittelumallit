package visitor;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.log", 200);
        Directory subDir = new Directory("subdir");
        File file3 = new File("file3.txt", 300);

        subDir.addFile(file3);
        root.addFile(file1);
        root.addFile(file2);
        root.addSubdirectory(subDir);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize());

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Matching .txt files:");
        for (File f : searchVisitor.getMatchingFiles())
            System.out.println(f.getName());
    }
}
