package state;

public class IntermediateState implements State {
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " trained and gained 30 experience.");
        character.addExp(1);
    }
    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " meditated and restored 20 HP.");
        character.addHp(20);
    }
    @Override
    public void fight(Character character) {
        System.out.println("Fighting is not available at Intermediate level.");
    }
    public String getLevelName() { return "Intermediate"; }
}
