// I worked on the homework assignment alone, using only course materials.
/**
*This class represents an UnavailableException object
*@author Dinyar Islam
*@version 1.0
*/

public class UnavailableException extends RuntimeException {
    /**
    *Creates an UnavailableException
    *@param message a string representing the error message
    */
    public UnavailableException(String message) {
        super(message);
    }

    /**
    *Creates an UnavailableException
    */
    public UnavailableException() {
        super();
    }
}