package Game.states;

import Game.initialization.InitMeasurement;
import Game.initialization.MainWindow;
import Game.states.MainMenu2D.MainMenu2D;


public class StateManager {
    public enum GameState {
        MAINMENU, GAME, SCORELIST
    }

    public static GameState gameState;
    public static Game game;
    public static MainMenu2D mainMenu;
    public static ScoreList scoreList;

    public static void initialize() {
        game = new Game();

        mainMenu = new MainMenu2D();
        mainMenu.addButton("play");
        /*mainMenu.addButton("score");
        mainMenu.addButton("exit");*/
        setGameState(GameState.MAINMENU);

    }


    public static void setGameState(GameState newState) {
        gameState = newState;
        if (gameState == GameState.GAME) {
            InitMeasurement.init3D(60, (float) MainWindow.WIDTH / (float) MainWindow.HEIGHT, 1, 200);
        } else {
            InitMeasurement.init2D(0, 1000, 800, 0, 1, -1);
        }
    }

    public static void update() {
        switch (gameState) {
            case GAME:
                if (game == null) {
                    game = new Game();
                }
                game.update();
                break;
            case MAINMENU:
                game = null;
                mainMenu.update();
                break;
            case SCORELIST:
                break;
        }
    }
}
