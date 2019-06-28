/**
 * This class represents an array of Box3D objects, sorted in ascending order, relative to their volume.
 *
 * @author Ofek Marks
 * @version 20.4.2019
 */
public class Collection
{
    private Box3D[] _boxes; // The array which the boxes are stored in
    private int _noOfBoxes; // Number of initiated boxes in the Collection
    public final int MAX_NUM_BOXES = 100; // Max boxes in a collection (the length of the Collection)
    
    /**
     * Constructs an empty Collection
     */
    public Collection()
    {
        _boxes = new Box3D[MAX_NUM_BOXES]; // Every Collection has the max length
        _noOfBoxes = 0; // At the beginning, there are 0 initiated boxes
    }
    
    /**
     * Adds a box to the Collection. If there's no place for a new one, the method returns false. Else, the box is added according to the ascending order of volumes
     * @param base the base point of the box
     * @param length the length of the box
     * @param width the width of the box
     * @param height the height of the box
     * @return True if there's a space for the new box and false if there isn't
     */
    public boolean addBox(Point3D base, int length, int width, int height)
    {
        if(_noOfBoxes == MAX_NUM_BOXES) // If the Collection is full, the method returns false
            return false;
        Box3D box = new Box3D(base, length, width, height); // Creates a new box with the given parameters
        int placeToSet = _noOfBoxes;
        for(; placeToSet > 0 && !box.isLargerCapacity(_boxes[placeToSet - 1]); placeToSet--) // To make room for the new box, we need to move all the boxes after it
            _boxes[placeToSet] = _boxes[placeToSet - 1];
        _boxes[placeToSet] = box; // Sets the new box at the requsted index
        _noOfBoxes++; // The number of initiated boxes is incremented, due to the added box
        return true;
    }
    
    /**
     * Returns the highest base point in the Collection
     * @return The box with the heighest base point
     */
    public Box3D mostUpperBaseCorner()
    {
        int highestBaseIndex = 0; // For a Collection with 1 box, the heighest base point is in index 0. For an empty collection, the method will return _boxes[0] (null)
        for(int index = 1; index < _noOfBoxes; index++) // The for loop scans the Collection
        {
            if(_boxes[index].getBase().isAbove(_boxes[highestBaseIndex].getBase()))
                highestBaseIndex = index; // If the current base point is above the heighest base point, the point's index is the new heighest base point index
        }
        return (_noOfBoxes == 0) ? null : new Box3D(_boxes[highestBaseIndex]);
    }
    
    /**
     * Calculates the total surface area of all the boxes in the Collection
     * @return The the sum of the surfaces of the boxes in the Collection
     */
    public double totalSurfaceArea()
    {
        int sumSurfaceArea = 0; // For an empty Collection, the sum of the surface areas is 0
        for(int index = 0; index < _noOfBoxes; index++) // The for loop scans the Collection
            sumSurfaceArea += _boxes[index].getSurfaceArea(); // For every initiated box, the surface area of that box is added to the sum variable
        return sumSurfaceArea;
    }
    
    /**
     * Finds the furthest distance between two boxes in the Collection
     * @return The distance between the furtrhest boxes in the Collection
     */
    public double longestDistance()
    {
        double maxDistance = 0 /* For a Collection with length that is less than 2, the max distance is 0 */, distance;
        for(int index1 = 0; index1 < _noOfBoxes; index1++) // The for loop scans the Collection
        {
            for(int index2 = index1 + 1; index2 < _noOfBoxes; index2++) // For every index, the following indexes are checked (to prevent double checking)
            {
                // If the distance between the two current boxes is bigger than the max distance, the current distance is the new max distance
                if(maxDistance < _boxes[index1].distance(_boxes[index2]))
                    maxDistance = _boxes[index1].distance(_boxes[index2]);
            }
        }
        return maxDistance;
    }
    
    /**
     * Calculates how many boxes contain a certain box
     * @param box the box that is checked for being contained by the other boxes
     * @return The amount of boxes that contain the given box
     */
    public int howManyContains(Box3D box)
    {
        int containCounter = 0; // At the beginning, there are 0 boxes that contain the given box
        for(int index1 = 0; index1 < _noOfBoxes; index1++) // The for loop scans the Collection
        {
            if(_boxes[index1].contains(box)) // If the box in the certain index contains the given box, the counter is incremented
                containCounter++;
        }
        return containCounter;
    }
    
    /**
     * Calculates the volume of the smallest box that contains all the boxes in the sub-Collection between indexes i and j
     * @param i one of the limit indexes
     * @param j one of the limit indexes
     * @return The volume of the requested box
     */
    public int volumeOfSmallestBox(int i, int j)
    {
        int maxIndex = Math.max(i, j), minIndex = Math.min(i, j); // The collection should be scanned from the smallest index to the biggest (the opposite way is also possible)
        if(minIndex < 0 || maxIndex >= _noOfBoxes) // Checks for invalid parameters
            return 0;
        int maxLength = 0, maxWidth = 0, maxHeight = 0;
        for(int index = minIndex; index <= maxIndex; index++) // The for loop scans the sub-Collection
        {
            // Finding the maximal measurements of the boxes in the array
            maxLength = (maxLength < _boxes[index].getLength()) ? _boxes[index].getLength() : maxLength;
            maxWidth = (maxWidth < _boxes[index].getWidth()) ? _boxes[index].getWidth() : maxWidth;
            maxHeight = (maxHeight < _boxes[index].getHeight())? _boxes[index].getHeight() : maxHeight;
                
        }
        return ++maxLength * ++maxWidth * ++maxHeight; // Returning the volume of the box that its measurements are the maximum measurments, incremented, to contain all the boxes
    }
    
    /**
     * Returns an array that its length is the number of the initiated boxes in the Collection, filled with copies of the initated boxes in it.
     * @return The array filled only with the initiated boxes
     */
    public Box3D[] getBoxes()
    {
        Box3D[] arrayOfBoxes = new Box3D[_noOfBoxes]; // The array's length is the amount of initiated boxes in the Collection, represented by the attribute _noOfBoxes
        for(int index = 0; index < _noOfBoxes; index++) // The for loop scans the Collection
            arrayOfBoxes[index] = new Box3D(_boxes[index]); // The box in every index of the array is a copy of the box in the same index, from the Collection
        return arrayOfBoxes;
    }
    
    /**
     * Returns the amount of initiated boxes in the Collection
     * @return The number of non-empty cells in the Collection
     */
    public int getNumOfBoxes()
    {
        return _noOfBoxes;
    }
    
    /**
     * Returns a string representation of this Collection object
     * @return A string that describes the Collection object
     */
    public String toString()
    {
        String str = ""; // If the collection is empty, the method will return nothing
        for(int index = 0; index < _noOfBoxes; index++) // The for loop scans the Collection
            str += "Box no. " + (index + 1) + ": " + _boxes[index].toString() + "\n"; // Each box's representation is concatenated to the string, with a new line
        return str;
    }
}