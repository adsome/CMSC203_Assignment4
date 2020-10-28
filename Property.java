package application;

public class Property{
	
	/**
	 *  Instance variables
	 */
	private String city, owner, propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * No-arg constructor, creates a new object with default values of 
	 * empty strings, 0 for rent amount, and default Plot (sets the x, 
	 * y values to 0, depth and width to 1)
	 */
	Property() {
		
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p: a Property object
	 */
	Property(Property p) {
		
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = p.plot;
	}
	
	/**
	 * Constructor, Parameterized constructor with no Plot information (uses
	 *  default Plot where x, y are set to 0, width and depth set to 1)
	 * @param propertyName: property name
	 * @param city: city where the property is located
	 * @param rentAmount: rent amount
	 * @param owner: the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 *  Parameterized constructor
	 * @param propertyName:property name
	 * @param city: city where the property is located
	 * @param rentAmount: rent amount
	 * @param owner: the owner's name
	 * @param x: the x-value of the property's plot
	 * @param y: the y-value of the property's plot
	 * @param width: the horizontal size of the property's plot
	 * @param depth:  the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount,
			String owner, int x, int y, int width, int depth) {
		
		
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}

	/**
	 * Return the city
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city
	 * @param the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Return the owner's name
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set owner's name
	 * @param owner: the owner's name to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Return the property Name
	 * @return property name
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Set the property name
	 * @param propertyName: the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Return the rent amount
	 * @return rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}

	/**
	 * Set the rent amount
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	/**
	 * Return the Property plot
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Set the Plot values
	 * @param x: the x-value of the property's plot
	 * @param y: the y-value of the property's plot
	 * @param width: the horizontal size of the property's plot
	 * @param depth: the vertical size of the property's plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		
		plot = new Plot(x, y, width, depth);
		return plot;
	}

	/**
	 * Prints out the name, city, owner and rent amount for a property.
	 */
	@Override
	public String toString() {
		return "Property Name: " + propertyName + 
				"\n Located in " + city + 
				"\n Belonging to: " + owner + 
				"\n Rent Amount: " + rentAmount;
	}
	
}
