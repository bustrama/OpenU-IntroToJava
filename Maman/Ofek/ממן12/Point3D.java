/**
 *
 * This class represents a point in 3 dimentional coordinate system.
 *
 * @author Ofek Marks
 * <p>ID: 325131886
 * @version 6.4.2019
 */
public class Point3D
{
    private double _x; // The X coordinate of the point
    private double _y; // The Y coordinate of the point
    private double _z; // The Z coordinate of the point
    
    private final double INITIAL_VALUE = 0; // The default value for a point's coordinate
    
    /**
     * Constructs and initializes a Point3D to (0,0,0).
     */
    public Point3D()
    {
        // The method inputs the initial value for each coordinate
        _x = INITIAL_VALUE;
        _y = INITIAL_VALUE;
        _z = INITIAL_VALUE;
    }
    
    /**
     * Constructs and initializes a Point3D from the specified x, y, z coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Point3D(double x, double y, double z)
    {
        _x = x;
        _y = y;
        _z = z;
    }
    
    /**
     * Constructs and initializes a Point3D from the specified Point3D.
     * @param other the Point3D which the new instance initialization will be based on
     */
    public Point3D(Point3D other)
    {
        this(other._x, other._y, other._z);  // This constructor essentially supposed to do the same operations as the contructor above, with the coordinates of the given point
    }
    
    /**
     * Returns the x coordinate
     * @return The value of the x coordinate
     */
    public double getX()
    {
        return _x;
    }
    
    /**
     * Returns the y coordinate
     * @return The value of the y coordinate
     */
    public double getY()
    {
        return _y;
    }
    
    /**
     * Returns the z coordinate
     * @return The value of the z coordinate
     */
    public double getZ()
    {
        return _z;
    }
    
    /**
     * Sets the x coordinate to the given x
     * @param num the x value to set
     */
    public void setX(double num)
    {
        _x = num;
    }
    
    /**
     * Sets the y coordinate to the given y
     * @param num the y value to set
     */
    public void setY(double num)
    {
        _y = num;
    }
    
    /**
     * Sets the z coordinate to the given z
     * @param num the z value to set
     */
    public void setZ(double num)
    {
        _z = num;
    }
    
    /**
     * Returns a string representation of this Point3D.
     * @return A string that describes the Point3D object
     */
    public String toString()
    {
        return "(" + _x + "," + _y + "," + _z + ")"; // Will return, for example: "(5.5,67.3,-33.7)"
    }
    
    /**
     * Determines whether or not two points are equal.
     * @param other a Point3D object to be compared with this Point3D
     * @return True if the points' attributes are equal and false otherwise
     */
    public boolean equals(Point3D other)
    {
        final double TOLERANCE = 0.0000001; // The floating point attributes are essentially equal even if the have a little difference (Ex: does 3.123123123 != 3.123123124 ?)
        // If all the attributes of the points are equal, the points are equal
        return Math.abs(_x - other._x) < TOLERANCE && Math.abs(_y - other._y) < TOLERANCE && Math.abs(_z - other._z) < TOLERANCE;
    }
    
    /**
     * Checks if this point is above the other point.
     * @param other The point to check whether this point is above it
     * @return True if this point is above the other point, false otherwise
     */
    public boolean isAbove(Point3D other)
    {
        return _z > other._z; // If a point is above another point, its Z value is bigger than the other's Z value
    }
    
    /**
     * Checks if this point is under the other point.
     * @param other The point to check whether this point is under it
     * @return True if this point is under the other point, false otherwise
     */
    public boolean isUnder(Point3D other)
    {
        return other.isAbove(this); // A point is under another point if the other point is above it
    }
    
    /**
     * Checks if this point is to the left of the other point.
     * @param other The point to check whether this point is left of it
     * @return True if this point is to the left of the other point, false otherwise
     */
    public boolean isLeft(Point3D other)
    {
        return _y < other._y; // If a point is to the left of another point, its Y value is less than the other's Y value
    }
    
    /**
     * Checks if this point is to the right of the other point.
     * @param other The point to check whether this point is right of it
     * @return True if this point is to the right of the other point, false otherwise
     */
    public boolean isRight(Point3D other)
    {
        return other.isLeft(this); // A point is to the right of another point if the other point is to the left of it
    }
    
    /**
     * Checks if this point is behind the other point.
     * @param other The point to check whether this point behind it
     * @return True if this point is behind the other point, false otherwise
     */
    public boolean isBehind(Point3D other)
    {
        return _x < other._x; // If a point is behind another point, its X value is less than the other's X value
    }
    
    /**
     * Checks if this point is in front of the other point.
     * @param other The point to check if this point is in front of it
     * @return True if this point is in front of the other point, false otherwise
     */
    public boolean isInFrontOf(Point3D other)
    {
        return other.isBehind(this); // A point is in front of another point if the other point is behind it
    }
    
    /**
     * Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along the y axis and by dz along the z axis 
     * so that it now represents the Point3D in the following 3D coordintes (x+dx,y+dy,z+dz).
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y vlaue
     * @param dz the addtion for coordinate z value
     */
    public void move(double dx, double dy, double dz)
    {
       _x += dx;
       _y += dy;
       _z += dz;
    }
    
    /**
     * Returns the distance between this point and other point p.
     * @param p the other point
     * @return The distance between the points
     */
    public double distance(Point3D p)
    {
        // according to the formula: d(point1, point2)^2 = (x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2
        return Math.sqrt(Math.pow(_x - p._x, 2) + Math.pow(_y - p._y, 2) + Math.pow(_z - p._z, 2));
    }
}