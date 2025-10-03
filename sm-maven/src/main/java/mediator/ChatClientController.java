package mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChatClientController {
    private String username;
    private ChatMediator mediator;

    private TextArea chatArea;
    private TextField inputField;
    private ComboBox<String> recipientBox;
    private Button sendButton;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void receiveMessage(String sender, String msg) {
        chatArea.appendText(sender + " -> " + username + ": " + msg + "\n");
    }

    public void showSentMessage(String receiver, String msg) {
        chatArea.appendText(username + " -> " + receiver + ": " + msg + "\n");
    }

    public void sendMessage() {
        String msg = inputField.getText();
        String recipient = recipientBox.getValue();

        if (!msg.isEmpty() && recipient != null) {
            mediator.sendMessage(msg, username, recipient);
            inputField.clear();
        }
    }

    public void showWindow() {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);

        chatArea = new TextArea();
        chatArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("Message");

        recipientBox = new ComboBox<>();
        recipientBox.setPromptText("Recipient");

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        HBox bottomPanel = new HBox(
            10, inputField, recipientBox, sendButton);
        bottomPanel.setPadding(new Insets(5));

        BorderPane root = new BorderPane();
        root.setCenter(chatArea);
        root.setBottom(bottomPanel);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public void updateRecipientsList(Iterable<String> usernames) {
        recipientBox.getItems().clear();
        for (String user : usernames)
            if (!user.equals(username))
                recipientBox.getItems().add(user);
    }
}
