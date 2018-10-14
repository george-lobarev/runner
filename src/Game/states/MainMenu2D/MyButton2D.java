package Game.states.MainMenu2D;

import Game.interfaces.ISelectable;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;


public class MyButton2D implements ISelectable {
    private Vector2f startPoints;
    private Vector2f widthHeight;
    private Texture texture;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector2f getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(Vector2f startPoints) {
        this.startPoints = startPoints;
    }

    public Vector2f getWidthHeight() {
        return widthHeight;
    }

    public void setWidthHeight(Vector2f widthHeight) {
        this.widthHeight = widthHeight;
    }

    private float getX() {
        return getStartPoints().getX();
    }

    private float getY() {
        return getStartPoints().getY();
    }

    private float getWidth() {
        return getWidthHeight().getX();
    }

    private float getHeight() {
        return getWidthHeight().getY();
    }

    public MyButton2D() {
    }

    public MyButton2D(Vector2f startPoints, Vector2f widthHeight, String name, Texture texture) {
        setStartPoints(startPoints);
        setWidthHeight(widthHeight);
        setTexture(texture);
        setName(name);
    }

    public void draw() {
        texture.bind();
        glBegin(GL_QUADS);
        glTexCoord2f(1, 1);
        glVertex2f(getX(), getY());
        glTexCoord2f(0, 1);
        glVertex2f(getX() - getWidth(), getY());
        glTexCoord2f(0, 0);
        glVertex2f(getX() - getWidth(), getY() - getHeight());
        glTexCoord2f(1, 0);
        glVertex2f(getX(), getY() - getHeight());
        glEnd();
    }

    @Override
    public boolean IsSelected() {
        float mouseX = Mouse.getX();
        float mouseY = 800 - Mouse.getY();

        return (mouseX > getX() - getWidth() &&
                mouseX < getX() &&
                mouseY > getY() - getHeight() &&
                mouseY < getY());
    }
}

