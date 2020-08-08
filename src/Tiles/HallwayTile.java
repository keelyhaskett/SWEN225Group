package Tiles;

import GameMechanics.Player;

/**
 * Hallway Tiles, can only have one player on tile, way to move
 * around the board.
 */
public class HallwayTile extends AccessibleTile {

    private Player playerOnThisTile; // FIXME: in Tile class already?

    public Player getPlayerOnThisTile() {
        return playerOnThisTile;
    }

    /**
     * Creates a non starting tile.
     * @param pos   Position of the tile.
     */
    public HallwayTile(Position pos) {
        super(pos);
    }

    // FIXME: getter and setter in superclass?
    /**
     * Sets there to be a player on the tile, can be null if no player.
     * @param playerOnThisTile  The player (or null value) to place here.
     */
    public void setPlayerOnThisTile(Player playerOnThisTile) {
        this.playerOnThisTile = playerOnThisTile;
    }

    @Override
    public String toString() {
        if (playerOnThisTile != null) { return playerOnThisTile.toString(); }
        else { return "__"; }
    }
}