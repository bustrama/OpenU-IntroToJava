/**
 * 
 * This class represents a node in a two-way linked list - each node contains an integer value and pointers to the next and previous nodes in the list.
 *
 * @author Ofek Marks
 * @version 8.6.2019
 */
public class IntNodeTwo
{
    private int _num;
    private IntNodeTwo _next, _prev;
    
    /**
     * Constructs and initializes a node with the given value, when the next node and the previous node are null
     * @param n the value of the node
     */
    public IntNodeTwo(int n)
    {
    	_num = n;
        _next = null;
        _prev = null;
    }
    
    /**
     * Constructs and initializes a node with the value of the node, the next node and the previous node set to the given parameters
     * @param num the value of the node
     * @param n the next node in the list
     * @param p the previous node of the list
     */
    public IntNodeTwo(int num, IntNodeTwo n, IntNodeTwo p)
    {
    	_num = num;
        _next = n;
        _prev = p;
    }
    
    /**
     * Returns the value of the node
     * @return The attribute that contains the value of the node
     */
    public int getNum()
    {
        return _num;
    }
    
    /**
     * Returns the next node
     * @return The attribute that contains the next node
     */
    public IntNodeTwo getNext()
    {
        return _next;
    }
    
    /**
     * Returns the previous node
     * @return The attribute that contains the previous node
     */
    public IntNodeTwo getPrev()
    {
        return _prev;
    }
    
    /**
     * Sets the value of the node to a given integer
     * @param n the value to set
     */
    public void setNum(int n)
    {
    	_num = n;
    }
    
    /**
     * Sets the next node to the given node
     * @param node the node to set as next
     */
    public void setNext(IntNodeTwo node)
    {
    	_next = node;
    }
    
    /**
     * Sets the previous node to the given node
     * @param node the node to set as previous
     */
    public void setPrev(IntNodeTwo node)
    {
        _prev = node;
    }
}