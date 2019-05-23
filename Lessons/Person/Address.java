/**
 * This class represent Person's Address
 */
public class Address {
    private String _name;
    private int _number;

    public Address(){
        _name = null;
        _number = 0;
    }
    
    public Address(String name, int number){
        _name = name;
        _number = number;
    }
    public Address(Address myAdd){
        _name = myAdd._name;
        _number = myAdd._number;
    }
    
    public String getName(){
        return _name;
    }

    public void setName(String na){
        _name = na;
    }
    
    public int getNumber(){
        return _number;
    }

    public void setNumber(int num){
        _number = num;
    }

    public String toString(){
        return "Street: " + _name + ", Number: " + _number;
    }
}
