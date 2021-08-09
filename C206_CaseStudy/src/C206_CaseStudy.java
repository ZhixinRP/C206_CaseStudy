import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Category> listOfCategories = new ArrayList<Category>();
		
		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

			} else if (option == 2) {
				
				C206_CaseStudy.menuCategory();
				int choice = Helper.readInt("Enter your choice: ");
				
		        if (choice == 1) {
		            
		            Category name = categoryName();
		            C206_CaseStudy.addCategory(listOfCategories, name);
		            
		            
		          } else if (choice == 2) {
		            
		            C206_CaseStudy.viewCategory(listOfCategories);
		            
		          } else if (choice == 3) {
		            
		            C206_CaseStudy.viewCategory(listOfCategories);
		            C206_CaseStudy.categoryDeleteInput(listOfCategories);
		            
		          } else {
		            
		            System.out.println("Invalid option number");
		            
		          }

			} else if (option == 3) {

			} else if (option == 4) {

			} else if (option == 5) {
				
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
	// =============================================================CATEGORY====================================================================
	//MENU
	public static void menuCategory() {
		System.out.println("1. Add new Category");
		System.out.println("2. View all Categories");
		System.out.println("3. Delete Category");
		Helper.line(80, "-");

	}
	
	//VIEW
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
	
	//ADD
	private static Category categoryName() {
		String name = Helper.readString("Enter name for new category: ");
		Category newCategory = new Category(name);
		return newCategory;
	}
	
	public static void addCategory(ArrayList<Category> listOfCategories, Category newCategory) {
		listOfCategories.add(newCategory);
		System.out.println("Category has been added!");
	}
	
	//DELETE
	public static void categoryDeleteInput(ArrayList<Category> listOfCategories) {
		C206_CaseStudy.viewCategory(listOfCategories);
		String name = Helper.readString("Enter category name that you want to delete: ");
		Boolean successful = deleteCategory(listOfCategories, name);
		if (successful ==  true) {
			System.out.println("'" +  name + "'" + " category" + " has been successfully delted");
		} else {
			System.out.println("Invalid category name entered");
		}
		
		
	}
	public static Boolean deleteCategory(ArrayList<Category> listOfCategories, String name) {
		boolean successful = false;
		for (int i = 0; i < listOfCategories.size(); i++) {
			String categoryName = listOfCategories.get(i).getName();
			if (listOfCategories.get(i).isAvailableName() == true && name.equalsIgnoreCase(categoryName)) {
				listOfCategories.remove(i);
				successful = true;
			}
		}
		return successful;
	}
}
