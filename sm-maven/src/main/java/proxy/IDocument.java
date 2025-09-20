package proxy;

public interface IDocument {
    int getId();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
