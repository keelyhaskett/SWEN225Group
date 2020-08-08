package GameMechanics;

import Cards.CharacterCard;
import Cards.RoomCard;
import Cards.WeaponCard;

import java.util.Objects;

/**
 * TODO
 */
public class Hypothesis {

    private CharacterCard character;
    private WeaponCard weapon;
    private RoomCard room;

    public Hypothesis(CharacterCard character, WeaponCard weapon, RoomCard room) {
        this.character = character;
        this.weapon = weapon;
        this.room = room;
    }

    /**
     * Setter for character.
     *
     * @param character CharacterCard to set.
     */
    public void setCharacter(CharacterCard character) {
        this.character = character;
    }

    /**
     * Setter for weapon.
     *
     * @param weapon WeaponCard to set.
     */
    public void setWeapon(WeaponCard weapon) {
        this.weapon = weapon;
    }

    /**
     * Setter for room.
     *
     * @param room RoomCard to set.
     */
    public void setRoom(RoomCard room) {
        this.room = room;
    }

    /**
     * Getter for character.
     *
     * @return CharacterCard of the Hypothesis.
     */
    public CharacterCard getCharacter() {
        return character;
    }

    /**
     * Getter for weapon.
     *
     * @return WeaponCard of the Hypothesis.
     */
    public WeaponCard getWeapon() {
        return weapon;
    }

    /**
     * Getter for room.
     *
     * @return RoomCard of the Hypothesis.
     */
    public RoomCard getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return character + ", " + weapon +
                ", " + room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hypothesis that = (Hypothesis) o;
        return character.equals(that.character) &&
                weapon.equals(that.weapon) &&
                room.equals(that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, weapon, room);
    }
}