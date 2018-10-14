package Game.initialization;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;


public class WindowCreate {
    private String windowTitle;
    private int displayWidth, displayHeight;
    IDoWorkInWindow iDoWorkInWindow;

    private int getDisplayWidth() {
        return displayWidth;
    }

    private void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    private int getDisplayHeight() {
        return displayHeight;
    }

    private void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }

    private String getWindowTitle() {
        return windowTitle;
    }

    private void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    WindowCreate(String windowTitle, int x, int y) {
        setWindowTitle(windowTitle);
        setDisplayWidth(x);
        setDisplayHeight(y);
        try {
            Display.setDisplayMode(new DisplayMode(getDisplayWidth(), getDisplayHeight()));
            Display.setTitle(getWindowTitle());
            Display.setVSyncEnabled(true);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }

    void mainCycle(int fps) {
        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            iDoWorkInWindow.doWork();
            Display.update();
            Display.sync(fps);
        }
    }

    void displayDestroy() {
        Display.destroy();
    }

    public interface IDoWorkInWindow {
        void doWork();
    }
}
