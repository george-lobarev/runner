package Game.initialization;


import Game.states.StateManager;

public class MainWindow {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    public static void main(String[] args) {
        WindowCreate window = new WindowCreate("Main window", WIDTH, HEIGHT);
        StateManager.initialize();
        window.iDoWorkInWindow = () -> {
            StateManager.update();
        };
        window.mainCycle(60);
        window.displayDestroy();
    }

}
