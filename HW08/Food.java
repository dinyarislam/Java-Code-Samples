// I worked on the homework assignment alone, using only course materials.
/**
*This class represents an Food object
*@author Dinyar Islam
*@version 1.0
*/

public class Food {
    private String name;
    private int quantity;
    private double price;

    /**
    *Creates a Food
    *@param name the name of the food
    *@param quantity the quantity of the food as a number
    *@param price the proce of the food
    */
    public Food(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
    *the method returns a string describing the food
    *@return a string describing the food
    */
    public String toString() {
        return name + " costs $" + price + ", and there are " + quantity + " remaining.";
    }

    /**
    *Getter method for name
    *@return the name of the food
    */
    public String getName() {
        return name;
    }

    /**
    *Getter method for price
    *@return the price of the food
    */
    public double getPrice() {
        return price;
    }

    /**
    *Getter method for quantity
    *@return the quantity of the food
    */
    public int getQuantity() {
        return quantity;
    }

    /**
    *Setter method for quantity
    *@param quantity the quantity of food to be set
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}