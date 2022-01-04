// I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
*This class represents an Customer object
*@author Dinyar Islam
*@version 1.0
*/

public class Customer {
    private String name;
    private Location location;
    private Food[] orders;
    private Restaurant current;

    /**
    *Creates a Customer
    *@param name the name of the customer
    *@param x the x coordinate of a customer's location
    *@param y the y coordinate of a customer's location
    */
    public Customer(String name, double x, double y) {
        this.name = name;
        this.location = new Location(x, y);
        orders = new Food[0];
    }

    /**
    *the method allows the customer to order food from a restaurant
    *@param restaurant the restaurant the customer wishes to order from
    *@param food the food the customer wants to order
    */
    public void order(Restaurant restaurant, String food) {
        if (food != null) {
            String[] foodOrder = food.split("\n");
            Food[] foodList = new Food[restaurant.getMenuSize()];
            for (int t = 0; t <= restaurant.getMenuSize() - 1; t++) {
                foodList[t] = restaurant.getMenuItem(t);
            }
            int length = 0;
            for (int m = 0; m <= foodOrder.length - 1; m++) {
                if (foodOrder[m] != null) {
                    length++;
                }
            }
            /*
            for (Food f: foodList) {
                System.out.println(f);
            }
            for (String f: foodOrder) {
                System.out.println(f);
            }
            */
            if ((orders.length != 0) && !(current.equals(restaurant))) {
                System.out.println("You have an active order at " + current + "!");
            } else {
                if (orders.length == 0) {
                    current = restaurant;
                }
                double fPrice = 0.00;
                Food[] temp = new Food[length];
                if (((current.equals(restaurant))
                    && (restaurant != null))) {
                    boolean flag = false;
                    for (int i = 0; i <= foodOrder.length - 1; i++) {
                        for (int j = 0; j <= foodList.length - 1; j++) {
                            //System.out.println(flag);
                            String[] item = foodOrder[i].split(",");
                            fPrice = Double.parseDouble((item[1]).substring(1, item[1].length()));
                            /*
                            for (String f: item) {
                                System.out.println(f);
                            }
                            */
                            if ((item[0].equals(foodList[j].getName()))
                                && (fPrice == foodList[j].getPrice())) {
                                if (foodList[j].getQuantity() > 0) {
                                    /*
                                    System.out.println(item[0]);
                                    */
                                    foodList[j].setQuantity(foodList[j].getQuantity() - 1);
                                    temp[i] = new Food(item[0], 1, fPrice);
                                } else {
                                    throw new UnavailableException();
                                }
                            }
                        }
                    }
                }
                if (orders.length == 0) {
                    orders = new Food[temp.length];
                    for (int p = 0; p <= temp.length - 1; p++) {
                        this.orders[p] = temp[p];
                        //System.out.println("added tacos:" + temp[p]);
                    }
                } else {
                    int oldSize = orders.length;
                    int newSize = oldSize + temp.length;
                    Food[] activeOrder = new Food[oldSize];
                    for (int q = 0; q <= oldSize - 1; q++) {
                        activeOrder[q] = orders[q];
                    }
                    orders = new Food[newSize];
                    for (int r = 0; r <= oldSize - 1; r++) {
                        orders[r] = activeOrder[r];
                    }
                    for (int s = oldSize; s <= newSize - 1; s++) {
                        orders[s] = temp[s - oldSize];
                    }
                }
            }
        }
    }

    /**
    *This method recommends the restaurant that is the closest to the customer by location
    */
    public void recommendation() {
        Scanner fileScan = null;
        String restName = null;
        double lowDist = -1.00;
        File fileIn = new File("restaurants.csv");
        try {
            fileScan = new Scanner(fileIn);
            String line = null;
            String[] tokens;
            double xCoor1 = location.getXCoordinate();
            double yCoor1 = location.getYCoordinate();
            double dist;
            double xCoor2;
            double yCoor2;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                if (tokens[0].equals("RESTAURANT")) {
                    xCoor2 = Double.parseDouble(tokens[2].trim());
                    yCoor2 = Double.parseDouble(tokens[3].trim());
                    dist = Math.sqrt(((xCoor1 - xCoor2) * (xCoor1 - xCoor2)) + ((yCoor1 - yCoor2) * (yCoor1 - yCoor2)));
                    if ((dist < lowDist) || (lowDist == -1.00)) {
                        lowDist = dist;
                        restName = tokens[1];
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid File");
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
        System.out.println(restName + " is recommended for you!");
    }

    /*
    public static void main(String[] args) throws FileNotFoundException {
        Customer cust = new Customer("Jack", 23.33, 33.44);
        Restaurant rest = new Restaurant("Chipotle", -20.3, 50.7);
        Food Burger = new Food("Burger", 1, 17.88);
        Food Fries = new Food("Fries", 1, 9.99);
        Food Cola = new Food("Cola", 1, 3.99);
        Food[] orders = {Burger , Fries, Cola};
    }
    */

    /**
    *Getter method for orders array item
    *@param t index of array element
    *@return orders array item
    */
    public Food getOrdersItem(int t) {
        return orders[t];
    }

    /**
    *Getter method for orders array length
    *@return orders array length
    */
    public int getOrdersSize() {
        return orders.length;
    }

    /**
    *Getter method for name
    *@return customer's name
    */
    public String getName() {
        return name;
    }

    /**
    *Getter method for location
    *@return customer's location
    */
    public Location getLocation() {
        return location;
    }

    /**
    *Setter method for current
    *@param current the current restaurant
    */
    public void setCurrent(Restaurant current) {
        this.current = current;
    }

    /**
    *Helper method for deleting orders
    */
    public void deleteOrders() {
        this.orders = new Food[0];
    }
}