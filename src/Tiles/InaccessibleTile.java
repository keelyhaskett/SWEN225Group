package Tiles;

public class InaccessibleTile implements Tile {

    public InaccessibleTile() {
    }

    public void delete() {
    }

    @Override
    public void draw() {
        return;
    }

}