package Game.baseClasses;

import java.util.ArrayList;
import java.util.List;

public class BlockWallTunnel {
    private BlockWall uperWall;
    private BlockWall downWall;
    private BlockWall leftWall;
    private BlockWall rightWall;
    private List<Block> lets = new ArrayList<>();
    private BlockWall walls[] = null;

    public List<Block> getLets() {
        return lets;
    }

    public void setLets() {
        for (BlockWall b : getWalls()) {
            this.lets.addAll(b.getLetList());
        }
    }

    public BlockWall getUperWall() {
        return uperWall;
    }

    private void setUperWall(BlockWall uperWall) {
        this.uperWall = uperWall;
    }

    public BlockWall getDownWall() {
        return downWall;
    }

    private void setDownWall(BlockWall downWall) {
        this.downWall = downWall;
    }

    public BlockWall getLeftWall() {
        return leftWall;
    }

    private void setLeftWall(BlockWall leftWall) {
        this.leftWall = leftWall;
    }

    public BlockWall getRightWall() {
        return rightWall;
    }

    private void setRightWall(BlockWall rightWall) {
        this.rightWall = rightWall;
    }

    public BlockWall[] getWalls() {
        return walls;
    }

    private void setWalls(BlockWall[] walls) {
        this.walls = walls;
    }

    private void setAll(BlockWall blockWalls[]) {
        setDownWall(blockWalls[0]);
        setUperWall(blockWalls[1]);
        setLeftWall(blockWalls[2]);
        setRightWall(blockWalls[3]);
        setWalls(blockWalls);
    }

    public BlockWallTunnel(BlockWall blockWalls[]) {
        setAll(blockWalls);
    }
}
