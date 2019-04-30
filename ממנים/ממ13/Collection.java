/**
 * A class that represent a collection of Box3D.
 * Boxes will be add through addBox function, which will also take care of the order.
 *
 * @author Ben Brandes
 * @version 13.04.19
 */
public class Collection {
    private Box3D[] _boxes;
    private int _noOfBoxes;
    final int MAX_NUM_BOXES = 100;
    final int INITIAL_VAL = 0;

    /**
     * Constructor will initialize the array to the default size (100)
     * And set the noOfBoxes to 0
     */
    public Collection() {
        _boxes = new Box3D[MAX_NUM_BOXES];
        _noOfBoxes = INITIAL_VAL;
    }

    /**
     * Will add a box to the array and return true if there is place for another box and false for failure
     *
     * @param base   Point3D base for the Box
     * @param length Box's length
     * @param width  Box's width
     * @param height Box's height
     * @return true - if the box added successfully, false - if the array is full
     */
    public boolean addBox(Point3D base, int length, int width, int height) {
        if (_noOfBoxes == MAX_NUM_BOXES) {
            return false;
        } else {
            Box3D newBox = new Box3D(base, length, width, height);
            int index = this.findSuitableIndex(newBox); // Passing the box to private method that'll check for the right location
            this.freeIndex(index); // After finding the right location, move all the boxes to the right
            _boxes[index] = new Box3D(newBox); // Assign the new box to it's right location
            _noOfBoxes++; // Increase the number of boxes
            return true;
        }
    }

    /**
     * Create an array that contain all the boxes, the array size will be the number of boxes
     *
     * @return An array with a size of the number of boxes
     */
    public Box3D[] getBoxes() {
        Box3D[] all = new Box3D[_noOfBoxes];

        for (int i = 0; i < _noOfBoxes; i++) {
            all[i] = new Box3D(_boxes[i]);
        }

        return all;
    }

    /**
     * Return the total number of the boxes in the array
     *
     * @return the total number of the boxes in the array
     */
    public int getNumOfBoxes() {
        return _noOfBoxes;
    }

    /**
     * Checks how many boxes in the array can contain the parameter box
     *
     * @param box the box that will be checked
     * @return how many boxes in the array can contain the parameter box
     */
    public int howManyContains(Box3D box) {
        int count = 0;

        for (int i = 0; i < _noOfBoxes; i++) {
            if (_boxes[i].contains(box))
                count++;
        }

        return count;
    }

    /**
     * Return the longest distance between two boxes in the array
     *
     * @return the longest distance between two boxes in the array
     */
    public double longestDistance() {
        if(_noOfBoxes < 2)
            return 0;

        double distance = 0;

        for (int i = 0; i < _noOfBoxes; i++) {
            for (int j = 0; j < _noOfBoxes; j++) {
                double d = _boxes[i].distance(_boxes[j]);
                if (d > distance)
                    distance = d;
            }
        }

        return distance;
    }

    /**
     * Return the box the highest base point
     * If the array is empty, will return <code>null</code>
     *
     * @return The box with the highest base point, if empty will return <code>null</code>
     */
    public Box3D mostUpperBaseCorner() {
        if (_noOfBoxes == 0)
            return null;

        Box3D highest = new Box3D();
        for (int i = 0; i < _noOfBoxes; i++) {
            if (_boxes[i].getBase().isAbove(highest.getBase())) {
                highest = _boxes[i];
            }
        }

        return new Box3D(highest);
    }

    /**
     * Return a string that'll display all the boxes
     *
     * @return a string that'll display all the boxes
     */
    public String toString() {
        String boxes = "";
        for (int i = 0; i < _noOfBoxes; i++) {
            boxes += "Box no. " + (i + 1) + ": " + _boxes[i].toString() + "\n";
        }

        return boxes;
    }

    /**
     * Return the total of the surface area of all the boxes in the array
     *
     * @return the total of the surface area of all the boxes in the array
     */
    public double totalSurfaceArea() {
        double area = 0;

        for (int i = 0; i < _noOfBoxes; i++) {
            area += _boxes[i].getSurfaceArea();
        }

        return area;
    }

    /**
     * Will check all the boxes within this index range and
     * return the volume of the smallest box that can contain all those boxes.
     *
     * @param i index within the array
     * @param j index within the array
     * @return return the volume of the smallest box that can contain all those boxes
     */
    public int volumeOfSmallestBox(int i, int j) {
        // Checks if the indexes are valid
        if (i >= MAX_NUM_BOXES || j >= MAX_NUM_BOXES || i < 0 || j < 0 || j >= _noOfBoxes || i >= _noOfBoxes)
            return 0;

        int min = (i > j) ? i : j;
        int max = (j > i) ? j : i;

        int maxH = 0, maxW = 0, maxL = 0;

        for (int l = min; l <= max; l++) {
            if (_boxes[l].getHeight() >= maxH)
                maxH = _boxes[l].getHeight() + 1;
            if (_boxes[l].getLength() >= maxL)
                maxL = _boxes[l].getLength() + 1;
            if (_boxes[l].getWidth() >= maxW)
                maxW = _boxes[l].getWidth() + 1;
        }

        return maxH * maxL * maxW;
    }

    // Return the index of the best place for the new box
    private int findSuitableIndex(Box3D box) {
        for (int i = 0; i < _noOfBoxes; i++) {
            if (_boxes[i].getVolume() >= box.getVolume())
                return i;
        }
        return _noOfBoxes;
    }

    // Will move all the boxes next to the index parameter 1 place right
    private void freeIndex(int index) {
        for (int i = _noOfBoxes; i > index; i--) {
            _boxes[i] = new Box3D(_boxes[i - 1]);
        }
    }
}
