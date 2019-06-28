/**
 * Represent a list that built from nodes.
 * Sorted in ascending order (from smallest to largest).
 *
 * @author Ben Brandes
 * @version 09/06/2019
 */

import java.util.Scanner;

public class IntListTwo {
    private IntNodeTwo _head, _tail;

    /**
     * Empty constructor, will initialize both values to <code>null</code>
     */
    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    /**
     * Constructor that takes head and tail parameter for initialization
     *
     * @param h - Head node
     * @param t - Tail node
     */
    public IntListTwo(IntNodeTwo h, IntNodeTwo t) {
        _head = h;
        _tail = t;
    }

    // Return if the list is empty
    // Time Complexity - O(1)
    // Space Complexity - O(1)
    private boolean isEmpty() {
        return _head == null;
    }

    // Look for the latest node that is smaller than num
    // Time Complexity - o(n)
    // Space Complexity - o(1)
    private IntNodeTwo searchSmallerNode(int num) {
        IntNodeTwo current = _head;
        while (current.getNext() != null) {
            if (current.getNum() > num)
                return current;
            current = current.getNext();
        }

        return current;
    }

    /**
     * Get a number and insert it in it's suitable place in the list
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     * @param num - The number that'll be inserted
     */
    public void addNumber(int num) {
        // In case of empty list
        if (isEmpty()) {
            IntNodeTwo node = new IntNodeTwo(num, null, null); // Setup the new node
            _head = node; // Set the first node as head
            _tail = _head; // Also as tail
            return; // Stops the method
        }

        // Get the node where it's most suitable to place the new node
        IntNodeTwo helper = searchSmallerNode(num);

        // If the first node is the right place
        if (helper == _head) {
            if (num > helper.getNum()) {
                IntNodeTwo next = (_head.getNext() == null) ? null : _head.getNext();
                IntNodeTwo node = new IntNodeTwo(num, next, _head);
                _head.setNext(node);
                if (next == null)
                    _tail = node;
                else
                    next.setPrev(node);
            } else {
                IntNodeTwo node = new IntNodeTwo(num, _head, null);
                _head.setPrev(node); // First set the previous of the old head
                _head = node;       // And then sets the new head
            }
        }
        // If the the right place is in the end
        else if (helper == _tail) {
            IntNodeTwo node = new IntNodeTwo(num);
            // In case that the tail is bigger
            if (helper.getNum() > num) {
                node.setNext(helper);
                node.setPrev(helper.getPrev());
                helper.getPrev().setNext(node);
                helper.setPrev(node);
            }
            // In case that the new number is bigger
            else {
                node.setPrev(_tail);
                _tail.setNext(node);
                _tail = node;
            }
        }
        // In case the right place is somewhere in the middle
        else {
            IntNodeTwo node = new IntNodeTwo(num, helper, helper.getPrev());
            helper.getPrev().setNext(node);
            helper.setPrev(node);
        }
    }

    // Look for a node with specific number
    //
    // Time Complexity - o(n)
    // Space Complexity - o(1)
    private IntNodeTwo searchNumber(int num) {
        IntNodeTwo current = _head;
        int l = length();

        for (int i = 0; i < l; i++) {
            if (current.getNum() == num)
                return current;
            current = current.getNext();
        }
        return null;
    }

    /**
     * remove a number from the list
     * <p>
     * Time Complexity  - O(n)
     * Space Complexity O(1)
     *
     * @param num - The number that'll be removed
     */
    public void removeNumber(int num) {
        // Try to remove only if the list is not empty
        if (!isEmpty()) {
            IntNodeTwo removeMe = searchNumber(num); // Look for the number
            if (removeMe == null) // If not found, do nothing
                return;

            if (_head == _tail && _head == removeMe) // In case that removing the last node
                _head = _tail = null;
            else if (removeMe == _head) { // In case that removing the head
                _head.getNext().setPrev(null);
                _head = _head.getNext();
            } else if (removeMe == _tail) { // In case that removing the tail
                _tail.getPrev().setNext(null);
                _tail = _tail.getPrev();
            } else { // Somewhere in the middle
                removeMe.getPrev().setNext(removeMe.getNext());
                removeMe.getNext().setPrev(removeMe.getPrev());
            }

        }
    }

    /**
     * Get input from user until it detect <code>-9999</code> value
     * And insert it to the list
     * <p>
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public void readToList() {
        Scanner input = new Scanner(System.in);
        int number = 0;

        while (number != -9999) {
            number = input.nextInt(); // Get the input
            if (number != -9999) // If the number isn't -9999, add to list
                addNumber(number);
        }
    }

    /**
     * Will return the number of nodes in the list
     * <p>
     * Time Complexity  - O(n)
     * Space Complexity O(1)
     *
     * @return the number of nodes in the list
     */
    public int length() {
        int count = 0;

        IntNodeTwo current = _head;
        while (current != null) {
            count++;        // Count every node until gets null
            current = current.getNext();
        }

        return count;
    }

    /**
     * Will return the sum of all the nodes in the list
     * <p>
     * Time Complexity  - O(n)
     * Space Complexity O(1)
     *
     * @return the sum of all the nodes in the list
     */
    public int sum() {
        if (!isEmpty()) {
            IntNodeTwo current = _head;
            int sum = 0;

            while (current.getNext() != null) {
                sum += current.getNum();
                current = current.getNext();
            }
            sum += current.getNum();

            return sum;
        }
        return 0;
    }

    /**
     * Will return the length of the longest sequence that their sum will be even
     * <p>
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     *
     * @return the length of the longest sequence that their sum will be even
     */
    public int maxLength() {
        int sum = sum();
        int length = length();

        if (sum % 2 == 0) // if the whole array is even return it's length
            return length;
        else {
            IntNodeTwo leftNode = _head;
            int right = length - 1;   // Initial to the last cell
            IntNodeTwo rightNode = _tail;

            while (leftNode != rightNode) {      // Will run until they meet in the middle
                if (leftNode.getNum() % 2 != 0)   // Check whether the left cell is odd number
                    return right;       // If it's odd number then, Odd - Odd = even, then return it's place
                else if (rightNode.getNum() % 2 != 0) // Check whether the right cell is odd number
                    return right;       // If it's odd number then, Odd - Odd = even, then return it's place
                else {                  // If none is odd number then move towards the center
                    right--;
                    rightNode = rightNode.getPrev();
                    leftNode = leftNode.getNext();
                }
            }

            if (leftNode.getNum() % 2 != 0)
                return right;
        }

        return 0;
    }

    /**
     * This method gets a number and look for a <code>sub-list</code>
     * that their average is equal to the given num
     * <p>
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     *
     * @param num - Average to be searched
     * @return true - found sub-list with num as average <\br>
     * false - sub-list with num as average doesn't exist
     */
    public boolean isAverage(double num) {
        if (!isEmpty()) {
            int count = length();
            int sum = sum();
            double avg = sum / (double) count;

            if (avg == num)
                return true;

            IntNodeTwo left = _head; // The smaller numbers
            IntNodeTwo right = _tail; // The bigger numbers

            while (left != right) {
                if (avg < num) {
                    sum -= left.getNum();
                    count--;
                    left = left.getNext();

                } else if (avg > num) {
                    sum -= right.getNum();
                    count--;
                    right = right.getPrev();
                }
                avg = sum / (double) count;
                if (avg == num)
                    return true;
            }

            return false;
        } else return false;
    }

    /**
     * Will return a String that represent the object <code>IntListTwo</code>
     * <p>
     * Time Complexity - o(n)
     * Space Complexity - o(1)
     *
     * @return a String that represent the object <code>IntListTwo</code>
     */
    public String toString() {
        String list = "{";
        IntNodeTwo current = _head;
        int l = length();

        for (int i = 0; i < l; i++) {
            list += current.getNum();
            if (i < l - 1)
                list += ", ";

            current = current.getNext();
        }

        return list + "}";
    }
}