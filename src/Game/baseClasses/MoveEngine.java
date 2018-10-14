package Game.baseClasses;

import org.lwjgl.util.vector.Vector3f;

import java.util.Random;

public class MoveEngine {
    public static void setPositionBlock(Vector3f vector3f, Block block) {
        block.setStartPoint(new Vector3f(vector3f.getX(),
                vector3f.getY(),
                vector3f.getZ()));
    }

    public static void setPositionBlocks(Vector3f vector3f, Block... blocks) {
        for (Block b : blocks) {
            setPositionBlock(vector3f, b);
        }

    }

    public static void moveBlock(Vector3f vector3f, Block block) {
        block.setStartPoint(new Vector3f(block.getX() + vector3f.getX(),
                block.getY() + vector3f.getY(),
                block.getZ() + vector3f.getZ()));

    }

    private static void moveBlockWall(Vector3f vector3f, BlockWall blockWall) {
        Random random = new Random();
        for (Block b : blockWall.getBlockWallList()) {
            if ((b.getZ() + vector3f.getZ()) > 0/*b.getWidthHeightDepth().getZ()*(getCountZ()*/) {
                setPositionBlock(new Vector3f(b.getX() + vector3f.getX(),
                        b.getY() + vector3f.getY(),
                        b.getDepth() * blockWall.getDefaultLocation().getZ()), b);
                //for horizontal walls((
                if (b.getClass() == LetBlock.class) {
                    setPositionBlock(new Vector3f(blockWall.getDefaultLocation().getX() +
                            random.nextInt(2) * b.getWidth(),
                            blockWall.getDefaultLocation().getY() +
                                    b.getHeight() * -Math.signum(blockWall.getDefaultLocation().getY()),
                            blockWall.randBlock().getZ() - 36), b);
                }
            }
            moveBlock(vector3f, b);
        }
    }

    public static void moveBlockWalls(Vector3f vector3f, BlockWall... blockWalls) {
        for (BlockWall b : blockWalls) {
            moveBlockWall(vector3f, b);
        }
    }
}