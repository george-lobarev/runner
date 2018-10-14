package Game.baseClasses;


import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL11.glTranslated;

public class Camera {
    private Vector3f position;
    private Vector3f delta;
    private Block cameraBlock;
    private float positive_border;
    private float negative_border;

    public Camera(Vector3f vector3f, Block block, float positive_border, float negative_border) {
        setDelta();
        setPosition(vector3f);
        setNegative_border(negative_border);
        setPositive_border(positive_border);
        setCameraBlock(block);

    }

    public void movePosition(Vector3f del) {
        if (checkPosition(del)) {
            setDelta(del);
            setPosition(new Vector3f(position.x + delta.x,
                    position.y + delta.y,
                    position.z + delta.z));
            setCameraBlockFunc();
        }
    }

    private boolean checkPosition(Vector3f tempDelta) {
        return ((position.x + tempDelta.x >= negative_border && position.x + tempDelta.x <= positive_border) &&
                (position.y + tempDelta.y >= negative_border && position.y + tempDelta.y <= positive_border));
    }

    public void setCurrnetCamera() {
        glTranslated(getDelta().getX(), getDelta().getY(), getDelta().getZ());
        setDelta();
    }

    private void setCameraBlockFunc() {
        MoveEngine.setPositionBlock(new Vector3f(-getPosition().getX() + getCameraBlock().getWidth() / 2,
                -getPosition().getY() + getCameraBlock().getHeight() / 2,
                getPosition().getZ() - getCameraBlock().getDepth() / 2), getCameraBlock());
    }

    private Block getCameraBlock() {
        return cameraBlock;
    }

    private void setCameraBlock(Block cameraBlock) {
        this.cameraBlock = cameraBlock;
        setCameraBlockFunc();
    }

    private Vector3f getDelta() {
        return delta;
    }

    public void setDelta(Vector3f delta) {
        this.delta = delta;
    }

    private void setDelta() {
        this.delta = new Vector3f(0, 0, 0);
    }

    public Vector3f getPosition() {
        return position;
    }

    private void setPosition(Vector3f position) {
        this.position = position;
    }

    public float getPositive_border() {
        return positive_border;
    }

    private void setPositive_border(float positive_border) {
        this.positive_border = positive_border;
    }

    public float getNegative_border() {
        return negative_border;
    }

    private void setNegative_border(float negative_border) {
        this.negative_border = negative_border;
    }
}