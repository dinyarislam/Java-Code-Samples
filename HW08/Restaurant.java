// I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
*This class represents an Restaurant object
*@author Dinyar Islam
*@version 1.0
*/

public class Restaurant {
    private String name;
    private Location location;
    public static final double DELIVERY_FEE = 0.2;
    private Food[] menu;

    /**
    *Creates a Restaurant
    *@param name the name of the restaurant
    *@param x the x coordinate of a restaurant's location
    *@param y the y coordinate of a restaurant's location
    */
    public Restaurant(String name, double x, double y) throws FileNotFoundException {
        this(name, new Location(x, y));
    }

    /**
    *Creates a Restaurant
    *@param name the name of the restaurant
    *@param location the location of the restaurant
    */
    public Restaurant(String name, Location location) throws FileNotFoundException {
        this.name = name;
        this.location = location;
        Scanner fileScan = null;
        String line;
        File fileIn = new File("restaurants.csv");
        int fileSize = 0;
        boolean flag = false;
        String[] tokens;
        try {
            fileScan = new Scanner(fileIn);
            while (fileScan.hasNextLine() && !flag) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                if ((tokens[0].contains("RESTAURANT"))
                    && (name.equals(tokens[1].trim()))
                    && (location.getXCoordinate() == Double.valueOf(tokens[2].trim()))
                    && (location.getYCoordinate() == Double.valueOf(tokens[3].trim()))) {
                    flag = true;
                    line = fileScan.nextLine();
                    tokens = line.split(",");
                    while (!(tokens[0].contains("RESTAURANT")) && (fileScan.hasNextLine())) {
                        fileSize++;
                        line = fileScan.nextLine();
                        tokens = line.split(",");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        Food[] temp = new Food[fileSize];
        double fPrice = 0.00;
        flag = false;
        try {
            fileScan = new Scanner(fileIn);
            int i = 0;
            while (fileScan.hasNextLine() && !flag) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                if ((tokens[0].contains("RESTAURANT"))
                    && (name.equals(tokens[1].trim()))
                    && (location.getXCoordinate() == Double.valueOf(tokens[2].trim()))
                    && (location.getYCoordinate() == Double.valueOf(tokens[3].trim()))) {
                    flag = true;
                    line = fileScan.nextLine();
                    tokens = line.split(",");
                    while (!(tokens[0].contains("RESTAURANT")) && (fileScan.hasNextLine())) {
                        fPrice = Double.valueOf(tokens[2].trim());
                        temp[i] = new Food(tokens[0].trim(), Integer.valueOf(tokens[1].trim()), fPrice);
                        line = fileScan.nextLine();
                        tokens = line.split(",");
                        i++;
                    }
                }
            }
            if (!flag) {
                throw new InvalidRestaurantException();
            } else {
                menu = new Food[fileSize];
                for (int k = 0; k <= fileSize - 1; k++) {
                    if (temp[k] != null) {
                        this.menu[k] = temp[k];
                    }
                }
            }
        } catch (FileNotFoundException excp) {
            System.out.println("Invalid File");
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }

    /**
    *This method prints out the receipt based on the customer’s food orders
    *@param customer the customer ordering
    *@param delivery whether customer has opted for delivery or not
    */
    public void printReceipt(Customer customer, boolean delivery) {
        String fName = customer.getName() + "_" + name + ".txt";
        File fileOut = new File("restaurants.csv");
        PrintWriter filePrint = null;
        /*
        Food Burger = new Food("Burger", 1, 17.88);
        Food Fries = new Food("Fries", 1, 9.99);
        Food Cola = new Food("Cola", 1, 3.99);
        Food[] orderArr = {Burger , Fries, Cola};
        */
        Food[] orderArr = new Food[customer.getOrdersSize()];
        for (int t = 0; t <= customer.getOrdersSize() - 1; t++) {
            orderArr[t] = customer.getOrdersItem(t);
        }

        if (orderArr.length > 0) {
            double delCost = 0.00;
            if (delivery) {
                delCost = DELIVERY_FEE * location.calcDistance(customer.getLocation());
            }
            double foodPrice;
            double subtotal = 0.00;
            double total;
            String tempName;
            try {
                fName = customer.getName() + "_" + name;
                tempName = fName + ".txt";
                fileOut = new File(tempName);
                while (fileOut.exists()) {
                    fName = fName + "-";
                    tempName = fName + ".txt";
                    fileOut = new File(tempName);
                }
                filePrint = new PrintWriter(fileOut);
                filePrint.println("Receipt");
                filePrint.println(name);
                filePrint.println(location.getXCoordinate() + " , " + location.getYCoordinate());
                for (int a = 0; a <= orderArr.length - 1; a++) {
                    foodPrice = orderArr[a].getPrice();
                    subtotal = subtotal + foodPrice;
                    filePrint.println(orderArr[a].getName() + ", $" + String.format("%.2f", foodPrice));
                }
                if (delivery) {
                    filePrint.println("Subtotal: $" + subtotal);
                    filePrint.println("Delivery: $" + String.format("%.2f", delCost));
                    total = subtotal + delCost;
                } else {
                    total = subtotal;
                }
                filePrint.println("Total: $" + String.format("%.2f", total));
                filePrint.println("Thank you for dining with us!");
            } catch (FileNotFoundException excp) {
                System.out.println("Invalid File");
            } finally {
                if (filePrint != null) {
                    filePrint.close();
                }
            }
            customer.setCurrent(null);
            customer.deleteOrders();
        }
    }

    /**
    *Getter method for menu array item
    *@param t index of array element
    *@return menu array item
    */
    public Food getMenuItem(int t) {
        return menu[t];
    }

    /**
    *Getter method for menu array length
    *@return menu array length
    */
    public int getMenuSize() {
        return menu.length;
    }

    /*
    public static void main(String[] args) throws FileNotFoundException {
        Restaurant rest = new Restaurant("Chipotle", -20.3, 50.7);
        Customer cust = new Customer("Jack", 23.33, 33.44);
        rest.printReceipt(cust, true);
    }
    */
}