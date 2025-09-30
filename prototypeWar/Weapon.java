package prototypeWar;

public class Weapon extends Item {
    private static int idCounter = 0;
    private int id;

    public Weapon(String name) {
        super(name);
        this.id = ++idCounter;
    }

    @Override
    public Weapon clone() {
        Weapon cloned = (Weapon) super.clone();
        cloned.id = ++idCounter;
        return cloned;
    }

    @Override
    public String toString() {
        return super.toString() + " with ID " + id;
    }
}
