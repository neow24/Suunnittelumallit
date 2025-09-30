package flyweight.factory;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import flyweight.map.Map;
// import flyweight.map.CityMap;
// import flyweight.map.WildernessMap;

@SuppressWarnings("unused")
public class MapView extends Application {
    private final int TILE_SIZE = 50;
    private Canvas canvas = new Canvas(5, 5);
    private GraphicsContext gc = canvas.getGraphicsContext2D();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flyweight Map");

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // drawTiles();
    }

    // private void drawTiles() {
    //     gc.clearRect(0, 0, 5, 5);
    //     for (int i = 0; i < 5; i++)
    //         for (int j = 0; j < 5; j++) {
    //             javafx.scene.image.Image imageToDraw = TileGraphicFactory.getTileImage(Map.getTile(i, j));
    //             gc.drawImage(imageToDraw, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    //         }
    // }

    public static void main(String[] args) { launch(args); }
}
