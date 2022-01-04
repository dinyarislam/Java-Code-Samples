// I worked on the homework assignment alone, using only course materials.
import java.util.Arrays;

/**
*This class represents a Library object
*@author Dinyar Islam
*@version 1.0
*/
public class Library {
    private static LibraryItem[] bookshelf;

    /**
    *Creates a Library (constructor)
    */
    public Library() {
        bookshelf = new LibraryItem[0];
    }

    /**
    *Creates a Library (constructor)
    *@param bookshelf an array of LibraryItem objects
    */
    public Library(LibraryItem[] bookshelf) {
        this.bookshelf = bookshelf;
        Arrays.sort(bookshelf);
    }

    /**
    * This method prints out the summaries of all LibraryItems in the bookshelf for the Library.
    */
    public static void browseLibraryItems() {
        for (int i = 0; i <= bookshelf.length - 1; i++) {
            System.out.println(bookshelf[i].getLibraryCode() + ": " + bookshelf[i].summarize());
        }
    }

    /**
    *This method creates a new array that copies over all the previous elements as
    *well as adds the new item.
    *@param newItem new LibraryItem to be added to the bookshelf
    */
    public static void addLibraryItem(LibraryItem newItem) {
        LibraryItem[] newShelf = new LibraryItem[bookshelf.length + 1];
        for (int k = 0; k <= bookshelf.length - 1; k++) {
            newShelf[k] = bookshelf[k];
        }
        newShelf[newShelf.length - 1] = newItem;
        bookshelf = new LibraryItem[newShelf.length];
        for (int l = 0; l <= bookshelf.length - 1; l++) {
            bookshelf[l] = newShelf[l];
        }
        Arrays.sort(bookshelf);
    }

    /**
    *This method searches the bookshelf with a given code returns the corresponding library item.
    *@param code library code of the item to be searched and returned
    *@return the library item corresponding to the code sent
    */
    public static LibraryItem getLibraryItem(int code) {
        LibraryItem retItem = null;
        for (int j = 0; j <= bookshelf.length - 1; j++) {
            if (bookshelf[j].getLibraryCode() == code) {
                retItem = bookshelf[j];
                break;
            }
        }
        return retItem;
    }

    /**
    *This method  the number of items on the shelf.
    *@return number of items on the shelf i.e. the length of the bookshelf array
    */
    public static int getNumberOfItems() {
        return bookshelf.length;
    }
}