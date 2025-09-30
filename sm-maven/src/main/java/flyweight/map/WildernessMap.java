package flyweight.map;

import flyweight.tile.ForestTile;
import flyweight.tile.SwampTile;
import flyweight.tile.Tile;
import flyweight.tile.WaterTile;

public class WildernessMap extends Map {
    private java.util.Random r = new java.util.Random();

    public Tile createTile() {
        switch (r.nextInt(3)) {
            case 0: return new ForestTile();
            case 1:  return new SwampTile();
            default: return new WaterTile();
        }
    }
}
