package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.UserData;

public class Gui extends Application {
    
    private UserData userData = new UserData();

    @Override
    public void start(Stage primaryStage) {
        openWindow("Window 1");
        openWindow("Window 2");
        openWindow("Window 3");
    }

    private void openWindow(String windowName) {
        Stage stage = new Stage();
        stage.setTitle(windowName);

        CheckBox checkBox = new CheckBox("Toggle me");

        checkBox.setOnAction(event -> {
            System.out.println(windowName + " - Checkbox state: " + checkBox.isSelected());
            userData.setSelected(checkBox.isSelected());
        });

        VBox root = new VBox(checkBox);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.show();
    }
}
