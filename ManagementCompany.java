/*
 * Class: CMSC203
 * Instructor: Robert Alexander
 * 
 * Description: 	The program receives up to 5 new properties information that are
 * 				managed by a management company. It checks if the properties added are 
 * 				within the plot of the management company.The program determines the property 
 * 				that has the maximum rent and lists all the properties managed. It also
 * 				calculates the total amount of all the properties' rent and the management
 * 				total fees amount.
 * 
 * Due: MM/DD/YYYY (<10/29/2020>)
 * 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: ____Auguste Basile Romeo Kiendrebeogo______
 */

package application;

public class ManagementCompany {

	/**
	 *  Instance variables
	 *   Maximum number of properties (MAX_PROPERTY) that this management company handles is set to 5
	 *   MGMT_WIDTH and MGMT_DEPTH initialized to 10
	 *   Name and tax ID of the management company
	 *   mgmFeePer: management fee percentage
	 *   Plot of the ManagemntCompany
	 *   An array of Property objects
	 */
	final private int MAX_PROPERTY = 5, MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private String name, taxID;
	private double mgmFeePer;
	private Plot plot;
	private Property[] properties;
	private int index;
	
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty 
	 * strings and the plot set to a Plot with x, y set to 0 , width and depth 
	 * set to 10. properties array is initialized here as well.
	 */
	ManagementCompany(){

		name = "";
		taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Copy Constructor that creates a ManagementCompany object from another 
	 * ManagementCompany object
	 * @param otherCompany a ManagementCompany object
	 */
	ManagementCompany(ManagementCompany otherCompany) {

		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFeePer = otherCompany.mgmFeePer;
		plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Constructor Creates a ManagementCompany object using the 
	 * passed information. plot is set to a Plot with x, y set to 0, width
	 * and depth set to 10 properties array is initialized here as well
	 * @param name: name of the management company
	 * @param taxID: taxID of the management company
	 * @param mgmFee: management fees applied
	 */
	ManagementCompany(String name, String taxID, double mgmFee){

		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Constructor Creates a ManagementCompany object using the 
	 * passed information.
	 * @param name: name of the management company
	 * @param taxID: taxID of the management company
	 * @param mgmFee: management fees applied
	 * @param x: x-value of the upper-left corner of the Plot
	 * @param y: y-value of the upper-left corner of the Plot
	 * @param width: horizontal extent of the Plot
	 * @param depth: vertical extent of the Plot
	 */
	ManagementCompany(String name, String taxID, double mgmFee, 
			int x, int y, int width, int depth){

		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}

	/**
	 * Return the MAX_PROPERTY constant that represents the 
	 * size of the "properties" array
	 * @return MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {

		return MAX_PROPERTY;
	}

	/**
	 * Creates a property object by copying from another property 
	 * and adds it to the "properties" array
	 * @param property: a Property object
	 * @return -1 if the array is full,
	 * -2 if the Property object is null
	 * 3 if if management company does not encompass the property plot
	 * -4 if property plot overlaps ANY of properties in array
	 * otherwise return the index of the array where the property was added.
	 */
	public int addProperty(Property property) {
		
		if (property == null)
			return -2;
		
		if (!plot.encompasses(property.getPlot()))
			return -3;
		
		if (index >= MAX_PROPERTY)
			return -1;
		
		if ((properties[index] != null) && (property.getPlot().overlaps(properties[index].getPlot())))
			return -4;
	
		properties[index] = property;
		index++;
		return index-1;	
	}

	/**
	 * Creates a property object with a default plot and adds it to the "properties" array.
	 * @param name: name of the property
	 * @param city: location of the property
	 * @param rent: rent amount of the property
	 * @param owner: owner's name
	 * @return -1 if the array is full,
	 * -2 if the Property object is null
	 * 3 if if management company does not encompass the property plot
	 * -4 if property plot overlaps ANY of properties in array
	 * otherwise return the index of the array where the property was added.
	 */
	public int addProperty(String name, String city, double rent, String owner) {

		Property property = new Property(name, city, rent, owner);	
		
		if (property == null)
			return -2;
		
		if (!plot.encompasses(property.getPlot()))
			return -3;
		
		if (index >= MAX_PROPERTY)
			return -1;
		
		if ((properties[index] != null) && (property.getPlot().overlaps(properties[index].getPlot())))
			return -4;
	
		properties[index] = property;
		index++;
		return index-1;	

	}

	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param name: name of the property
	 * @param city: location of the property
	 * @param rent: rent amount of the property
	 * @param owner: owner's name
	 * @param x: x-value of the upper-left corner of the Plot
	 * @param y: y-value of the upper-left corner of the Plot
	 * @param width: horizontal extent of the Plot
	 * @param depth: vertical extent of the Plot
	 * @return -1 if the array is full,
	 * -2 if the Property object is null
	 * 3 if if management company does not encompass the property plot
	 * -4 if property plot overlaps ANY of properties in array
	 * otherwise return the index of the array where the property was added.
	 */
	public int addProperty(String name, String city, double rent,
			String owner, int x, int y, int width, int depth) {

		Property property = new Property(name, city, rent, owner, x, y, width, depth);		
		if (property == null)
			return -2;
		
		if (!plot.encompasses(property.getPlot()))
			return -3;
		
		if (index >= MAX_PROPERTY)
			return -1;
		
		if ((properties[index] != null) && (property.getPlot().overlaps(properties[index].getPlot())))
			return -4;
	
		properties[index] = property;
		index++;
		return index-1;	
	}

	/**
	 * This method accesses each "Property" object within the array "properties"
	 * and sums up the property rent and returns the total amount.
	 * @return total rent amount of all properties
	 */
	public double totalRent() {

		double total = 0;
		for (Property x: properties) {
			total += x.getRentAmount();
		}

		return total;
	}

	/**
	 * This method finds a property within the properties array that has the
	 * maximum rent amount and returns the rent amount.
	 * @return the max rent amount within the properties
	 */
	public double maxRentProp() {

		double maxRent = properties[0].getRentAmount();
		for (int i = 0; i < properties.length; i++) {
			if (maxRent < properties[i].getRentAmount()) {
				maxRent = properties[i].getRentAmount();
			}
		}

		return maxRent;
	}

	/**
	 * This method finds the index of the property with the maximum rent amount.
	 * @return index of property with the max rent amount
	 */
	public int maxRentPropertyIndex() {

		int index = 0;
		double maxRent = properties[0].getRentAmount();
		for (int i = 0; i < properties.length; i++) {
			if (maxRent < properties[i].getRentAmount()) {
				index = i;
				maxRent = properties[index].getRentAmount();
			}
		}
		return index;
	}

	/**
	 * Displays the information of the property at index i
	 * @param i: index of the property
	 * @return the property's information
	 */
	public String displayPropertyAtIndex(int i){

		return properties[i].toString();	
	}
	
	/**
	 * Return the management's name
	 * @return name of the management
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the management's plot
	 * @return plot of the management
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * Displays the information of all the properties in the "properties" array.
	 */
	@Override
	public String toString(){
		
		String output = "";
		double totalFees = totalRent() * mgmFeePer / 100;
		
		System.out.println("List of the properties for " + name + ", taxID:" + 
		taxID +	"\n______________________________________________________" );

		for (int i = 0; i < properties.length; i++) {
			
			System.out.println("Property Name: " + properties[i].getPropertyName() + 
					"\n Located in " + properties[i].getCity() + 
					"\n Belonging to: " + properties[i].getOwner() + 
					"\n Rent Amount: " + properties[i].getRentAmount());
		}
		
		output = "______________________________________________________" + 
					"\ntotal management Fee: " + totalFees;
		
		return output;
		
	}

}
