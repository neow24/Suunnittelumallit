package state;

public interface State {
    void train(Character character);
    void meditate(Character character);
    void fight(Character character);
    String getLevelName();
}
