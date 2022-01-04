// I worked on the homework assignment alone, using only course materials.

/**
*This class represents a Tekemon object.
*@author Dinyar Islam
*@version 1.0
*/
public abstract class Tekemon {
    private String name;
    private int level;
    private int stamina;

    /**
    *Creates a Tekemon (constructor)
    *@param name Tekemon's name
    *@param level Tekemon's level
    *@param stamina Tekemon's stamina
    */
    public Tekemon(String name, int level, int stamina) {
        this.name = name;
        this.level = level;
        if (stamina < 0) {
            this.stamina = 0;
        } else {
            this.stamina = stamina;
        }
    }

    /**
    *This abstract method challenges another Tekemon to a battle.
    *@param t Opponent Tekemon object
    */
    public abstract void duel(Tekemon t);

    /**
    *This method increases stamina by 15 points.
    */
    public void potion() {
        stamina = (int) (stamina * 1.15);
    }

    /**
    *This abstract method provides the ability for a Tekemon to level up
    *based on certain conditions.
    */
    public abstract void levelUp();

    /**
    *This method overrides equals() method defined in Object class such that
    *two Tekemons are equal if they have the same name, level, and stamina.
    *@param o Object to be compared (ideally a Tekemon object)
    *@return boolean value true only if appropriate conditions are met
    */
    public boolean equals(Object o) {
        if (!(o instanceof Tekemon)) {
            return false;
        }
        Tekemon teke = (Tekemon) o;
        return (teke.name.equals(name)) && (teke.level == level) && (teke.stamina == stamina);
    }

    /**
    *This method returns a String describing the Tekemon.
    *@return a modified string describing the Tekemon.
    */
    public String toString() {
        String str1 = "My name is " + name + ", and I am a Tekemon. My level is " + level;
        return  str1 + " and my current stamina is " + stamina + ".";
    }

    /**
    *Getter method for private variable stamina
    *@return stamina variable
    */
    public int getStamina() {
        return stamina;
    }

    /**
    *Getter method for private variable level
    *@return level variable
    */
    public int getLevel() {
        return level;
    }

    /**
    *Getter method for private variable name
    *@return name variable
    */
    public String getName() {
        return name;
    }

    /**
    *Setter method for private variable stamina
    *@param newStamina contains a new value for the stamina of a Tekemon to be assigned to the stamina variable.
    */
    public void setStamina(int newStamina) {
        stamina = newStamina;
    }

    /**
    *Setter method for private varible level
    *@param newLevel contains a new value for the level of a Tekemon to be assigned to the level variable.
    */
    public void setLevel(int newLevel) {
        level = newLevel;
    }
}