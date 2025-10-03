package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatMediator chatMediator = new ChatMediator();
        
        ChatClientController c1 = new ChatClientController(
            "Lorem", chatMediator);
        ChatClientController c2 = new ChatClientController(
            "Ipsum", chatMediator);
        ChatClientController c3 = new ChatClientController(
            "Dolor", chatMediator);
        
        c1.showWindow();
        c2.showWindow();
        c3.showWindow();

        chatMediator.updateRecipientsLists();
    }
}
