/**
 *  Matala 12.1 - Using a class to represent a certain point on 3D coordinate system
 *
 * @author Ben Brandes
 * @version 2019b
 */

public class Point3D{
    // Private members
    private double _x;
    private double _y;
    private double _z;
    private final int DEFAULT_VAL = 0;

    /**
     * Constructs and initializes a Point3D to (0,0,0).
     */
    public Point3D() {
        this._x = DEFAULT_VAL;
        this._y = DEFAULT_VAL;
        this._z = DEFAULT_VAL;
    }


    /**
     * Constructs and initializes a Point3D from the specified xyz coordinates.
     * @param x x axis value
     * @param y y axis value
     * @param z z axis value
     */
    public Point3D(double x, double y, double z) {
        this._x = x;
        this._y = y;
        this._z = z;
    }

    /**
     * Constructs and initializes a Point3D from the specified Point3D.
     * @param point point to be copied
     */
    public Point3D(Point3D point) {
        this._x = point.getX();
        this._y = point.getY();
        this._z = point.getZ();
    }

    /**
     * return the value of the x coordinate
     * @return the value of the x coordinate
     */
    public double getX(){
        return this._x;
    }

    /**
     * sets the x coordinate to the given x
     * @param num x value to set
     */
    public void setX(double num){
        this._x = num;
    }

    /**
     * return the value of the y coordinate
     * @return the value of the y coordinate
     */
    public double getY(){
        return this._y;
    }

    /**
     * sets the y coordinate to the given y
     * @param num y value to set
     */
    public void setY(double num){
        this._y = num;
    }

    /**
     * return the value of the z coordinate
     * @return  the value of the z coordinate
     */
    public double getZ(){
        return this._z;
    }

    /**
     * sets the z coordinate to the given z
     * @param num z value to set
     */
    public void setZ(double num){
        this._z = num;
    }

    /**
     * Returns a string representation of this Point3D.
     * @return a string representation of this Point3D.
     */
    public String toString(){
        return "(" + this._x + "," + this._y + "," + this._z + ")";
    }

    /**
     * Determines whether or not two points are equal.
     * @param other a Point3D object to be compared with this Point3D
     * @return whether or not two points are equal
     */
    public boolean equals(Point3D other){
        return(this._x == other.getX() && this._y == other.getY() && this._z == other.getZ());
    }

    /**
     * Checks if the current Point3D above the passed Point3D in Z axis
     * @param other The point to check whether this point is above it
     * @return true if this point is above the other point, false otherwise
     */
    public boolean isAbove(Point3D other){
        return (this._z > other.getZ());
    }

    /**
     * Checks if the current Point3D under the passed Point3D in Z axis
     * @param other The point to check whether this point is under it
     * @return true if this point is under the other point, false otherwise
     */
    public boolean isUnder(Point3D other){
        return other.isAbove(this);
    }

    /**
     * Checks if the current Point3D is left to the passed Point3D in Y axis
     * @param other The point to check whether this point is left of it
     * @return true if this point is to the left of the other point, false otherwise
     */
    public boolean isLeft(Point3D other){
        return (other.getY() > this._y);
    }

    /**
     * Checks if the current Point3D is right to the passed Point3D in Y axis
     * @param other The point to check whether this point is right of it
     * @return true if this point is to the right of the other point, false otherwise
     */
    public boolean isRight(Point3D other){
        return other.isLeft(this);
    }

    /**
     * Checks if the current Point3D is behind the passed Point3D in X axis
     * @param other The point to check whether this point behind it
     * @return true if this point is behind the other point, false otherwise
     */
    public boolean isBehind(Point3D other){
        return (other.getX() > this._x);
    }

    /**
     * Checks if the current Point3D is in front of the passed Point3D in X axis
     * @param other The point to check if this point is in front of it
     * @return true if this point is in front of the other point, false otherwise
     */
    public boolean isInFrontOf(Point3D other){
        return other.isBehind(this);
    }

    /**
     * Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along the y axis and dz
     * along the z axis so that it now represents the Point3D in the following 3D coordinates (x+dx,y+dy,z+dz).
     * @param dx the addition for coordinate x value
     * @param dy the addition for coordinate y value
     * @param dz the addition for coordinate z value
     */
    public void move(double dx, double dy, double dz){
        this._x += dx;
        this._y += dy;
        this._z += dz;
    }

    /**
     * return the distance between this point and other point p.
     * @param p the other point
     */
    public double distance(Point3D p){
        return (Math.sqrt((Math.pow(p.getX() - this._x, 2)) + (Math.pow(p.getY() - this._y, 2)) + (Math.pow(p.getZ() - this._z, 2))));
    }
}