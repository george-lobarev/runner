package Game.initialization;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class InitMeasurement {
    public static void init3D(int fovy, float aspect, int zNear, int zfar) {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(fovy, aspect, zNear, zfar);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_BLEND);
        glEnable(GL_TEXTURE_2D);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_DEPTH_TEST);
    }

    public static void init2D(int left, int right, int bottom, int top, int zNear, int zFar) {
        glLoadIdentity();
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(left, right, bottom, top, zNear, zFar);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_TEXTURE_2D);
    }
}
