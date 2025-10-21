package creational;

interface Button{
    void onClick();
}

class WindowsButton implements Button{
    public void onClick(){
        System.out.println("Windows Button Clicked!");
    }
}

class MacButton implements Button{
    public void onClick(){
        System.out.println("Mac Button Clicked!");
    }
}

abstract class Dialog{
    abstract Button createButton();
}

class WindowsDialog extends Dialog{
    Button createButton(){
        return new WindowsButton();
    }
}

class MacDialog extends Dialog{
    Button createButton(){
        return new MacButton();
    }
}

class FactoryMethod{
    public static void main(String[] args) {
        Button btn;
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")){
            Dialog macDialog = new MacDialog();
        }else{
            Dialog windowsDialog = new WindowsDialog();
        }
    }
}