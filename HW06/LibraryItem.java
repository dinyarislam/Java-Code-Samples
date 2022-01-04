// I worked on the homework assignment alone, using only course materials.

/**
*This abstract class represents a LibraryItem object and it implements the Summarizable
*and Comparable interfaces.
*@author Dinyar Islam
*@version 1.0
*/
public abstract class LibraryItem implements Summarizable, Comparable<LibraryItem> {
    private String title;
    private int libraryCode;

    /**
    *Creates a LibraryItem (constructor)
    *@param title the title of the library item
    *@param libraryCode a code given to a LibraryItem that will be used to compare and sort
    *items
    */
    public LibraryItem(String title, int libraryCode) {
        this.title = title;
        this.libraryCode = libraryCode;
    }

    /**
    *The method returns the String summary.
    *@return a string that gives a summary of the object
    */
    public String summarize() {
        return "This item is called" + title + ".";
    }

    /**
    *This method overrides the compareTo method.
    *@param other another LibraryItem for comparison
    *@return an int which can be negative, positive or zero based on whether one
    *LibraryItem is smaller or larger or both objects are equal, respectively.
    */
    @Override
    public int compareTo(LibraryItem other) {
        return -(libraryCode - other.libraryCode);
    }

    /**
    *Getter mathod for private variable
    *@return the libraryCode for the LibraryItem.
    */
    public int getLibraryCode() {
        return libraryCode;
    }
}