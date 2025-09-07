package state;

public class NoviceState implements State {
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " trained and gained 20 experience.");
        character.addExp(1);
    }
    @Override
    public void meditate(Character character) {
        System.out.println("Meditation is not available at Novice level.");
    }
    @Override
    public void fight(Character character) {
        System.out.println("Fighting is not available at Novice level.");
    }
    public String getLevelName() { return "Novice"; }
}
