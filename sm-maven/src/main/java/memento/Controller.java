package memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class Controller {
    private Model model;
    private Gui gui;
    private Deque<IMemento> historyStack;
    private Deque<IMemento> futureStack;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.historyStack = new ArrayDeque<>();
        this.futureStack = new ArrayDeque<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory(true);
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory(true);
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!historyStack.isEmpty()) {
            System.out.println("Memento found in history");
            saveToFuture();
            // IMemento previousState = historyStack.pop();
            model.restoreState(historyStack.pop());
            gui.updateGui();
        }
    }

    public void redo() {
        if (!futureStack.isEmpty()) {
            System.out.println("Memento found in future");
            saveToHistory(false);
            // IMemento nextState = futureStack.pop();
            model.restoreState(futureStack.pop());
            gui.updateGui();
        }
    }

    private void saveToHistory(boolean clearFuture) {
        IMemento currentState = model.createMemento();
        historyStack.push(currentState);
        if (clearFuture) futureStack.clear();
    }

    private void saveToFuture() {
        IMemento currentState = model.createMemento();
        futureStack.push(currentState);
    }
}
