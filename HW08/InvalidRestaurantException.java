// I worked on the homework assignment alone, using only course materials.
/**
*This class represents an InvalidRestaurantException object
*@author Dinyar Islam
*@version 1.0
*/

public class InvalidRestaurantException extends RuntimeException {
    /**
    *Creates an InvalidRestaurantException
    *@param message a string representing the error message
    */
    public InvalidRestaurantException(String message) {
        super(message);
    }

    /**
    *Creates an InvalidRestaurantException
    */
    public InvalidRestaurantException() {
        super("There is no restaurant with that name and location!");
    }
}