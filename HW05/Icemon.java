// I worked on the homework assignment alone, using only course materials.

/**
*This class is a subclass of the Tekemon class and represents an Icemon object.
*@author Dinyar Islam
*@version 1.0
*/
public class Icemon extends Tekemon {
    private boolean pet;
    private static int icemonSize = 0;
    private int icePoints;

    /**
    *Creates a Icemon (constructor)
    *@param name Icemon's name
    */
    public Icemon(String name) {
        super(name, 15, 100);
        pet = true;
        icePoints = 0;
        icemonSize++;
    }

    /**
    *Creates a Icemon (constructor)
    *@param name Icemon's name
    *@param level Icemon's level
    *@param stamina Icemon's stamina
    *@param pet Whether or not Icemon owns a pet
    *@param icePoints The total amount of points the Icemon has earned
    */
    public Icemon(String name, int level, int stamina, boolean pet, int icePoints) {
        super(name, level, stamina);
        this.pet = pet;
        this.icePoints = icePoints;
        icemonSize++;
    }

    /**
    *This method challenges another Tekemon to a battle and overrides
    *duel() method declared in the Tekemon superclass.
    *@param t Opponent Tekemon object
    */
    @Override
    public void duel(Tekemon t) {
        int oppStamina = t.getStamina();
        int oppLevel = t.getLevel();
        int icemonLevel = super.getLevel();
        int icemonStamina = super.getStamina();
        if (t instanceof Icemon) {
            System.out.println("Cannot duel an ally!");
        } else if ((oppStamina == 0) || (icemonStamina == 0)) {
            System.out.println("Cannot duel!");
        } else {
            oppStamina = oppStamina - (2 * icemonLevel);
            if (oppStamina < 0) {
                oppStamina = 0;
            }
            t.setStamina(oppStamina);
            if (oppStamina == 0) {
                icePoints = icePoints + (int) (0.5 * oppLevel);
                levelUp();
            }
        }
    }

    /**
    *This method provides the ability for a Icemon to level up based on certain
    *conditions overrides the levelUp() method declared in the Tekemon superclass.
    */
    @Override
    public void levelUp() {
        boolean noMoreLevUp = false;
        int currentLevel = super.getLevel();
        while (!noMoreLevUp) {
            if (currentLevel >= 20) {
                if (icePoints >= 30) {
                    currentLevel++;
                    icePoints = icePoints - 30;
                    System.out.println("Yay, I am now level " + currentLevel + "!");
                }
            } else if (currentLevel < 20) {
                if (icePoints >= 20) {
                    currentLevel++;
                    icePoints = icePoints - 20;
                    System.out.println("Yay, I am now level " + currentLevel + "!");
                }
            }
            if (currentLevel >= 20 && icePoints < 30) {
                noMoreLevUp = true;
            } else if (currentLevel < 20 && icePoints < 20) {
                noMoreLevUp = true;
            }
        }
        super.setLevel(currentLevel);
    }

    /**
    *This method increases the icePoints of the Icemon based off the icemonSize.
    */
    public void iceWreck() {
        if (icemonSize > 0) {
            icePoints = (int) (((double) (icemonSize * 10) / 100 * icePoints) + icePoints);
        }
    }

    /**
    *This method produces icicles to increase stamina at the cost of icePoints.
    */
    public void brainFreeze() {
        if (icePoints > 5) {
            int currenticePoints = icePoints;
            int currentStamina = super.getStamina();
            currentStamina = currenticePoints / 2 + currentStamina;
            super.setStamina(currentStamina);
            icePoints = icePoints - 5;
            if (icePoints < 0) {
                icePoints = 0;
            }
        }
    }

    /**
    *This method overrides Tekemon’s equals() method such that two Icemons
    *are equal if they both have the same name, level,stamina,and the same value
    *for pet
    *@param o object to be compared (ideally an Icemon object)
    *@return boolean value true only if appropriate conditions are met.
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Icemon)) {
            return false;
        }
        boolean icemonFlag = false;
        Icemon icy = (Icemon) o;
        if (icy.pet == pet) {
            icemonFlag = true;
        } else {
            icemonFlag = false;
        }
        return icemonFlag && super.equals(o);
    }

    /**
    *This method returns a String describing the Icemon.
    @return a modified string describing the Icemon.
    */
    public String toString() {
        String retStr = super.toString();
        if (pet) {
            return retStr + " I am a Icemon, and I have a pet.";
        } else {
            return retStr + " I am a Icemon, and I do not have a pet.";
        }
    }
}