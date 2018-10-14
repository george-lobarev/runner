package Game.interfaces;

import Game.baseClasses.Block;

public interface ICollisionWithBlock {
    boolean checkConflictWithBlock(Block block);
}
