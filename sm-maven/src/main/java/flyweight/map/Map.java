package flyweight.map;

import flyweight.tile.Tile;

public abstract class Map {
    private static Tile[][] tiles;

    public abstract Tile createTile();

    public void create(int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                tiles[i][j] = createTile();
    }

    public static char getTile(int i, int j) {
        return tiles[i][j].getCharacter();
    }
}
