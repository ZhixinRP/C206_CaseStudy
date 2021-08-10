
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
