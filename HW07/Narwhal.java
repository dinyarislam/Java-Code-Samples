// I worked on the homework assignment alone, using only course materials.

/**
*This class is a subclass of Pet thatrepresents a Narwhal object
*@author Dinyar Islam
*@version 1.0
*/
public class Narwhal extends Pet {
    private int hornLength;

    /**
    *Creates a Narwhal (constructor)
    *@param name the name of the Narwhal
    *@param newAge the age of the Narwhal
    *@param newPainLevel the pain level of the Narwhal
    *@param hornLength the length of the Narwhal's horn
    */
    public Narwhal(String name, int newAge, int newPainLevel, int hornLength) {
        super(name, newAge, newPainLevel);
        this.hornLength = hornLength;
    }

    /**
    *Create a Cat (constructor)
    */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    /**
    *This method represents this Narwhal playing with another Narwhal.
    *@param p another pet object to play with Narwhal
    */
    @Override
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            System.out.println("Who needs dogs and cats when we have each other");
            super.setPainLevel(super.getPainLevel() - 2);
        } else {
            System.out.println("I live in the ocean so I can’t play with you");
            super.setPainLevel(super.getPainLevel() + 1);
        }
    }

    /**
    *The method returns a string describing the Narwhal.
    *@return a string describing the Narwhal
    */
    @Override
    public String toString() {
        String retStr = super.toString();
        return retStr + " I have a horn that is " + hornLength + " feet long.";
    }

    /**
    *This method compares two Narwhals such that two Narwhals are equal
    *if they have the same name, age, and painLevel.
    *@param o the other object, ideally a Narwhal, for comparison
    *@return a boolean value based on whether the two Narwhals are equal or not
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Narwhal)) {
            return false;
        }
        Narwhal naro = (Narwhal) o;
        return super.equals(o) && (hornLength == naro.hornLength);
    }
}