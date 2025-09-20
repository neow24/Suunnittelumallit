package proxy;

public class Document implements IDocument {
    int    id;
    String creationDate;
    String content;
    

    public Document     (int id, String creationDate, String content) {
        this.id           =           id;
        this.creationDate = creationDate;
        this.content      =      content;
    }

    @Override public int getId() { return id; }

    @Override public String getCreationDate() { return creationDate; }

    @Override public String getContent(User user) {
        
        
        
        

        return content;
    }
}
