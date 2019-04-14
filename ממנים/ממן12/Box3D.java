/**
 *  Matala 12.2 - Using a class to represent a Box with a certain point as base on 3D coordinate system
 *
 * @author Ben Brandes
 * @version 2019b
 */

public class Box3D{
    // Private members
    private Point3D _base;
    private int _length; // Parallel to axis X
    private int _width; // Parallel to axis Y
    private int _height; // Parallel to axis Z
    private final int DEFAULT_VAL = 1;

    /**
     * Constructor that'll initialize base to (0,0,0) and the other to 1
     */
    public Box3D() {
        this._base = new Point3D(0,0,0);
        this._length = DEFAULT_VAL;
        this._width = DEFAULT_VAL;
        this._height = DEFAULT_VAL;
    }

    /**
     * Constructor that'll initialize the base to a given point as well as the others
     * @param base Point3D as the box's base
     * @param length The length of the box
     * @param width The width of the box
     * @param height The height of the box
     */
    public Box3D(Point3D base, int length, int width, int height) {
        this._base = new Point3D(base);

        _length = (length <= 0) ? DEFAULT_VAL : length;
        _width = (width <= 0) ? DEFAULT_VAL : width;
        _height = (height <= 0) ? DEFAULT_VAL : height;
    }

    /**
     * Constructor that'll initialize the members according to a given Box3D
     * @param other Other box to copy from
     */
    public Box3D(Box3D other) {
        this._base = new Point3D(other.getBase());
        this._length = other.getLength();
        this._width = other.getWidth();
        this._height = other.getHeight();
    }

    /**
     * Private member _base getter
     * @return The base of the box
     */
    public Point3D getBase(){
        return new Point3D(this._base);
    }

    /**
     * Private member _base setter
     * @param p Other point to set the base to
     */
    public void setBase(Point3D p){
        this._base = new Point3D(p);
    }

    /**
     * Private member _length getter
     * @return The length of the box
     */
    public int getLength(){
        return this._length;
    }

    /**
     * Private member _length setter
     * @param num Other number to set the length to
     */
    public void setLength(int num){
        if(num > 0){
            this._length = num;
        }
    }

    /**
     * Private member _width getter
     * @return The width of the box
     */
    public int getWidth(){
        return this._width;
    }

    /**
     * Private member _width setter
     * @param num Other number to set the width to
     */
    public void setWidth(int num){
        if(num > 0){
            this._width = num;
        }
    }

    /**
     * Private member _height getter
     * @return The height of the box
     */
    public int getHeight(){
        return this._height;
    }

    /**
     * Private member _height setter
     * @param num Other number to the height to
     */
    public void setHeight(int num){
        if(num > 0){
            this._height = num;
        }
    }

    /**
     * Display the current Box3D
     * @return the current Box3D
     */
    public String toString(){
        return "The base point is " + this._base.toString() + ", length = " + this._length + ", width = " + this._width + ", height = " + this._height;
    }

    /**
     * Checks if the passed Box3D match the current Box3D
     * @param other Other box to check if equivalent
     * @return true - equivalent, false - not equivalent
     */
    public boolean equals(Box3D other){
        if(this._base.equals(other.getBase()) && this._height == other.getHeight() && this._width == other.getWidth() && this._length == other.getLength()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move the box on every axis by dx, dy and dz and return the Box with new base
     * @param dx move the box's base on the X axis by dx
     * @param dy move the box's base on the Y axis by dy
     * @param dz move the box's base on the Z axis by dz
     * @return The new box after the base moved
     */
    public Box3D move (double dx, double dy, double dz){
        Box3D other = new Box3D(this);
        other._base.move(dx, dy, dz);
        return other;
    }

    /**
     * Return the upper right back point of the box
     * @return The upper right back point of the box
     */
    public Point3D getUpRightBackPoint(){
        return new Point3D(this._base.getX() - this._length, this._base.getY() + this._width, this._base.getZ() + this._height);
    }

    /**
     * Return the Point that represent the center of the box
     * @return The Point that represent the center of the box
     */
    public Point3D getCenter(){
        return new Point3D(_base.getX() - (_length/2.0), _base.getY() + (_width/2.0), _base.getZ() + (_height / 2.0));
    }

    /**
     * Return the distance between the two center points of the boxes
     * @param other Other box
     * @return The distance between the two center points of the boxes
     */
    public double distance(Box3D other){
        return this.getCenter().distance(other.getCenter());
    }

    /**
     * Return the volume of the box
     * @return The volume of the box
     */
    public int getVolume(){
        return this._length * this._width * this._height;
    }

    /**
     * Return the surface area of the box
     * @return The surface area of the box
     */
    public int getSurfaceArea(){
        return  ((2 * (this._height * this._width)) + (2 * (this._height * this._length)) + (2 * (this._width * this._length)));
    }

    /**
     * Checks which box has larger volume
     * @param other Other box
     * @return Which box has larger volume
     */
    public boolean isLargerCapacity(Box3D other){
        return (this.getVolume() > other.getVolume());
    }

    /**
     * Checks if the parameter box can be placed within the current box
     * @param other Other box to be checked
     * @return True - Can contain, False - can't contain
     */
    public boolean contains(Box3D other){
        return(this._length > other._length && this._height > other._height && this._width > other._width);
    }

    /**
     * Check if the whole current box is above the parameter box
     * @param other
     * @return True - The whole current box above the parameter box, False - not above
     */
    public boolean isAbove(Box3D other){
        return (this._base.isAbove(other.getUpRightBackPoint()));
    }
}