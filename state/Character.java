package state;

import java.util.Scanner;

public class Character {
    private String  name;
    private int      exp;
    private int       hp;
    private State  state;

    public static final int NOVICE_THRESHOLD       =  5;
    public static final int INTERMEDIATE_THRESHOLD = 10;
    public static final int EXPERT_THRESHOLD       = 15;

    public Character(String name) {
        this.name  = name;
        this.exp   = 0;
        this.hp    = 100;
        this.state = new NoviceState();
    }

    public void operate(Scanner s) {
        while (!(state instanceof MasterState)) {
            printStatus();

            System.out.println("Choose action: ");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");

            switch (s.nextInt()) {
                case 1  -> train();
                case 2  -> meditate();
                case 3  -> fight();
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public void train()    { state.train(this);    checkLevelUp(); }
    public void meditate() { state.meditate(this); checkLevelUp(); }
    public void fight()    { state.fight(this);    checkLevelUp(); }

    private void checkLevelUp() {
        if (exp >= EXPERT_THRESHOLD && !(state instanceof MasterState)) {
            setState(new MasterState());
            System.out.println(name + " has reached master level! Game Over.");
        } else if (exp >= INTERMEDIATE_THRESHOLD && !(state instanceof ExpertState || state instanceof MasterState)) {
            setState(new ExpertState());
            System.out.println(name + " advanced to expert level!");
        } else if (exp >= NOVICE_THRESHOLD && state instanceof NoviceState) {
            setState(new IntermediateState());
            System.out.println(name + " advanced to intermediate level!");
        }
    }

    public void setState(State newState) { this.state = newState; }
    public State  getState() { return state; }
    public String getName()  { return  name; }
    public int    getExp()   { return   exp; }
    public int    getHp()    { return    hp; }
    public void addExp(int amount) { this.exp += amount; }
    public void addHp(int amount) {
        this.hp = Math.min(100, this.hp + amount);
    }
    public void reduceHp(int amount) {
        this.hp = Math.max(0, this.hp - amount);
    }

    public void printStatus() {
        System.out.println("Character staus:");
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("Experience: " + exp);
        System.out.println("HP: " + hp + "\n");
    }
}
