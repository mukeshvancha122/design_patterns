package creational;

interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsButton implements Button {
    public void paint() {
        System.out.println("Windows Button");
    }
}

class MacOSButton implements Button {
    public void paint() {
        System.out.println("Mac Button");
    }
}

class MacCheckBox implements Checkbox {
    public void paint() {
        System.out.println("Mac CheckBox");
    }
}

class WindowsCheckBox implements Checkbox {
    public void paint() {
        System.out.println("Windows CheckBox");
    }
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckBox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckBox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.paint();
        checkbox.paint();
    }
}
