package prototype;

import java.util.*;

public class Main {
    private static final Scanner s = new Scanner(System.in);
    private static final List<Recommendation> recs = new ArrayList<>();
    
    public static void main(String[] args) {
        Recommendation r = new Recommendation("Teens");
        r.addBook(new Book("Lorem", "Ipsum"));
        recs.add(r);

        while (true) {
            System.out.println("\n1.View 2.Clone 3.Modify 4.New 5.Exit");
            switch (s.nextInt()) {
                case 1 -> view();
                case 2 -> cloneRec();
                case 3 -> modify();
                case 4 -> recs.add(new Recommendation(line("Audience:")));
                case 5 -> { return; }
            }
        }
    }

    private static void view() {
        for (int i = 0; i < recs.size(); i++)
            System.out.println("[" + i + "] " + recs.get(i));
    }

    private static int chooseRecommendation() {
        view();
        if (recs.isEmpty()) return -1;
        System.out.print("Enter index of recommendation: ");
        int index = s.nextInt();
        if (index < 0 || index >= recs.size()) {
            System.out.println("Invalid index");
            return -1;
        }
        return index;
    }

    private static void cloneRec() {
        int index = chooseRecommendation();
        if (index == -1) return;
        Recommendation c = recs.get(index).clone();
        c.setTargetAudience(line("New audience:"));
        recs.add(c);
    }

    private static void modify() {
        int index = chooseRecommendation();
        if (index == -1) return;

        Recommendation r = recs.get(index);
        while (true) {
            System.out.println("\nEditing Recommendation for: " + r.getTargetAudience());
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Change target audience");
            System.out.println("4. Done");

            switch (s.nextInt()) {
                case 1 -> addBookTo(r);
                case 2 -> {
                    System.out.print("Enter index of book to remove: ");    
                    r.removeBook(s.nextInt());
                }
                case 3 -> r.setTargetAudience(line("Enter new audience: "));
                case 4 -> { return; }
            }
        }
    }

    private static void addBookTo(Recommendation r) {
        String title = line("Enter title: ");
        String author = line("Enter author: ");
        r.addBook(new Book(title, author));
    }

    private static String line(String msg) {
        System.out.println(msg);
        return s.next();
    }
}
