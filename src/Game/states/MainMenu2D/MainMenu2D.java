package Game.states.MainMenu2D;

import Game.baseClasses.DrawEngine;
import Game.baseClasses.MyTextureLoader;
import Game.states.StateManager;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

public class MainMenu2D {
    private List<MyButton2D> buttonList = new ArrayList();

    public List<MyButton2D> getButtonList() {
        return buttonList;
    }

    public MainMenu2D() {
    }

    public void addButton(String name) {
        getButtonList().add(new MyButton2D(
                new Vector2f(400, getButtonList().size() * 80 + 200),
                new Vector2f(200, 80), name,
                MyTextureLoader.textureLoad("res/images/" + name + ".png")));
    }

    private String checkClickOnButton() {
        for (MyButton2D mb : getButtonList()) {
            if (mb.IsSelected()) {
                return mb.getName();
            }
        }
        return "";
    }


    public void update() {
        if (Mouse.isButtonDown(0)) {
            switch (checkClickOnButton()) {
                case "play":
                    StateManager.setGameState(StateManager.GameState.GAME);
                    break;
                case "score":
                    StateManager.setGameState(StateManager.GameState.SCORELIST);
                    break;
                case "mainmenu":
                    StateManager.setGameState(StateManager.GameState.MAINMENU);
                    break;
            }
            System.out.println(checkClickOnButton());
        }

        DrawEngine.drawBlock2D(getButtonList());
    }
}

