package prototypeWar;

import java.util.ArrayList;

public class Soldier implements Cloneable {
    private java.util.List<Item> items;

    public Soldier() { this.items = new ArrayList<>(); }

    public void addItem(Item item) { items.add(item); }

    @Override
    public Soldier clone() {
        try {
            Soldier clonedSoldier = (Soldier) super.clone();
            clonedSoldier.items = new ArrayList<>();
            for (Item item : this.items) clonedSoldier.addItem(item.clone());
            return clonedSoldier;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    @Override
    public String toString() {
        return "Soldier with items: " + items;
    }
}
