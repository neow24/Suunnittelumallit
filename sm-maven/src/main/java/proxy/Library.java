package proxy;

import java.util.HashMap;

public class Library {
    // holds a HashMap<documentId, IDocument>
    // Stores both unprotected(real documents) and protected(proxies)
    // Provides:
        // A method to add unprotected documents directly.
        // A factory method to add protected documents:
        // Create a real document.
        // Wrap it in a proxy.
        // Store only the proxy in the library.
    private HashMap<Integer, IDocument> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(int id, String creationDate, String content) {
        documents.put(id, new Document(id, creationDate, content));
    }

    public void addProtectedDocument(int id, String creationDate, String content) {
        documents.put(id, new DocumentProxy(id, creationDate, content));
    }

    public IDocument getDocument(String docId) {
        int id = Integer.parseInt(docId.replace("doc", ""));
        return documents.get(id);
    }
}
