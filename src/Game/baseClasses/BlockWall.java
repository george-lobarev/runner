package Game.baseClasses;

import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockWall {
    private List<Block> blockWallList;
    private List<Block> letList;
    private Block templateBlock;
    private Vector3f defaultLocation;
    private int countX;
    private int countY;
    private int countZ;
    private int countLet;
    private int size;

    private int getCountLet() {
        return countLet;
    }

    public void setCountLet(int countLet) {
        this.countLet = countLet;
        initLet();
    }

    private int getSize() {
        return size;
    }

    private void setSize() {
        this.size = getCountX() * getCountY() * getCountZ();
    }

    Vector3f getDefaultLocation() {
        return defaultLocation;
    }

    private void setDefaultLocation(Vector3f defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    private Block getTemplateBlock() {
        return templateBlock;
    }

    private void setTemplateBlock(Block templateBlock) {
        this.templateBlock = templateBlock;
    }

    private int getCountY() {
        return countY;
    }

    private void setCountY(int countY) {
        this.countY = countY;
    }

    private int getCountX() {
        return countX;
    }

    private void setCountX(int countX) {
        this.countX = countX;
    }

    private int getCountZ() {
        return countZ;
    }

    private void setCountZ(int countZ) {
        this.countZ = countZ;
    }

    List<Block> getBlockWallList() {
        return blockWallList;
    }

    public List<Block> getLetList() {
        return letList;
    }

    private void setLetList() {
        letList = new ArrayList<>();
    }

    public BlockWall() {

    }

    public BlockWall(int countX, int countY, int countZ, Block block) {
        setCountX(countX);
        setCountY(countY);
        setCountZ(countZ);
        setSize();
        setTemplateBlock(block);
        setBlockWall();
    }

    public BlockWall(BlockWall blockWall) {
        this.setCountX(blockWall.getCountX());
        this.setCountY(blockWall.getCountY());
        this.setCountZ(blockWall.getCountZ());
        setSize();
        this.setTemplateBlock(blockWall.getTemplateBlock());
        this.setBlockWall();
        this.setCountLet(blockWall.getCountLet());
    }

    private void setBlockWall() {
        this.blockWallList = new ArrayList<>();
        for (int i = 0; i != getSize(); i++) {
            blockWallList.add(new Block(getTemplateBlock()));
        }

    }

    public void setLocationWall(Vector3f vector3f) {
        Block block;
        setDefaultLocation(vector3f);
        int count = 0;
        for (int x = 0; x != getCountX(); x++) {
            for (int y = 0; y != getCountY(); y++) {
                for (int z = 0; z != getCountZ(); z++) {
                    block = getBlockWallList().get(count);
                    block.setStartPoint(new Vector3f(vector3f.getX() + x * block.getWidthHeightDepth().getX(),
                            vector3f.getY() + y * block.getWidthHeightDepth().getY(),
                            vector3f.getZ() - z * block.getWidthHeightDepth().getZ()));
                    count++;
                }
            }
        }
    }

    private void initLet() {
        setLetList();
        LetBlock letBlock;
        for (int i = 0; i != getCountLet(); i++) {
            letBlock = new LetBlock(randBlock());
            getLetList().add(letBlock);
            getBlockWallList().add(letBlock);
        }
    }

    Block randBlock() {
        return (getBlockWallList().get(new Random().nextInt(getSize())));
    }
}
