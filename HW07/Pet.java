// I worked on the homework assignment alone, using only course materials.

/**
*This class represents a Pet object
*@author Dinyar Islam
*@version 1.0
*/
public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;

    /**
    *Creates a Pet (constructor)
    *@param name the name of the Pet
    *@param newAge the age of the Pet
    *@param newPainLevel the pain level of the Pet
    */
    public Pet(String name, int newAge, int newPainLevel) {
        this.name = name;
        if (newAge > 100) {
            age = 100;
        } else if (newAge < 1) {
            age = 1;
        } else {
            age = newAge;
        }
        if (newPainLevel > 10) {
            painLevel = 10;
        } else if (newPainLevel < 1) {
            painLevel = 1;
        } else {
            painLevel = newPainLevel;
        }
    }

    /**
    *This abstract method represents this Pet playing with another Pet.
    *@param p another pet object to play with
    */
    public abstract void playWith(Pet p);

    /**
    *The method returns a string describing the Pet.
    *@return a string describing the Pet
    */
    public String toString() {
        String str1 = "My name is " + name + ", and I am " + age + ".";
        return str1 + " On a scale of one to ten my pain level is " + painLevel + ".";
    }

    /**
    *This method compares two Pets such that two Pets are equal
    *if they have the same name, age, and painLevel.
    *@param o the other object, ideally a Pet, for comparison
    *@return a boolean value based on whether the two Pets are equal or not
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet otherPet = (Pet) o;
        return (name.equals(otherPet.name)) && (age == otherPet.age) && (painLevel == otherPet.painLevel);
    }

    /**
    *Getter method for painLevel
    *@return the painLevel of a Pet
    */
    public int getPainLevel() {
        return painLevel;
    }

    /**
    *Setter method for painLevel
    *@param painLevel the painLevel to be set
    */
    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    /**
    *Getter method for age
    *@return the age of the Pet
    */
    public int getAge() {
        return age;
    }

    /**
    *Getter method for name
    *@return the name of the Pet
    */
    public String getName() {
        return name;
    }
}