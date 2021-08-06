/**
 * I declare that this code was written by me on 2021-Aug-05 6:14:15 PM 
 * @author James
 * 
 * Student Name: Chiang James
 * Student ID: 20014241
 * Class: E37A
 * Date/Time created: Thursday 03-11-2020 18:14
 */

public class Category extends C206_CaseStudy {
	
	private String name;
	private boolean availableName;
	
	public Category(String name) {
		super();
		this.name = name;
		this.availableName = true;
	}

	public boolean isAvailableName() {
		return availableName;
	}

	public void setAvailableName(boolean availableName) {
		this.availableName = availableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 @Override
	  public String toString() {
	    String output = "";

	    return output;
	  }
}
