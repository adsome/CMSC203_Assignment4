package application;

public class Plot {

	/**
	 * Instance variables
	 * The x-value of the upper-left corner of the Plot
	 * The y-value of the upper-left corner of the Plot
	 * The horizontal extent of the Plot
	 * The vertical extent of the Plot
	 */
	private int x, y, width, depth;

	/**
	 * No-arg Constructor, creates a Plot with x = 0, y = 0, width = 1, depth = 1
	 */
	Plot(){

		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	/**
	 * Copy constructor, creates a new Plot using the information of the Plot passed to it.
	 * @param p: a Plot object
	 */
	Plot(Plot p){

		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}

	/**
	 * Parameterized Constructor
	 * @param x: x-horizontal coordinate of upper left corner
	 * @param y: y-vertical coordinate of upper left corner
	 * @param width: width-horizontal size
	 * @param depth: depth - vertical size
	 */
	Plot(int x, int y, int width, int depth){

		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * @return true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot p) {
		
		boolean isOverlapping = false;
		if ((p.x < (x + width)) 
			|| (p.y < (y + depth))
			|| ((p.x + p.width) > x)
			|| ((p.y + p.depth) > y)) {
			isOverlapping = true;
		}
		
		return isOverlapping;
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * @return true if this plot encompasses the parameter, false otherwise
	 */
	
	public boolean encompasses(Plot p) {
		
		boolean isEncompassed = false;
		if (x <= p.x && y <= p.y 
			&& (width + x) >= (p.width + p.x)
			&& (depth + x) >= (p.depth + p.x)) {
			isEncompassed = true;
		}
		
		return isEncompassed;
	}
	
	/**
	 * Return the x value
	 * @return the x value
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Set the x value
	 * @param x: the x value to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Return the y value
	 * @return the y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the y value
	 * @param y: the y value to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Return the width value
	 * @return the width value
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width value
	 * @param width: the width value to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Return the depth value
	 * @return the depth value
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Set the depth value
	 * @param depth: the depth value to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Represents a Plot object
	 * Prints out the name, city, owner and rent amount for a property
	 */
	@Override
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}


}
