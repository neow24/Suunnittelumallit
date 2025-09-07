package state;

public class ExpertState implements State {
    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " trained and gained 40 experience.");
        character.addExp(1);
    }
    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " meditated and restored 30 HP.");
        character.addHp(30);
    }
    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " fought and lost 20 HP but gained 50 experience.");
        character.reduceHp(40);
        character.addExp(2);
    }
    public String getLevelName() { return "Expert"; }
    
}
