package proxy;

public class Main {
    public static void main(String[] args) {
        // Create users
        User alice   = new User("alice");
        User bob     = new User("bob");
        User charlie = new User("charlie");

        // Create a library
        Library library = new Library();

        // Add an unprotected document
        library.addDocument(1, "2025-09-20", "This is an open document.");

        // Add a protected document
        library.addProtectedDocument(2, "2025-09-20", "This is a secret document.");

        // Configure AccessControlService
        AccessControlService access = AccessControlService.getInstance();
        access.allowAccess(2, "alice");  // Alice can read doc2
        // Bob is not allowed for doc2
        access.allowAccess(2, "charlie"); // Charlie can also read doc2

        // Try accessing documents
        System.out.println("=== Document Access Attempts ===");

        try {
            System.out.println("Alice reads doc1: " + library.getDocument("doc1").getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Alice denied access to doc1.");
        }

        try {
            System.out.println("Bob reads doc2: " + library.getDocument("doc2").getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println("Bob denied access to doc2.");
        }

        try {
            System.out.println("Alice reads doc2: " + library.getDocument("doc2").getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Alice denied access to doc2.");
        }

        try {
            System.out.println("Charlie reads doc2: " + library.getDocument("doc2").getContent(charlie));
        } catch (AccessDeniedException e) {
            System.out.println("Charlie denied access to doc2.");
        }
    }
}
