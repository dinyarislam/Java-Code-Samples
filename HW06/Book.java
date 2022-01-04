// I worked on the homework assignment alone, using only course materials.

/**
*This class is a subclass of the LibraryItem class and represents an Book object and
*also implements the Summarizable interface.
*@author Dinyar Islam
*@version 1.0
*/
public class Book extends LibraryItem implements Summarizable {
    private String backcoverBlurb;
    private int pages;

    /**
    *Creates a Book (constructor).
    *@param title the title of the book
    *@param libraryCode a code given to a book that will be used to compare and sort
    *LibraryItems
    *@param backcoverBlurb a String that represents a short description of the Book.
    *@param pages an int that represents the number of pages the Book has.
    */
    public Book(String title, int libraryCode, String backcoverBlurb, int pages) {
        super(title, libraryCode);
        this.backcoverBlurb = backcoverBlurb;
        this.pages = pages;
    }

    /**
    *The method returns the String summary.
    *@return a string that gives a summary of the book
    */
    public String summarize() {
        return super.summarize() + "The book is " + pages + "pages long." + backcoverBlurb + ".";
    }
}