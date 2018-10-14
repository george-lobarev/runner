package Game.baseClasses;

import Game.states.MainMenu2D.MyButton2D;

import java.util.List;


public class DrawEngine {
    public static void drawBlock(Block block) {
        block.drawBlock();
    }

    private static void drawBlocks(List<Block> listBlock) {//block ... blocks
        for (Block b : listBlock) {
            drawBlock(b);
        }
    }

    public static void drawWalls(BlockWall... blockWalls) {
        for (BlockWall b : blockWalls) {
            drawBlocks(b.getBlockWallList());
        }
    }

    public static void drawBlock2D(MyButton2D myButton) {
        myButton.draw();
    }

    public static void drawBlock2D(List<MyButton2D> myButtons) {
        for (MyButton2D mb : myButtons) {
            drawBlock2D(mb);
        }
    }
}
