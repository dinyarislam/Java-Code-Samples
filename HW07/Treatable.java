// I worked on the homework assignment alone, using only course materials.

/**
*This interface guarantees an Object is treatable
*@author Dinyar Islam
*@version 1.0
*/
public interface Treatable {

    /**
    *This static method returns the dog’s age in human years.
    *@param dogAge the age of the dog
    *@return the equivalent human age calculated
    */
    static int convertDogToHumanYears(int dogAge) {
        int humanAge = (int) (16 * Math.log(dogAge) + 31);
        return humanAge;
    }

    /**
    *This static method returns the cat’s age in human years.
    *@param catAge the age of the cat
    *@return the equivalent human age calculated
    */
    static int convertCatToHumanYears(int catAge) {
        int humanAge = (int) (9 * Math.log(catAge) + 18);
        return humanAge;
    }

    /**
    *dogAgeTreatable object in some way.
    */
    void treat();
}