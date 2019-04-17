
/**
 * This class represents an address object which contains name and number
 * 
 * @author Nissim
 */
public class Address
{
    // instance variables - replace the example below with your own
    private String _name;
    private int _houseNumber;
    
    public Address(String name, int houseNumber){
        _name = name;
        _houseNumber = houseNumber;
    }
    
    public Address(Address other){
        //this(other._name,other.getHouseNumber()); 
        _name = other._name;
        _houseNumber = other.getHouseNumber();
    }
    
    public void setName(String name){
        _name = name;
    }
    
    public String getName(){
        return _name;
    }
    
    public void setHouseNumber(int houseNumber){
        _houseNumber = houseNumber;
    }
    
    
    public int getHouseNumber(){
        return _houseNumber;
    }
    
    
    public String toString(){
        return " Address - name: " + _name + " House Number: " + _houseNumber;
    }
    
    public boolean equals(Address other){
        return _name.equals(other._name) && _houseNumber == other._houseNumber;
    }
}
