package Game.baseClasses;

import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;

public class LetBlock extends Block {
    private LetBlock() {
        super();
    }

    LetBlock(Block block) {
        super(block);
    }

    public LetBlock(Vector3f startPoint, Vector3f widthHeightDepth, Texture texture) {
        super(startPoint, widthHeightDepth, texture);
    }
}
