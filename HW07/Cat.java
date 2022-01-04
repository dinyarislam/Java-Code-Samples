// I worked on the homework assignment alone, using only course materials.

/**
*This class is a subclass of Pet thatrepresents a Cat object
*@author Dinyar Islam
*@version 1.0
*/
public class Cat extends Pet implements Treatable {
    private boolean hasStripes;

    /**
    *Creates a Cat (constructor)
    *@param name the name of the Cat
    *@param newAge the age of the Cat
    *@param newPainLevel the pain level of the Cat
    *@param hasStripes whether the cat has stripes or not
    */
    public Cat(String name, int newAge, int newPainLevel, boolean hasStripes) {
        super(name, newAge, newPainLevel);
        this.hasStripes = hasStripes;
    }

    /**
    *Create a Cat (constructor)
    *@param hasStripes whether the cat has stripes or not
    */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }

    /**
    *This method represents this Cat playing with another Cat.
    *@param p another pet object to play with Cat
    */
    @Override
    public void playWith(Pet p) {
        if (p instanceof Cat) {
            Cat kat = (Cat) p;
            if (hasStripes && kat.hasStripes) {
                super.setPainLevel(super.getPainLevel() - 4);
                System.out.println("Meow! I love playing with other cats with the same pattern as me");
            } else {
                super.setPainLevel(super.getPainLevel() - 2);
                System.out.println("Meow! I love playing with other cats without the same pattern as me");
            }
        } else if (p instanceof Dog) {
            super.setPainLevel(super.getPainLevel() + 1);
            Dog doggo = (Dog) p;
            System.out.println("Meow. Go away " + doggo.getDogName() + "! I don’t like playing with Dogs!");
        }
    }

    /**
    *This method improves the condition of the Cat by decreasing its painLevel
    */
    @Override
    public void treat() {
        super.setPainLevel(super.getPainLevel() - 1);
    }

    /**
    *The method returns a string describing the Cat.
    *@return a string describing the Cat
    */
    @Override
    public String toString() {
        String retStr = super.toString();
        return retStr + " My age in human years is " + Treatable.convertDogToHumanYears(super.getAge()) + ".";
    }

    /**
    *This method compares two Cats such that two Cats are equal
    *if they have the same name, age, and painLevel.
    *@param o the other object, ideally a Cat, for comparison
    *@return a boolean value based on whether the two Cats are equal or not
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat kitty = (Cat) o;
        return super.equals(o) && (hasStripes == kitty.hasStripes);
    }

    /**
    *Getter method for hasStripes
    *@return whether the Cat has stripes or not
    */
    public boolean getHasStripes() {
        return hasStripes;
    }
}