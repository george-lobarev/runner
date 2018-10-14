package Game.baseClasses;

import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    private Vector3f startPoint;
    private Vector3f widthHeightDepth;
    private Texture texture;

    float getX() {
        return startPoint.x;
    }

    float getY() {
        return startPoint.y;
    }

    float getZ() {
        return startPoint.z;
    }

    float getWidth() {
        return widthHeightDepth.x;
    }

    float getHeight() {
        return widthHeightDepth.y;
    }

    float getDepth() {
        return widthHeightDepth.z;
    }

    Vector3f getCurrentPosition() {
        return new Vector3f(getX() - getWidth(),
                getY() - getHeight(),
                getZ() - getDepth());
    }

    public void setWidthHeightDepth(Vector3f widthHeightDepth) {
        this.widthHeightDepth = widthHeightDepth;
    }

    public void setStartPoint(Vector3f startPoint) {
        this.startPoint = startPoint;
    }

    Vector3f getStartPoint() {
        return startPoint;
    }

    Vector3f getWidthHeightDepth() {
        return widthHeightDepth;
    }

    public Block(Vector3f startPoint, Vector3f widthHeightDepth) {
        this.startPoint = startPoint;
        this.widthHeightDepth = widthHeightDepth;
    }

    public Block(Vector3f startPoint, Vector3f widthHeightDepth, Texture texture) {
        this.startPoint = startPoint;
        this.widthHeightDepth = widthHeightDepth;
        this.texture = texture;
    }

    public Block(Block block) {
        this.startPoint = block.startPoint;
        this.widthHeightDepth = block.widthHeightDepth;
        this.texture = block.texture;
    }

    public Block() {
    }

    void drawBlock() {

        texture.bind();
        glBegin(GL_QUADS);

        glTexCoord2f(0, 1);//up
        glVertex3d(getX(), getY(), getZ() - getDepth());
        glTexCoord2f(0, 0);
        glVertex3d(getX() - getWidth(), getY(), getZ() - getDepth());
        glTexCoord2f(1, 0);
        glVertex3d(getX() - getWidth(), getY(), getZ());
        glTexCoord2f(1, 1);
        glVertex3d(getX(), getY(), getZ());

        glTexCoord2f(0, 0);//down
        glVertex3d(getX(), getY() - getHeight(), getZ());
        glTexCoord2f(1, 0);
        glVertex3d(getX() - getWidth(), getY() - getHeight(), getZ());
        glTexCoord2f(1, 1);
        glVertex3d(getX() - getWidth(), getY() - getHeight(), getZ() - getDepth());
        glTexCoord2f(0, 1);
        glVertex3d(getX(), getY() - getHeight(), getZ() - getDepth());

        glTexCoord2f(1, 0);//forward
        glVertex3d(getX(), getY(), getZ());
        glTexCoord2f(0, 0);
        glVertex3d(getX() - getWidth(), getY(), getZ());
        glTexCoord2f(0, 1);
        glVertex3d(getX() - getWidth(), getY() - getHeight(), getZ());
        glTexCoord2f(1, 1);
        glVertex3d(getX(), getY() - getHeight(), getZ());

        glTexCoord2f(1, 0);//back
        glVertex3d(getX(), getY() - getHeight(), getZ() - getDepth());
        glTexCoord2f(0, 0);
        glVertex3d(getX() - getWidth(), getY() - getHeight(), getZ() - getDepth());
        glTexCoord2f(0, 1);
        glVertex3d(getX() - getWidth(), getY(), getZ() - getDepth());
        glTexCoord2f(1, 1);
        glVertex3d(getX(), getY(), getZ() - getDepth());

        glTexCoord2f(0, 1);//left
        glVertex3d(getX() - getWidth(), getY(), getZ());
        glTexCoord2f(1, 1);
        glVertex3d(getX() - getWidth(), getY(), getZ() - getDepth());
        glTexCoord2f(1, 0);
        glVertex3d(getX() - getWidth(), getY() - getHeight(), getZ() - getDepth());
        glTexCoord2f(0, 0);
        glVertex3d(getX() - getWidth(), getY() - getHeight(), getZ());

        glTexCoord2f(0, 1);//right
        glVertex3d(getX(), getY(), getZ() - getDepth());
        glTexCoord2f(1, 1);
        glVertex3d(getX(), getY(), getZ());
        glTexCoord2f(1, 0);
        glVertex3d(getX(), getY() - getHeight(), getZ());
        glTexCoord2f(0, 0);
        glVertex3d(getX(), getY() - getHeight(), getZ() - getDepth());

        glEnd();
    }
}
