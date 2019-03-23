import java.util.Scanner;

/**
 * This class defines a person
 */
public class Person{
    //define the attributes
    private String _name;
    private long _identification;
    private String _gender;
    private int _age;

    /**
     * Constructor for objects of class Person
     */
    public Person ()
    {
        _name = null;
        _identification = 0;
        _gender = null ;
        _age = 0;
    }

    /**
     * This is the regular constructor
     * @param name Name of the person
     * @param identificaiton The ID number of the person
     * @param age The age of the person
     * @param gender The gender of the person
     */
    public Person (String name, long identification, int age, String gender)
    {
        _name = name;
        _identification = identification;
        _age = age;
        this._gender = gender;
    }

    /**
     * This method returns the object representation as a string
     */
    public String toString ()
    {
        return _name + _identification + _gender + _age;
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
        this._name = name

    }

    /**
     * This method returns the ID number of the person
     * @return identification identification of the person
     */
    public long getIdentification ()
    {
        return _identification;
    }

    /**
     * This method sets the ID number of the person
     */
    public void setIdentification (long identification) {
        this._identification = identification;

    }

    /**
     * This method returns the gender of the person
     * @return gender Gender of the person
     */
    public String getGender ()
    {
        return _gender;
    }

    /**
     * This method sets the gender of the person
     */
    public void setGender (String gender) {
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

    public boolean equals (Person p)
    {
        return _identification == p._identification && _name.equals(p._name) && _gender == p._gender && _age ==p._age;
    }
}