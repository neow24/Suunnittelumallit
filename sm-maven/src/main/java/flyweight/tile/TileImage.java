package flyweight.tile;

import javafx.scene.image.Image;

public class TileImage {
    private final Image image;

    public TileImage(String imagePath) {
        this.image = new Image(imagePath);
    }

    public Image getImage() {
        return image;
    }
}
