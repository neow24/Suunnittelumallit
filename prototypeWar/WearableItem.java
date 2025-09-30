package prototypeWar;

public class WearableItem extends Item {
    public WearableItem(String name) {
        super(name);
    }

    @Override
    public WearableItem clone() {
        return (WearableItem) super.clone();
    }
}
