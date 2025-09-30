package flyweight.factory;

import java.util.HashMap;
import java.util.Map;

import flyweight.tile.TileImage;

public class TileGraphicFactory {
    
    private static final Map<Character, TileImage> images = new HashMap<>();
    
    private TileGraphicFactory() {}

    // public static TileImage getImage(char type) {
    //     if (images.containsKey(type)) return images.get(type);
    //     javafx.scene.image.Image image = createImage(type);
    //     images.put(type, image);
    //     return image;
    // }
    
    @SuppressWarnings("unused")
    private static TileImage getTileImage(char type) {
        TileImage image = images.get(type);
        if (image == null)
            return switch (type) {
                case 'B' -> new TileImage("medieval_building_tiles.png");
                case 'F' -> new TileImage("forest_tiles.png");
                case 'R' -> new TileImage("road.svg");
                case 'S' -> new TileImage("sunsetintheswamp.png");
                case 'W' -> new TileImage("tex_Water.jpg");
                default  -> throw new IllegalArgumentException(
                    "Unknown tile type: " + type);
            };
        return image;
    }
}
