
/**
 * This class represents a person object.
 * 
 * @author Nissim
 */
public class Person
{


	private static final int MAX_SIZE = 5;
	// instance variables;
	private long _id;
	private String _name;
	private int _age;    
	private Address[] _address;
	private int _noOfAdresses;

	/**
	 * Constructor with all parameter for objects of class Person
	 * @param id - This param is the person's id 
	 * @param name - This param is the person's name
	 * @param age - This param is the person's age
	 */
	public Person(long id, String name, int age, Address[] address){
		this._id = id;
		this._name = name;
		this._age = age;
		//this._address = address;//(aliasing)
		_address = new Address[address.length];        
		for (int i = 0; i < _address.length; i++) {
			_address[i] = new Address(address[i]);
		}
		_noOfAdresses = address.length;
	}

	public Person(){
		_address = new Address[MAX_SIZE];
		_noOfAdresses = 0;
		this._id = 1111111;
		this._name = "Jon Duo";
		this._age = -1;
	}

	public Person(Person other) {
		this(other.getId(), other.getName(), other.getAge(), other.getAddress());
	}


	/**
	 * This method returns the person's id
	 * @return the id of the person
	 */
	public long getId()
	{
		return _id;
	}

	/**
	 * This method set the person's id
	 * @param id given id 
	 */
	public void setId(long id)
	{
		this._id = id;
	}

	/**
	 * This method returns the person's name
	 * @return the name of the person
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * This method set the person's name
	 * @param name given name 
	 */
	public void setName(String name)
	{
		this._name = name;
	}

	/**
	 * This method returns the person's age
	 * @return the age of the person
	 */
	public int getAge() {
		return _age;
	}

	/**
	 * This method set the person's age
	 * @param age given name 
	 */

	public void setAge(int age) {
		this._age = age;
	}

	/**
	 * This method returns the person's address
	 * @return the address of the person
	 */
	public Address[] getAddress() {
		Address[] retArr = new Address[_address.length];
		for (int i = 0; i < retArr.length; i++) {
			retArr[i] = new Address(_address[i]);
		}
		return retArr;
	}

	/**
	 * This method set the person's address
	 * @param address given name 
	 */
	public void setAddress(Address[] address) {
		_address = new Address[_address.length];
		for (int i = 0; i < address.length; i++) {
			_address[i] = new Address(_address[i]);
		}
	}


	public boolean addAdress(Address address) {
		if(_noOfAdresses < _address.length) {
			_address[_noOfAdresses] = new Address(address);
			_noOfAdresses++;
			return true;
		}
		return false;
	}

	public boolean removeAddress(Address address) {
		if(_noOfAdresses == 0) 
			return false;
		for (int i = 0; i < _noOfAdresses; i++) {
			if(_address[i].equals(address)) {
				_address[i] = new Address(_address[_noOfAdresses-1]);
				_noOfAdresses--;
				return true;
			}
		}
		return false;
	}

	public String toString(){
		String addressList = "";
		for (int i = 0; i < _noOfAdresses; i++) {
			addressList += _address[i].toString() + " ";
		}
		return "Person - name: " + _name + " age: " + _age + " addresses: " + addressList;
	}

	public boolean equals(Person other){
		return _id == other._id && _name.equals(other._name);
	}

}
