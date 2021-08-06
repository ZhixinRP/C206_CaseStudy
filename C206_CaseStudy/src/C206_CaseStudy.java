import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Category> listOfCategories = new ArrayList<Category>();
		
		int options = 5; //add number of options as you deem fit
		
		
		while (options <= 5) {
			if (options == 1) {
				//enter code ...
			}
			else if (options == 2){
				int choice = Helper.readInt("Enter choice: ");
				
				if (choice == 1) {
					
					Category name = categoryName();
					C206_CaseStudy.addCategory(listOfCategories, name);
					
					
				} else if (choice == 2) {
					
					C206_CaseStudy.viewCategory(listOfCategories);
					
				} else if (choice == 3) {
					
					
					
				}
					
			}
			
		}
		
	}
	
	public static void header(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void menu() {
		System.out.println("AUCTION APP");
		System.out.println("1. User account");
		System.out.println("2. Category");
		System.out.println("3. Item");
		System.out.println("4. Bid");
		System.out.println("5. Deal");
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}
	
	//Viewing all categories
	public static String retrieveCategories(ArrayList<Category> listOfCategories) {
		String output = "";
		for (int i = 0; i < listOfCategories.size(); i++) {
			output += String.format("%-5s \n", listOfCategories.get(i).getName());
		}
		return output;
	}
	
	public static void viewCategory(ArrayList<Category> listOfCategories) {
		C206_CaseStudy.header("LIST OF CATEGORIES");
		String output = String.format("%-5s \n", "NAME");
		output += retrieveCategories(listOfCategories);
		System.out.println(output);
	}
	
	//Adding the category
	public static Category categoryName() {
		String name = Helper.readString("Enter name for new category: ");
		Category newCategory = new Category(name);
		return newCategory;
	}
	
	public static void addCategory(ArrayList<Category> listOfCategories, Category newCategory) {
		listOfCategories.add(newCategory);
		System.out.println("Category has been added!");
	}
	
	
	
	
	

	}

