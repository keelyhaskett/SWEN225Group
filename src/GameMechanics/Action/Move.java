package GameMechanics.Action;

import GameMechanics.Board;
import GameMechanics.Player;
import Tiles.EntranceTile;
import Tiles.InaccessibleTile;
import Tiles.Position;
import Tiles.Tile;

import java.util.Scanner;

/**
 * Move players around the board and check the validity of those moves.
 */
public class Move {

    private boolean hasMadeValidMove = false;

    private final Player currentPlayer;
    private final Board board;
    private int movementRange = 999;

    /**
     * Initialise a new move instance.
     *
     * @param currentPlayer Player that's moving
     * @param board         Board to move around on
     */
    public Move(Player currentPlayer, Board board) {
        this.currentPlayer = currentPlayer;
        this.board = board;
    }

    /**
     * Handles user input and console output for movement.
     * Calls necessary methods to control movement.
     */
    public void playerMovement() {
        //roll dice
        //movementRange = rollDice(); TODO uncomment at the end
        System.out.println("You rolled a " + movementRange);

        //ask for tile to move to
        hasMadeValidMove = false;
        while (!hasMadeValidMove) {

            System.out.println("Your position \nRow: " + currentPlayer.getTile().position.getY()
                    + "\nCol: " + currentPlayer.getTile().position.getX());
            System.out.println("\nEnter column to move to:");

            int moveCol = -1;
            int moveRow = -1;
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextInt()) {
                moveCol = scan.nextInt();
                System.out.println("Enter row to move to:");    //repeats until valid inputs
                if (scan.hasNextInt()) {
                    moveRow = scan.nextInt();
                }
            }

            if (moveRow < 25 && moveRow >= 0 && moveCol < 24 && moveCol >= 0) {
                move(moveCol, moveRow); //check if requested tile is within board bounds
            } else {
                System.out.println("Invalid row/column, try again.");
            }
        }
    }

    /**
     * Checks if the requested move of the player is a valid movement.
     * Checks for out of board, out of move range, tile types.
     *
     * @param startX Starting x position
     * @param startY Starting y position
     * @param endX   Ending x position
     * @param endY   Ending y position
     * @return true if valid move, false if invalid move.
     */
    public Boolean isValidMovement(int startX, int startY, int endX, int endY) {

        Position endPos = new Position(endX, endY);

        //if endTile == inaccessible
        if (board.getTileAt(endPos) instanceof InaccessibleTile) {
            System.out.println("Inaccessible Tile");
            return false;
        }

        Tile endTile = board.getTileAt(endPos);
        if ((endTile.getPlayerOnThisTile() != null) && !(board.getTileAt(endPos) instanceof EntranceTile)) {
            System.out.println("Tile already has player on it");
            return false;//else if endPos already has player && endPos is not entranceTile
        }

        if (Math.abs((startX - endX) + (startY - endY)) > this.movementRange) {
            System.out.println("You can not move that far!");
            return false;
        }

        hasMadeValidMove = true;
        return true;
    }

    /**
     * Get the move, and move the player if the move is deemed valid.
     *
     * @param x x coordinate to move to
     * @param y y coordinate to move to
     */
    public void move(int x, int y) {

        Tile startTile = currentPlayer.getTile();   //tile before moving
        Position endPos = new Position(x, y); // position to move to
        Tile endTile = board.getTileAt(endPos);    //tile to move to
        int playerX = currentPlayer.getTile().position.getX();    //current X
        int playerY = currentPlayer.getTile().position.getY();    //current Y
        if (isValidMovement(playerX, playerY, x, y)) {
            currentPlayer.setTile(endTile);
            endTile.setPlayerOnThisTile(currentPlayer);
            startTile.setPlayerOnThisTile(null);
        }
    }

    /**
     * Rolls two dice and returns the sum of them.
     *
     * @return Sum of two dice.
     */
    private int rollDice() {
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        return dice1 + dice2;
    }

}
