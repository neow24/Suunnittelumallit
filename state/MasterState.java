package state;

public class MasterState implements State {
    @Override
    public void train(Character character) {
        System.out.println("Already a Master. No further training needed.");
    }
    @Override
    public void meditate(Character character) {
        System.out.println("Already a Master. No further meditation needed.");
    }
    @Override
    public void fight(Character character) {
        System.out.println("Already a Master. No further fighting needed.");
    }
    public String getLevelName() { return "Master"; }
}
