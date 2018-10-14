package Game.states;

import Game.baseClasses.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Game {

    private BlockWallTunnel tunnel;
    private Camera camera;
    private Player player;
    private Block endTunnel;
    private int life = 0;
    private boolean sateOfGame;

    public boolean isSateOfGame() {
        return sateOfGame;
    }

    public void setSateOfGame(boolean sateOfGame) {
        this.sateOfGame = sateOfGame;
    }

    private BlockWallTunnel getTunnel() {
        return tunnel;
    }

    private void setTunnel(BlockWallTunnel tunnel) {
        this.tunnel = tunnel;
    }

    public Camera getCamera() {
        return camera;
    }

    private void setCamera(Camera camera) {
        this.camera = camera;
    }

    private Player getPlayer() {
        return player;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    private Block getEndTunnel() {
        return endTunnel;
    }

    private void setEndTunnel(Block endTunnel) {
        this.endTunnel = endTunnel;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Game() {
        initialize();
    }

    private void initialize() {
        setSateOfGame(true);

        setLife(1);

        setEndTunnel(new Block(new Vector3f(3, 3, -60),
                new Vector3f(6, 6, 1),
                MyTextureLoader.textureLoad("res/images/texture.png")));

        setPlayer(new Player(new Vector3f(0, 0, 0),
                new Vector3f(2, 2, 2),
                MyTextureLoader.textureLoad("res/images/texture_2.png")));

        setCamera(new Camera(new Vector3f(0, 0, 0), player, 2f, -2.0f));
        getCamera().setDelta(new Vector3f(0, 0, 1.4f));

        //setupTunnel
        Block testBlockText = new Block(new Vector3f(0, 0, 0),
                new Vector3f(3, 3, 3),
                MyTextureLoader.textureLoad("res/images/texture.png"));

        BlockWall temlateWallVertical = new BlockWall(1, 2, 20, testBlockText);
        BlockWall temlateWallHorizontal = new BlockWall(2, 1, 20, testBlockText);

        setTunnel(new BlockWallTunnel(new BlockWall[]{
                new BlockWall(temlateWallHorizontal),
                new BlockWall(temlateWallHorizontal),
                new BlockWall(temlateWallVertical),
                new BlockWall(temlateWallVertical)}));

        getTunnel().getDownWall().setLocationWall(new Vector3f(0, -3, -20));
        getTunnel().getUperWall().setLocationWall(new Vector3f(0, 6, -20));
        getTunnel().getLeftWall().setLocationWall(new Vector3f(6, 0, -20));
        getTunnel().getRightWall().setLocationWall(new Vector3f(-3, 0, -20));

        getTunnel().getDownWall().setCountLet(2);
        getTunnel().getUperWall().setCountLet(2);
        getTunnel().setLets();

    }

    private void drive() {
        Keyboard.next();
        switch (Keyboard.getEventKey()) {
            case Keyboard.KEY_RIGHT:
                getCamera().movePosition(new Vector3f(-.3f, 0.0f, 0.0f));
                break;
            case Keyboard.KEY_LEFT:
                getCamera().movePosition(new Vector3f(.3f, 0.0f, 0.0f));
                break;
            case Keyboard.KEY_UP:
                getCamera().movePosition(new Vector3f(0.0f, -.3f, 0.0f));
                break;
            case Keyboard.KEY_DOWN:
                getCamera().movePosition(new Vector3f(0.0f, .3f, 0.0f));
                break;
        }
        /*if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            setSateOfGame(!isSateOfGame());
        }*/
    }

    public void update() {
        if (isSateOfGame()) {
            if (!getPlayer().checkConflictWithBlock(getTunnel().getLets())) {
                MoveEngine.moveBlockWalls(new Vector3f(0, 0, 0.6f), getTunnel().getWalls());
            } else {
                if (getLife() <= 0) {
                    StateManager.setGameState(StateManager.GameState.MAINMENU);
                }
                life--;
            }
        }
        DrawEngine.drawWalls(getTunnel().getWalls());
        DrawEngine.drawBlock(getEndTunnel());
        drive();
        getCamera().setCurrnetCamera();
    }

}
