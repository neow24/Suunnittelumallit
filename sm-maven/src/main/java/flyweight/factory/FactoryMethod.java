package flyweight.factory;

import flyweight.map.CityMap;
import flyweight.map.Map;
import flyweight.map.WildernessMap;

public class FactoryMethod {
    public Map createMap(String type) {
        if (type.equalsIgnoreCase("c"))
            return new CityMap();
        else if (type.equalsIgnoreCase("w"))
            return new WildernessMap();
        else
            throw new IllegalArgumentException("Unknown map type");
    }

    public void mainMeu() {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println();
        System.out.println("Choose map (c / w): ");
        String choice = s.nextLine();

        Map gameMap = createMap(choice);
        gameMap.create(5);

        s.close();
    }
}
