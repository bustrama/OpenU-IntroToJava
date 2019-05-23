/**
 * This class defines a person
 */
public class Person{
    //define the attributes
    private String _name;
    private long _id;
    private boolean _gender;
    private int _age;
    private Address _address;

    /**
     * Constructor for objects of class Person
     */
    public Person ()
    {
        _name = null;
        _id = 0;
        _gender = true;
        _age = 0;
        _address = new Address();
    }

    /**
     * This is the regular constructor
     * @param name Name of the person
     * @param id The ID number of the person
     * @param age The age of the person
     * @param gender The gender of the person
     */
    public Person (String name, long id, int age, boolean gender, Address addr)
    {
        _name = name;
        _id = id;
        _age = age;
        _gender = gender;
        _address = new Address(addr);
    }

    /**
     * This method returns the object representation as a string
     */
    public String toString ()
    {
        return "Name: " + _name + ", ID: " + _id + ", Gender: " + (_gender ? "female":"male")+", age: " + _age + ", Address: " + _address.toString();
    }

    /**
     * This method returns the name of the person
     * @return name Name of the person
     */
    public String getName ()
    {
        return _name;
    }

    /**
     * This method sets the name of the person
     */
    public void setName (String name) {
        this._name = name;
    }

    /**
     * This method returns the ID number of the person
     * @return identification identification of the person
     */
    public long getId ()
    {
        return _id;
    }

    /**
     * This method sets the ID number of the person
     */
    public void setId (long id) {
        this._id = id;
    }

    /**
     * This method returns the gender of the person
     * @return gender Gender of the person
     */
    public String getGender ()
    {
        return (_gender ? "female":"male");
    }

    /**
     * This method sets the gender of the person
     */
    public void setGender (boolean gender) {
        this._gender = gender;

    }

    /**
     * This method returns the age of the person
     * @return age Age of the person
     */
    public int getAge ()
    {
        return _age;
    }

    /**
     * This method sets the age of the person
     */
    public void setAge (int age) {
        this._age = age;
    }

    public boolean equals (Person p) {
        return _id == p._id && _name.equals(p._name) && _gender == p._gender && _age ==p._age;
    }

    public Address getAddress(){
        return new Address(_address);
    }

    public void setAddress(Address addr){
        _address = new Address(addr);
    }
}