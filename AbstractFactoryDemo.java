public class AbstractFactoryDemo {
    public static void main(String[] args) {

        UIFactory factory = new LightFactory();

        Screen screen = new Screen(factory);
        screen.render();
    }
}

interface Button { void render(); }
interface Checkbox { void render(); }

class LightButton implements Button { public void render() { System.out.println("LightButton"); } }
class DarkButton  implements Button { public void render() { System.out.println("DarkButton"); } }

class LightCheckbox implements Checkbox { public void render() { System.out.println("LightCheckbox"); } }
class DarkCheckbox  implements Checkbox { public void render() { System.out.println("DarkCheckbox"); } }

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class LightFactory implements UIFactory {
    public Button createButton()   { return new LightButton(); }
    public Checkbox createCheckbox(){ return new LightCheckbox(); }
}

class DarkFactory implements UIFactory {
    public Button createButton()   { return new DarkButton(); }
    public Checkbox createCheckbox(){ return new DarkCheckbox(); }
}
class Screen {
    private final Button btn;
    private final Checkbox chk;

    Screen(UIFactory f) {
        this.btn = f.createButton();
        this.chk = f.createCheckbox();
    }
    void render() {
        btn.render();
        chk.render();
    }
}
