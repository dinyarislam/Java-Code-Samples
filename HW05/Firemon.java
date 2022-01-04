// I worked on the homework assignment alone, using only course materials.
import java.util.Random;

/**
*This class is a subclass of the Tekemon class and represents an Firemon object.
*@author Dinyar Islam
*@version 1.0
*/
public class Firemon extends Tekemon {
    private int knowledgeLevel;
    private int firePoints;

    /**
    *Creates a Firemon (constructor)
    *@param name Firemon's name
    */
    public Firemon(String name) {
        super(name, 30, 20);
        knowledgeLevel = 30;
        firePoints = 0;
    }

    /**
    *Creates a Firmeon (constructor)
    *@param name Firmeon's name
    *@param level Firmeon's level
    *@param stamina Firmeon's stamina
    *@param knowledgeLevel the knowledge level of the Firemon
    *@param firePoints the total amount of points the Firemon has earned
    */
    public Firemon(String name, int level, int stamina, int knowledgeLevel, int firePoints) {
        super(name, level, stamina);
        this.knowledgeLevel = knowledgeLevel;
        this.firePoints = firePoints;
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
        int fmonStamina = super.getStamina();
        if (t instanceof Firemon) {
            System.out.println("Cannot duel an ally!");
        } else if ((oppStamina == 0) || (fmonStamina == 0)) {
            System.out.println("Cannot duel!");
        } else {
            if (knowledgeLevel > 13) {
                Random randInt = new Random();
                int number = randInt.nextInt(10) + 1;
                if (number % 2 != 0) {
                    fireFight();
                }
                int fmonLevel = super.getLevel();
                oppStamina = oppStamina - (15 + (int) (0.5 * fmonLevel));
                if (oppStamina < 0) {
                    oppStamina = 0;
                }
                if (oppStamina == 0) {
                    firePoints = firePoints + (int) (0.5 * oppLevel);
                    levelUp();
                }
            }
        }
    }

    /**
    *This method allows firemon to play fireFight and increases a firemon's
    *firePoints based on certain conditions.
    */
    public void fireFight() {
        int currentStamina = super.getStamina();
        if (currentStamina > 25) {
            if (knowledgeLevel >= 30) {
                firePoints = firePoints + 20;
            } else if (knowledgeLevel < 30) {
                firePoints = firePoints + 10;
            }
            System.out.println("We won the fight, yay!");
        }
        levelUp();
    }

    /**
    *This method provides the ability for a Firemon to level up based on certain
    *conditions overrides the levelUp() method declared in the Tekemon superclass.
    */
    @Override
    public void levelUp() {
        boolean noMoreLevUp = false;
        int currentLevel = getLevel();
        while (!noMoreLevUp) {
            if (currentLevel >= 30) {
                if (firePoints >= 40) {
                    currentLevel++;
                    firePoints = firePoints - 40;
                    System.out.println("Yay, I am now level " + currentLevel + "!");
                }
            } else if (currentLevel < 30) {
                if (firePoints >= 20) {
                    currentLevel++;
                    firePoints = firePoints - 20;
                    System.out.println("Yay, I am now level " + currentLevel + "!");
                }
            }
            super.setLevel(currentLevel);
            if (currentLevel >= 20 && firePoints < 30) {
                noMoreLevUp = true;
            } else if (currentLevel < 20 && firePoints < 20) {
                noMoreLevUp = true;
            }
        }
    }

    /**
    *This method overrides Tekemon’s equals() method such that two Firemon's
    *are equal if they both have the same name, level,stamina,and the same value
    *for knowledgeLevel.
    *@param o object to be compared (ideally an Firemon object)
    *@return boolean value true only if appropriate conditions are met.
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Firemon)) {
            return false;
        }
        boolean firemoneFlag = false;
        Firemon firy = (Firemon) o;
        if (firy.knowledgeLevel == knowledgeLevel) {
            firemoneFlag = true;
        } else {
            firemoneFlag = false;
        }
        return firemoneFlag && super.equals(o);
    }

    /**
    *This method returns a String describing the Firemon.
    @return a modified string describing the Firemon.
    */
    public String toString() {
        String retStr = super.toString();
        return retStr + " I am a Firemon, and I have " + knowledgeLevel +  " knowledge.";
    }
}