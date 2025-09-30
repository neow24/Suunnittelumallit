package flyweight.map;

import flyweight.tile.BuildingTile;
import flyweight.tile.RoadTile;
import flyweight.tile.Tile;

public class CityMap extends Map {
    private java.util.Random r = new java.util.Random();

    public Tile createTile() {
        if (r.nextBoolean()) return new RoadTile();
        else return new BuildingTile();
    }
}
