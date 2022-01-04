// I worked on the homework assignment alone, using only course materials.

/**
*This class is a subclass of Pet that represents a Dog object
*@author Dinyar Islam
*@version 1.0
*/
public class Dog extends Pet implements Treatable {
    private String breed;

    /**
    *Creates a Dog (constructor)
    *@param name the name of the Dog
    *@param newAge the age of the Dog
    *@param newPainLevel the pain level of the Dog
    *@param breed the breed of the Dog
    */
    public Dog(String name, int newAge, int newPainLevel, String breed) {
        super(name, newAge, newPainLevel);
        this.breed = breed;
    }

    /**
    *Create a Dog (constructor)
    *@param breed the breed of the Dog
    */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }

    /**
    *This method that represents this Dog playing with another Dog.
    *@param p another pet object to play with
    */
    @Override
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            int oldPainLevel1 = super.getPainLevel();
            int newPainLevel1 = oldPainLevel1 - 3;
            super.setPainLevel(newPainLevel1);
            String bStr1 = "Woof! I love playing with other dogs so much that ";
            String bStr2 = "my pain level went from " + oldPainLevel1 + " to " + newPainLevel1;
            System.out.println(bStr1 + bStr2);
        } else if (p instanceof Cat) {
            Cat kitty = (Cat) p;
            if (!(kitty.getHasStripes())) {
                int oldPainLevel2 = super.getPainLevel();
                int newPainLevel2 = oldPainLevel2 - 1;
                super.setPainLevel(newPainLevel2);
                String aStr1 = "Woof. Cats without stripes are okay since ";
                String aStr2 = "my pain level went from " + oldPainLevel2 + " to " + newPainLevel2;
                System.out.println(aStr1 + aStr2);
            } else {
                int oldPainLevel3 = super.getPainLevel();
                int newPainLevel3 = oldPainLevel3 + 2;
                super.setPainLevel(newPainLevel3);
                System.out.println("AHHH! I thought you were a tiger!");
            }
        }
    }

    /**
    *This method improves the condition of the Dog by decreasing its painLevel.
    */
    @Override
    public void treat() {
        super.setPainLevel(super.getPainLevel() - 3);
    }

    /**
    *This method prints out “bark bark”
    */
    public void bark() {
        System.out.println("bark bark");
    }

    /**
    *The method returns a string describing the Dog.
    *@return a string describing the Dog
    */
    @Override
    public String toString() {
        String retStr1 = "My name is " + super.getName() + ", I am " + super.getAge() + ", and I am a " + breed + ".";
        String retStr2 = " On a scale of one to ten my pain level is " + super.getPainLevel() + ".";
        String retStr3 = " My age in human years is ";
        return retStr1 + retStr2 + retStr3 + Treatable.convertDogToHumanYears(super.getAge()) + ".";
    }

    /**
    *This method compares two Dogs such that two Dogs are equal
    *if they have the same name, age, and painLevel.
    *@param o the other object, ideally a Dog, for comparison
    *@return a boolean value based on whether the two Dogs are equal or not
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog)) {
            return false;
        }
        Dog doggo = (Dog) o;
        return super.equals(o) && (breed.equals(doggo.breed));
    }

    /**
    *Getter method for the Dog's name
    *@return the name of the dog
    */
    public String getDogName() {
        String dogName = super.getName();
        return dogName;
    }
}