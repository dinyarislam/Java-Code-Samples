// I worked on the homework assignment alone, using only course materials.
/**
*This class represents an Location object
*@author Dinyar Islam
*@version 1.0
*/

public class Location {
    private double x;
    private double y;

    /**
    *Creates a Location
    *@param x the x coordinate of a location
    *@param y the y coordinate of a location
    */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
    *the method calculates the distance between the two locations
    *@param location a second location object for calculating distance
    *@return the distance between two locations
    */
    public double calcDistance(Location location) {
        double distSqr = (x - location.x) * (x - location.x) + (y - location.y) * (y - location.y);
        return Math.sqrt(distSqr);
    }

    /**
    *Getter method for x
    *@return the x coordinate of a location
    */
    public double getXCoordinate() {
        return x;
    }

    /**
    *Getter method for y
    *@return the y coordinate of a location
    */
    public double getYCoordinate() {
        return y;
    }
}