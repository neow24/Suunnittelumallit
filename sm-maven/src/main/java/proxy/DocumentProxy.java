package proxy;

public class DocumentProxy implements IDocument {
    int    id;
    String creationDate;
    String content;
    private Document document;
    
    public DocumentProxy(int id, String creationDate, String content) {
        this.id           =           id;
        this.creationDate = creationDate;
        this.content      =      content;
    }

    @Override public int getId() { return id; }

    @Override public String getCreationDate() { return creationDate; }

    @Override public String getContent(User user) throws AccessDeniedException {
        AccessControlService access = AccessControlService.getInstance();
        if (!access.isAllowed(id, user.getUsername()))
            throw new AccessDeniedException();
        if (document == null)
            document = new Document(id, creationDate, content);
        return content;
    }
}
