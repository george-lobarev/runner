package Game.baseClasses;

import Game.interfaces.ICollisionWithBlock;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;

import java.util.List;

public class Player extends Block implements ICollisionWithBlock {
    public Player() {
        super();
    }

    public Player(Block block) {
        super(block);
    }

    public Player(Vector3f startPoint, Vector3f widthHeightDepth, Texture texture) {
        super(startPoint, widthHeightDepth, texture);
    }

    public boolean checkConflictWithBlock(List<Block> blocks) {
        for (Block b : blocks) {
            if (checkConflictWithBlock(b)) {
                return checkConflictWithBlock(b);
            }
        }
        return false;
    }

    private boolean checkSimple(Vector3f firstCoords, Vector3f secondCoords) {
        return (firstCoords.getX() >= secondCoords.getX() &&
                firstCoords.getY() >= secondCoords.getY() &&
                firstCoords.getZ() >= secondCoords.getZ());
    }

    @Override
    public boolean checkConflictWithBlock(Block block) {
        return (checkSimple(getStartPoint(), block.getCurrentPosition())
                && checkSimple(block.getStartPoint(), getCurrentPosition()));
    }

}
