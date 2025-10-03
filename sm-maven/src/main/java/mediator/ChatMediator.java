package mediator;

import java.util.Map;
import java.util.HashMap;

public class ChatMediator implements Mediator {
    private Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String msg, String sender, String receiver) {
        ChatClientController recipient = clients.get(receiver);

        if (recipient != null) {
            recipient.receiveMessage(sender, msg);
            if (clients.get(sender) != null)
                clients.get(sender).showSentMessage(sender, msg);
        } else
            if (clients.get(sender) != null)
                clients.get(sender).receiveMessage(
                    "System", "User '" + receiver + "' not found."
                );
    }

    public void updateRecipientsLists() {
        for (ChatClientController c : clients.values())
            c.updateRecipientsList(clients.keySet());
    }
}
