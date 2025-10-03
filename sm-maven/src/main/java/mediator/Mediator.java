package mediator;

public interface Mediator {
    void registerClient(ChatClientController client);
    void sendMessage(String message, String sender, String receiver);
}
