/**
 * This class represents a three-dimensional box The box is represented by its lower-left-front point and three integers for the length 
 * (x axis), width (y axis) and height (z axis) of the box. the box dimensions must be equal or greater than 1.
 *
 * @author Ofek Marks
 * <p>ID: 325131886
 * @version 6.4.2019
 */
public class Box3D
{
    private Point3D _base; // The bottom-left-front corner of the box
    private int _length; // The length of the box
    private int _width; // The width of the box
    private int _height; // The height of the box
    
    final int INITIAL_VALUE = 1; // The minimal value for the three attributes: _length, _width and _height
    
    /**
     * Constructs and initializes a box with a default base point and all dimensions to 1.
     */
    public Box3D()
    {
        _base = new Point3D(); // Uses the empty constructor in Class Point3D (that creates the default point)
        _length = INITIAL_VALUE;
        _width = INITIAL_VALUE;
        _height = INITIAL_VALUE;
    }
    
    /**
     * Constructs and initializes a box object from a given base point and 3 integers as the dimensions of the Box
     * @param p the base point of the box
     * @param length the length of the box
     * @param width the width of the box
     * @param height the height of the box
     */
    public Box3D(Point3D point, int length, int width, int height)
    {
        _base = new Point3D(point);
        
        // For every given measurement the method checks if it's less that 1, and if so it inputs the value 1 into the matching attribute. Else, the given value is inserted
        _length = (length < INITIAL_VALUE) ? INITIAL_VALUE : length;
        _width = (width < INITIAL_VALUE) ? INITIAL_VALUE : width;
        _height = (height < INITIAL_VALUE) ? INITIAL_VALUE : height;
    }
    
    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     * @param other the box to copy from. Contains the initialization of the base point and all dimentions.
     */
    public Box3D(Box3D box)
    {
        // This constructor essentially supposed to do the same operations as the contructor above, with the attributes of the given Box3D object
        this(box._base, box._length, box._width, box._height);
    }
    
    /**
     * Returns the length dimension
     * @return The length of the box
     */
    public int getLength()
    {
        return _length;
    }
    
    /**
     * Returns the width dimension
     * @return The width of the box
     */
    public int getWidth()
    {
        return _width;
    }
    
    /**
     * Returns the height dimension
     * @return The height of the box
     */
    public int getHeight()
    {
        return _height;
    }
    
    /**
     * Returns the lower-left-front (base) Point3D of the box
     * @return The base point of the box
     */
    public Point3D getBase()
    {
        return new Point3D(_base); // Keeps encapsulation by creating a copy of the given point
    }
    
    /**
     * Sets the length of the box only if the given value is equal or greater than 1.
     * @param num the length to set
     */
    public void setLength(int num)
    {
        if(num >= INITIAL_VALUE) // Only if the given length is valid, the method inputs the value into the attribute
            _length = num;
    }
    
    /**
     * Sets the width of the box only if the given value is equal or greater than 1.
     * @param num the width to set
     */
    public void setWidth(int num)
    {
        if(num >= INITIAL_VALUE) // Only if the given width is valid, the method inputs the value into the attribute
            _width = num;
    }
    
    /**
     * Sets the height of the box only if the given value is equal or greater than 1.
     * @param num the height to set
     */
    public void setHeight(int num)
    {
        if(num >= INITIAL_VALUE) // Only if the given height is valid, the method inputs the value into the attribute
            _height = num;
    }
    
    /**
     * Sets the base point of the box
     * @param otherBase the Point3D to set
     */
    public void setBase(Point3D otherBase)
    {
        _base = new Point3D(otherBase); // Keeps encapsulation by connecting the base point to a different location in the memory, so that other classes couldn't reach it
    }
    
    /**
     * Returns a string representation of this Box3D object.
     * @return A string with the description of the Box3D object
     */
    public String toString()
    {
        // Will return, for example: "The base point is (5.5,67.3,-33.7), length = 12, width = 8, height = 9"
        return "The base point is " + _base.toString() + ", length = " + _length + ", width = " + _width + ", height = " + _height;
    }
    
    /**
     * Determines whether or not the two boxes are equal.
     * @param other a Box3D object to be compared with this Box3D
     * @return True if the boxes' attributes are equal and false otherwise
     */
    public boolean equals(Box3D other)
    {
        // If all the attributes of the boxes are the same, the boxes are equal, uses the equals method from the class Point3D in order to compare the points
        return _base.equals(other._base) && _length == other._length && _width == other._width && _height == other._height;
    }
    
    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) without changing the box dimensions
     * @return The new box in its new location
     * @param dx the addtion for coordinate x value
     * @param dy the addtion for coordinate y vlaue
     * @param dz the addtion for coordinate z value
     */
    public Box3D move(double dx, double dy, double dz)
    {
        Box3D box = new Box3D(this);
        box._base.move(dx, dy, dz); // Uses the move method from class Point3D (in order to move the box, we only have to move the base point of it)
        return box;
    }
    
    /**
     * Calculates and returns the upper-right-back point of this box
     * @return The upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint()
    {
        Point3D point = new Point3D(_base);
        
        // In order to get the up-right-back point we move a copy of the base point: forwards by the width and height (to the top and right) and backwards by the length (to the back)
        point.move(-_length, _width, _height);
        return point;
    }
    
    /**
     * Calculates and returns the center point of the box
     * @return The center point of the box
     */
    public Point3D getCenter()
    {
        Point3D point = new Point3D(_base);
        
        // The center point is in the middle of the box, which means its distance from the base point (For each axis on its own) is half of the measurement for this axis
        point.move(-_length / 2.0, _width / 2.0, _height / 2.0);
        return point;
    }
    
    /**
     * Computes the distance between two boxes based on the distance of their center points.
     * @return The distance between two Box3D objects
     * @param other the box that its distance from this box is checked
     */
    public double distance(Box3D other)
    {
        return getCenter().distance(other.getCenter()); // Uses the distance method from the class Point3D, on the centers of the boxes
    }
    
    /**
     * Computes the volume of the box.
     * @return The volume of the Box3D object
     */
    public int getVolume()
    {
        return _length * _width * _height; // Uses the formula of the volume of a box: Volume = Length * Width * Height
    }
    
    /**
     * Computes the surface area of a box.
     * @return The surface area of the Box3D object
     */
    public int getSurfaceArea()
    {
        // Because there are 3 pairs of identical rectangles, we calculate the sum of the 3 different rectangles, times 2
        return 2 * (_length * _width + _width * _height + _length * _height);
    }
    
    /**
     * Determines whether this box has a greater volume in compare to other box.
     * @param other a Box3D object whose volume will be compared with the volume of this Box3D
     * @return True if this box has a larger capacity than the given box and false otherwise
     */
    public boolean isLargerCapacity(Box3D other)
    {
        return getVolume() > other.getVolume(); // If a box has a larger capacity than another box, the volume of that box is greater than the volume of the other box
    }
    
    /**
     * Determines whether this box can contain the other box.
     * @param other a Box3D object to check if it can be contained within this box
     * @return True if this box could contain the given box and false otherwise
     */
    public boolean contains(Box3D other)
    {
        // A box contains another box if all of its measurements are bigger than the measurements of the other box
        return _length > other._length && _width > other._width && _height > other._height;
    }
    
    /**
     * Checks if this box is above the other box.
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise
     */
    public boolean isAbove(Box3D other)
    {
        return _base.isAbove(other.getUpRightBackPoint()); // A box is above another box only if its base point is above the upper-right-back point of the other box
    }
}