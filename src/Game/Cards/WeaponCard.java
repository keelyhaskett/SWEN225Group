package Game.Cards;

import java.util.Objects;

/**
 * Weapon card for the game of Cluedo.
 */
public class WeaponCard implements Card {

    private final WeaponEnum weapon;

    /**
     * Constructs a WeaponCard object that contains a weapon.
     *
     * @param weapon the weapon represent.
     */
    public WeaponCard(WeaponEnum weapon) {
        this.weapon = weapon;
    }

    /**
     * Possible weapons.
     */
    public enum WeaponEnum {
        CANDLESTICK, LEADPIPE, DAGGER, REVOLVER, ROPE, SPANNER
    }

    /**
     * Gets the filename of the card as a string.
     *
     * @return Filename of the card as a string.
     */
    public String getFileName() {
        return this.toString() + ".png";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponCard that = (WeaponCard) o;
        return weapon == that.weapon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weapon);
    }

    @Override
    public String toString() {
        switch (weapon) {
            case CANDLESTICK:
                return "Candlestick";
            case LEADPIPE:
                return "Leadpipe";
            case DAGGER:
                return "Dagger";
            case REVOLVER:
                return "Revolver";
            case ROPE:
                return "Rope";
            case SPANNER:
                return "Spanner";
            default:
                throw new IllegalArgumentException();
        }
    }
}