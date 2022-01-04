// I worked on the homework assignment alone, using only course materials.


/**
*This class is a subclass of the LibraryItem class and represents an Magazine object and
*also implements the Summarizable interface.
*@author Dinyar Islam
*@version 1.0
*/
public class Magazine extends LibraryItem implements Summarizable {
    private String coverDescription;

    /**
    *Creates a Magazine (constructor).
    *@param title the title of the magazine
    *@param libraryCode a code given to a magazine that will be used to compare and sort
    *LibraryItems
    *@param coverDescription a string that represents the short description of the magazine
    */
    public Magazine(String title, int libraryCode, String coverDescription) {
        super(title, libraryCode);
        this.coverDescription = coverDescription;
    }

    /**
    *The method returns the String summary.
    *@return a string that gives a summary of the magazine
    */
    public String summarize() {
        return super.summarize() + "The cover looks like " + coverDescription + ".";
    }
}