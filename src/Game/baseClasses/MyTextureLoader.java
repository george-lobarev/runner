package Game.baseClasses;

import org.newdawn.slick.opengl.Texture;

import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;

public class MyTextureLoader extends TextureLoader {
    public static Texture textureLoad(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            return getTexture("PNG", fileInputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
