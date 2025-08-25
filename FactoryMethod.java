import java.util.Random;
import java.util.Scanner;

// Abstract Product

abstract class Tile {
    public abstract char   getCharacter();
    public abstract String getType     ();
}

abstract class Map {
    public abstract Tile createTile();

    public void display(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(createTile().getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

// Concrete Creators

class SwampTile    extends Tile {
    public char   getCharacter() { return 'S'        ; }
    public String getType()      { return "swamp."   ; }
}

class WaterTile    extends Tile {
    public char   getCharacter() { return 'W'        ; }
    public String getType()      { return "water."   ; }
}

class RoadTile     extends Tile {
    public char   getCharacter() { return 'R'        ; }
    public String getType()      { return "road."    ; }
}

class ForestTile   extends Tile {
    public char   getCharacter() { return 'F'        ; }
    public String getType()      { return "forest."  ; }
}

class BuildingTile extends Tile {
    public char   getCharacter() { return 'B'        ; }
    public String getType()      { return "building."; }
}

class CityMap extends Map {
    private Random r = new Random();

    public Tile createTile() {
        if (r.nextBoolean()) {
            return new RoadTile();
        } else {
            return new BuildingTile();
        }
    }
}

class WildernessMap extends Map {
    private Random r = new Random();

    public Tile createTile() {
        int choice = r.nextInt(3);
        switch (choice) {
            case  0: return new ForestTile();
            case  1: return new SwampTile();
            default: return new WaterTile();
        }
    }
}

public class FactoryMethod {
    public Map createMap(String type) {
        if (type.equalsIgnoreCase("city")) {
            return new CityMap();
        } else if (type.equalsIgnoreCase("wilderness")) {
            return new WildernessMap();
        } else {
            throw new IllegalArgumentException("Unknown map type");
        }
    }

    public void mainMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("");
        System.out.println("Choose map (city / wilderness): ");
        String choice = s.nextLine();

        Map gameMap = createMap(choice);
        System.out.println("");
        gameMap.display(5);

        s.close();
    }
    public static void main(String[] args) {
        new FactoryMethod().mainMenu();
    }
    
}
