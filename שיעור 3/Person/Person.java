public class Person
{
    private String _name;
    private long _id;
    private String _gender;
    private double _age;
    
    public Person()
    {
    	_name = null;
    	_id = 0 ;
    	_gender = null;
    	_age = 0;
    }
    
    public Person(String name, long id, String gender, double age)
    {
	_name = name;
    	_id = id ;
    	_gender = gender;
    	_age = age;
    }
    
    public String getName()
    {
        return this._name; 
    }
    
    public void setName(String name)
    {
        this._name = name; 
    }
    
    public long getId()
    {
        return this._id; 
    }
    
    public void setId(long id)
    {
        this._id = id; 
    }
    
    public String getGender()
    {
        return this._gender; 
    }
    
    public void setid(String gender)
    {
        this._gender = gender; 
    }
    
    public double getAge()
    {
        return this._age; 
    }
    
    public void setAge(double age)
    {
        this._age = age; 
    }
}