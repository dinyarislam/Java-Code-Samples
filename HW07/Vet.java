// I worked on the homework assignment alone, using only course materials.

/**
*This class represents a Vet object
*@author Dinyar Islam
*@version 1.0
*/
public class Vet {

    /**
    *Static method that prints the toString method of the pet
    *@param pet a Pet object
    */
    public static void inspectPet(Pet pet) {
        if (pet instanceof Dog) {
            Dog doggo = (Dog) pet;
            System.out.println(doggo.toString());
            doggo.bark();
        } else if (pet instanceof Cat) {
            Cat kitty = (Cat) pet;
            System.out.println(kitty.toString());
        } else if (pet instanceof Narwhal) {
            Narwhal naro = (Narwhal) pet;
            System.out.println(naro.toString());
        }
    }

    /**
    *Static method that accepts any Pet object and treats it if it's treatable.
    *@param pet the pet to be treated
    */
    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println("Welcome to the vet " + pet.getName());
            if (pet instanceof Dog) {
                Dog doggy = (Dog) pet;
                doggy.treat();
                System.out.println("Wow what a cute dog!");
                giveDogTreat(doggy);
            } else if (pet instanceof Cat) {
                Cat kat = (Cat) pet;
                kat.treat();
            }
        } else {
            System.out.println("Sorry, we cannot treat " + pet.getName());
        }
    }

    /**
    *Static method that decreases the dog’s pain by 2.
    *@param dog the Dog object to be treated
    */
    public static void giveDogTreat(Dog dog) {
        dog.setPainLevel(dog.getPainLevel() - 2);
    }
}