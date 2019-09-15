/**
 * 
 * This class represents a two-way linked list, in which every list conatains pointers to the head and tail of the list - 
 * those nodes give access to the entire list from both directions (tail's next node will be null, as well as head's previous node)
 *
 * @author Ofek Marks
 * @version 8.6.2019
 */
import java.util.Scanner;
public class IntListTwo
{
    private IntNodeTwo _head, _tail;

    /**
     * Constructs and initializes an empty list
     */
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    /**
     * Constructs and initializes a list with h as the head and t as the tail
     * @param h the head of the list
     * @param t the tail of the list
     */
    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }

    /**
     * Adds a new node, that contains the given value, to the list (and keeps the ascending order)
     * @param num the value of the node that will be added to the list
     */
    public void addNumber(int num)
    {
        if(_head == null) // If the list is empty, the new node will be the head an tail of the list
        {
            _head = new IntNodeTwo(num);
            _tail = _head;
            return;
        }
        IntNodeTwo index = _tail;
        // Creating a place at the end of the list for the new node:
        _tail.setNext(new IntNodeTwo(0, null, _tail));
        _tail = _tail.getNext();
        while(index != null && index.getNum() >= num) // To clear the requested spot for the new node, we need to move all the nodes after it
        {
            index.getNext().setNum(index.getNum());
            index = index.getPrev();
        }
        if(index == null) // If the index is null, we reached to the head of the list, which means that the new node should be the head of the list
            _head.setNum(num);
        else
            index.getNext().setNum(num); // Sets the new node at the requsted order
    }

    /**
     * Removes the first node that contains the given value (if that node exists)
     * @param num the value of the node that will be removed from the list
     */
    public void removeNumber(int num)
    {
        IntNodeTwo current = _head;
        while(current != null && num != current.getNum()) // Scanning the list until the end of it, or to the wanted location (in which the value of the node is num)
            current = current.getNext();
        if(current != null) // If current isn't null, num is in the list
        {
            // If the number is in the list, we need to remove it, and conect the two remaining parts together
            if(current == _head) // If the node is the head of the list, the method defines it's next as the new head
                _head = current.getNext();
            else
                current.getPrev().setNext(current.getNext()); // Else, we connect the node's previous to the node's next
            if(current == _tail) // If the node is the tail of the list, the method defines it's previous as the new tail
                _tail = current.getPrev();
            else // Otherwise, we connect the node's next to the node's previous
                current.getNext().setPrev(current.getPrev());
        }
    }

    /**
     * Reads numbers from the user and adds them to the list
     */
    public void readToList()
    {
        final int LOOP_END = -9999; // The while loop will stop when getting -9999
        Scanner scan = new Scanner(System.in); // The scanner is created in order to get values from the user
        int num = scan.nextInt();
        IntNodeTwo temp = _head;
        while(num != LOOP_END)
        {
            temp = new IntNodeTwo(num, _head, null); // Adding the new values to the head of the list
            _head = temp;
            num = scan.nextInt();
        }
        _head = mergeSort(_head); // Using the method mergeSort to sort the values in the list
        temp = _head;
        while(temp.getNext() != null) // Because mergeSort connects only the next node, we connect the previous node
        {
            temp.getNext().setPrev(temp);
            temp = temp.getNext();
        }
        _tail = temp; // Because mergeSort doesn't declare the new tail, we declare it after we scanned the list (and reached the end of it)
    }

    private IntNodeTwo split(IntNodeTwo node)
    {
        if(node == null || node.getNext() == null) // If the list has less than 2 nodes, we can't split it anymore
            return null;
        IntNodeTwo list = node.getNext(); // The new list
        node.setNext(list.getNext()); // The remained list
        list.setNext(split(list.getNext())); // Using recursion in order to split the next nodes in the list
        return list; // Returns the new list
    }

    private IntNodeTwo mergeSort(IntNodeTwo node)
    {
        if(node == null || node.getNext() == null) // If the list has less than 2 nodes, it's sorted
            return node;
        IntNodeTwo list = split(node); // We split the list into two lists
        node = mergeSort(node); // Sorts the first list
        list = mergeSort(list); // Sorts the other list
        return merge(node,list); // Merges both list into a sorted list
    }

    private IntNodeTwo merge(IntNodeTwo list1, IntNodeTwo list2)
    {
        if(list1 == null) // If one of the lists have no nodes, we merged the entire list
            return list2;
        if(list2 == null)
            return list1;
        if(list1.getNum() < list2.getNum()) // The first node of the merged list will be the smallest head of both lists (both of the lists are sorted)
        {
            list1.setNext(merge(list1.getNext(), list2)); // Merging the rest of the lists
            return list1; // Returning the merged list
        }
        list2.setNext(merge(list1, list2.getNext())); // Merging the rest of the lists
        return list2; // Returning the merged list
    }

    /**
     * Returns the description of the given list
     * @return The description of the list. For example: {1, 2, 3, 4, 5, 6, 7, 8, 9}
     */
    public String toString()
    {
        String str = "{"; // The object's description starts with a curly bracket
        for(IntNodeTwo current = _head; current != _tail; current = current.getNext()) // The for loop scans the list
            str += current.getNum() + ", "; // The value of every node in the list (that isn't the tail) is added to the description of the list, with a coma
        return str + ((_tail == null) ? "" : _tail.getNum()) + "}"; // For the tail of the list, we add its value and a curly bracket
    }

    /**
     * Returns the length of the given list
     * @return The length of the list
     */
    public int length()
    {
        int counter = 0; // The length of an uninitiated list is 0
        for(IntNodeTwo current = _head; current != null; current = current.getNext()) // The for loop scans the list and increments the counter for every initiated node
            counter++;
        return counter;
    }

    /**
     * Returns the sum of the given list
     * @return The sum of the nodes' values that are in the list
     */
    public int sum()
    {
        int sum = 0; // The sum of an uninitiated list is 0
        for(IntNodeTwo current = _head; current != null; current = current.getNext()) // The for loop scans the list and adds the value of the node to the sum of the list
            sum += current.getNum();
        return sum;
    }

    /**
     * Returns the length of the longest sub-list that its sum is even
     * @return The length of the requested sub-list
     */
    public int maxLength()
    {
        int length = length(), sum = sum(); // Using the length and sum methods to calculate the length of the list and its sum
        IntNodeTwo first = _head, last = _tail;

        if(sum % 2 == 0) // If the sum of the whole list (which has the longest length) is even, the method will return the length of the list
            return length;

        // Else, which means the sum of the list is odd
        while(last != first)
        {
            length--; // The while loop checks smaller sub lists, so the method decrements the length

            // When we get to the first odd element (from the end or from the beginning), the sum of the sub-list from/until this node is the longest sub-list with an even sum
            if(last.getNum() % 2 != 0 || first.getNum() % 2 != 0)
                return length;

            // Moves to the next (or previous) nodes to check
            first = first.getNext();
            last = last.getPrev();
        }
        // If we haven't found an odd value, until the two nodes point the same node, the odd value has to be in that node. Therefore, the method returns the length divided by 2
        return length() / 2;
    }

    /**
     * Returns if there's an sub-list that itד average is equal to a given number
     * @param num the number that is checked for being equal to the average of a sub-list
     * @return true if there is a sub-list and false if there isn't
     */
    public boolean isAverage(double num)
    {
        int length = length(), sum = sum(); // Using the length and sum methods to calculate the length of the list and its sum
        IntNodeTwo first = _head, last = _tail;
        while(last != null && first != last.getNext()) // The nested for loop determines the limit nodes of the sum
        {
            if(((double)sum / length) == num)
                return true;
            if(((double)sum / length) > num) // If the average is greater than the num, we remove the biggest number in the average in order to decrease the average
            {
                sum -= last.getNum();
                last = last.getPrev();
            }
            else // If the average is smaller than the num, we remove the smallest number in the average in order to increase the average
            {
                sum -= first.getNum();
                first = first.getNext();
            }
            length--; // In each way we decrement the length of the sub-list due th the removed node
        }        
        return false; // If there isn't a sub-list with an average as num, we return false
    }
}