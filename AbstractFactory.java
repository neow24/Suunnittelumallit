abstract class Button    { public abstract void display(); }
abstract class TextField { public abstract void display(); }
abstract class Checkbox  { public abstract void display(); }
abstract class UIFactory {
    public abstract Button    createButton   (String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox  createCheckbox (String text);
}

class ButtonA    extends Button    {
    private String text;

    public ButtonA(String text) { this.text = text; }

    @Override
    public void display() {
        System.out.println("Displaying Button A");
    }
}

class TextFieldA extends TextField {
    private String text;

    public TextFieldA(String text) { this.text = text; }

    @Override
    public void display() {
        System.out.println("Displaying TextField A");
    }
}

class CheckboxA  extends Checkbox  {
    private String text;

    public CheckboxA(String text) { this.text = text; }
    
    @Override
    public void display() {
        System.out.println("Displaying Checkbox A");
    }
}

class UIFactoryA extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}

class ButtonB    extends Button    {
    private String text;

    public ButtonB(String text) { this.text = text; }

    @Override
    public void display() {
        System.out.println("Displaying Button B");
    }
}

class TextFieldB extends TextField {
    private String text;

    public TextFieldB(String text) { this.text = text; }

    @Override
    public void display() {
        System.out.println("Displaying TextField B");
    }
}

class CheckboxB  extends Checkbox  {
    private String text;

    public CheckboxB(String text) { this.text = text; }

    @Override
    public void display() {
        System.out.println("Displaying Checkbox B");
    }
}

class UIFactoryB extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        UIFactory factoryA = new UIFactoryA();
        Button    bA = factoryA.createButton   ("Submit");
        TextField tA = factoryA.createTextField("Enter Name");
        Checkbox  cA = factoryA.createCheckbox ("Accept Terms");

        System.out.println("UI A");
        bA.display();
        tA.display();
        cA.display();

        UIFactory factoryB = new UIFactoryB();
        Button    bB = factoryB.createButton   ("Submit");
        TextField tB = factoryB.createTextField("Enter Name");
        Checkbox  cB = factoryB.createCheckbox ("Accept Terms");

        System.out.println("\nUI B");
        bB.display();
        tB.display();
        cB.display();

    }
}
