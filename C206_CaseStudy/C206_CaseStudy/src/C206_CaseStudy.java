import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<deal> dealList = new ArrayList<deal>();
		// ===DUMMY BIDS===//
		// Bid
		ArrayList<BidDetails> bidList = new ArrayList<BidDetails>();
		bidList.add(
				new BidDetails(40000, "nemo123@gmail.com", "seller22@gmail.com", 000012345, "Limited Edition Shoes"));
		// Item
		ArrayList<Item> itemsList = new ArrayList<Item>();
		// Category
		ArrayList<Category> listOfCategories = new ArrayList<Category>();
		// ===========================MENU===========================//
		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllDeal(dealList);
			} else if (option == 2) {
				// Add a new deal
				C206_CaseStudy.setHeader("ADD DEAL");
				deal d1 = inputDeal();
				C206_CaseStudy.addDeal(dealList, d1);
			} else if (option == 3) {
				// Delete a deal
				C206_CaseStudy.setHeader("DELETE DEAL");
				int d2 = inputDealId(dealList);
				C206_CaseStudy.deleteDeal(dealList, d2);
			} else if (option == 4) {
				// QUIT
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("C206_CaseStudy");
		System.out.println("1. Display All Deals");
		System.out.println("2. Add deal");
		System.out.println("3. Delete deal");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// =========== Sprint 1 =======================================//
	// ============================================Customer=====================================//
	public static Customer inputCustomer() {
		String role = "";
		String name = Helper.readString("Enter name > ");
		String email = Helper.readString("Enter email > ");
		String password = Helper.readString("Enter password > ");
		char admin = Helper.readChar("Is this user an admin(Y/N) > ");
		if (admin == 'Y') {
			role = "admin";
		} else if (admin == 'N') {
			role = "customer";
		} else {
			role = "invaild";
		}

		Customer customer = new Customer(name, email, password, role);

		return customer;

	}

	public static void addCustomer(ArrayList<Customer> customerList, Customer customer) {
		if (customer.getName().isEmpty() || customer.getEmail().isEmpty() || customer.getPassword().isEmpty()
				|| customer.getRole().equals("invaild")) {
			System.out.println("Invaild fields are entered");
		} else {
			customerList.add(customer);
			System.out.println("User has been added");
		}
		Helper.line(30, "~");
	}

	public static String retrieveAllCustomer(ArrayList<Customer> customerList) {
		String output = "";

		if (customerList.size() != 0) {
			for (int i = 0; i < customerList.size(); i++) {

				output += String.format("%-10s %-20s %-10s\n", customerList.get(i).getName(),
						customerList.get(i).getEmail(), customerList.get(i).getRole());
			}
		}
		return output;
	}

	public static void viewAllCustomer(ArrayList<Customer> customerList) {
		if (customerList.size() == 0) {
			System.out.println("No customer/admin has been addded");
		} else {
			Helper.line(30, "~");
			System.out.println("CAMCORDER LIST");
			Helper.line(30, "~");
			String output = String.format("%-10s %-20s %-10s\n", "NAME", "EMAIL", "PASSWORD");
			output += retrieveAllCustomer(customerList);
			System.out.println(output);
		}
	}

//	public static void viewAllCustomer(ArrayList<Customer> customerList) {
//		Helper.line(30, "~");
//		if (customerList.size() == 0) {
//			System.out.println("There is no customer");
//			Helper.line(30, "~");
//		}
//		for (int i = 0; i < customerList.size(); i++) {
//			System.out.println("Name: " + customerList.get(i).getName());
//			System.out.println("Email: " + customerList.get(i).getEmail());
//			System.out.println("Role: " + customerList.get(i).getRole());
//			Helper.line(30, "~");
//		}
//	}	

	public static void deleteCustomer(ArrayList<Customer> customerList, String email) {
		int delete = 0;
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getEmail().equals(email)) {
				delete++;
				customerList.remove(i);
			}
		}
		if (delete == 0) {
			System.out.println("No user found with the email " + email);
		} else {
			System.out.println("The user with the email " + email + " has been deletd");
		}
	}

	// =============================================================CATEGORY====================================================================
	// MENU
	public static void menuCategory() {
		System.out.println("1. Add new Category");
		System.out.println("2. View all Categories");
		System.out.println("3. Delete Category");
		Helper.line(80, "-");

	}

	// VIEW
	public static String retrieveCategories(ArrayList<Category> listOfCategories) {
		String output = "";
		for (int i = 0; i < listOfCategories.size(); i++) {
			output += String.format("%-5s \n", listOfCategories.get(i).getName());
		}
		return output;
	}

	public static void viewCategory(ArrayList<Category> listOfCategories) {
		C206_CaseStudy.setHeader("LIST OF CATEGORIES");
		String output = String.format("%-5s \n", "NAME");
		output += retrieveCategories(listOfCategories);
		System.out.println(output);
	}

	// ADD
	private static Category categoryName() {
		String name = Helper.readString("Enter name for new category: ");
		Category newCategory = new Category(name);
		return newCategory;
	}

	public static void addCategory(ArrayList<Category> listOfCategories, Category newCategory) {
		listOfCategories.add(newCategory);
		System.out.println("Category has been added!");
	}

	// DELETE
	public static void categoryDeleteInput(ArrayList<Category> listOfCategories) {
		C206_CaseStudy.viewCategory(listOfCategories);
		String name = Helper.readString("Enter category name that you want to delete: ");
		Boolean successful = deleteCategory(listOfCategories, name);
		if (successful == true) {
			System.out.println("'" + name + "'" + " category" + " has been successfully delted");
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
	// ==============================Item=========================//
	// ADD ITEM

	public static Item inputItem() {
		String name = Helper.readString("Enter in item name: ");
		String description = Helper.readString("Enter in item description: ");
		int minBidPrice = Helper.readInt("Enter in minimum bid price: ");
		String auctionStart = Helper.readString("Enter in the starting date of the auction: ");
		String auctionEnd = Helper.readString("Enter in the ending date of the auction: ");

		Item item = new Item(name, description, minBidPrice, auctionStart, auctionEnd);
		return item;
	}

	public static void addItem(ArrayList<Item> itemsList, Item item) {

		itemsList.add(item);
		System.out.print("Item has been added!");
	}

	// DISPLAY ALL ITEMS

	public static String retrieveAllItems(ArrayList<Item> itemsList) {

		String output = "";

		for (int i = 0; i < itemsList.size(); i++) {

			output += String.format("%-10s %-30s %-10d\n %-10s %-20s", itemsList.get(i).getItemName(),
					itemsList.get(i).getItemDescription(), itemsList.get(i).getMinBidPrice(),
					itemsList.get(i).getAuctionStart(), itemsList.get(i).getAuctionEnd());

		}
		return output;
	}

	public static void viewAllItems(ArrayList<Item> itemsList) {
		C206_CaseStudy.setHeader("ALL ITEM LISTINGS");

		String output = String.format("%-10s %-30s %-10s\n %-10s %-20s", "ITEM NAME", "ITEM DESCRIPTION",
				"MINIMUM BID PRICE", "AUCTION START DATE", "AUCTION END DATE");
		output += retrieveAllItems(itemsList);
		System.out.print(output);

	}

	// DELETE ITEM BASED ON NAME

	public static void deleteItemInput(ArrayList<Item> itemsList) {

		String name = Helper.readString("Enter in the name of the item you wish to delete: ");

		boolean deleteSuccessful = deleteSearchedItem(itemsList, name);

		if (deleteSuccessful == true) {

			System.out.println("Item " + name + " has been successfully deleted!");

		} else {

			System.out.println("Delete was not successful/Invalid item name!");

		}

	}

	public static boolean deleteSearchedItem(ArrayList<Item> itemsList, String name) {

		boolean isFound = false;

		for (int i = 0; i < itemsList.size(); i++) {

			String itemName1 = itemsList.get(i).getItemName();

			if (name.equalsIgnoreCase(itemName1) == true) {

				itemsList.remove(i);

				isFound = true;
			}

		}
		return isFound;
	}

	// ============================BID============================//
	public static String retrieveAllBids(ArrayList<BidDetails> bidList) {
		String output = "";

		for (int i = 0; i < bidList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", bidList.get(i).getBid(),
					bidList.get(i).getEmail(), bidList.get(i).getSellerEmail(), bidList.get(i).getBidId(),
					bidList.get(i).getItemName());
		}
		return output;
	}

	public static void viewAllBids(ArrayList<BidDetails> bidList) {
		C206_CaseStudy.setHeader("BID LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "BID", "EMAIL", "SELLER'S EMAIL ", "BID ID",
				"ITEM NAME");
		output += retrieveAllBids(bidList);
		System.out.println(output);
	}

	public static boolean deleteBid(ArrayList<BidDetails> bidList) {

		boolean cfm = false;

		int bidAmt = Helper.readInt("What is the bid amount you would like to delete ?");

		for (int i = 0; i < bidList.size(); i++) {
			if (bidList.contains(bidAmt)) {
				bidList.remove(bidAmt);
				C206_CaseStudy.displayDeleteMsg();
				return true;
			}

		}
		System.out.println("Bid in valid");
		return cfm;

	}

	public static BidDetails inputBid() {
		int bid = Helper.readInt("Enter bid amount> ");
		String email = Helper.readString("Enter email> ");
		String sellerE = Helper.readString("Enter seller's email");
		int bidId = Helper.readInt("Enter bid id");
		String itemName = Helper.readString("Enter item name");
		if (bid == 0) {
			C206_CaseStudy.displayBidMsg();
		} else if (email == null) {
			C206_CaseStudy.displayBidMsg();
		}

		BidDetails cc = new BidDetails(bid, email, sellerE, bidId, itemName);
		return cc;

	}

	public static void addBid(ArrayList<BidDetails> bidList, BidDetails cc) {

		bidList.add(cc);
		System.out.println("bid added");
	}

	public static int getBidId(ArrayList<BidDetails> bidList, BidDetails cc) {
		int o1 = bidList.get(0).getBidId();
		return o1;
	}

	public static boolean displayBidMsg() {

		System.out.println("Bid invalid");
		return false;
	}

	public static void displayDeleteMsg() {

		System.out.println("Bid Successfully Deleted");

	}

	// ==========================DEAL=============================//
	// =========== Show all deals =================================//
	public static String retrieveAllDeal(ArrayList<deal> dealList) {
		String output = "";

		for (int i = 0; i < dealList.size(); i++) {

			output += String.format("%-10d %-20s %-20s %-20s %-20.2f %-10s\n", dealList.get(i).getDealId(),
					dealList.get(i).getItemName(), dealList.get(i).getSellerEmail(), dealList.get(i).getBuyerEmail(),
					dealList.get(i).getTransactionPrice(), dealList.get(i).getCloseDate());
		}
		return output;
	}

	public static void viewAllDeal(ArrayList<deal> dealList) {
		String output = "DEAL LIST\n";
		output += String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n", "ID", "ITEM NAME", "SELLER EMAIL",
				"BUYER EMAIL", "TRANSACTION PRICE", "CLOSE DATE");
		output += retrieveAllDeal(dealList);
		System.out.println(output);
	}

	// =========== Add deal ==================================//
	public static deal inputDeal() {
		int dealID = Helper.readInt("Enter deal ID > ");
		String itemName = Helper.readString("Enter item name > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double transPrice = Helper.readDouble("Enter transcation price > ");
		String closeDate = Helper.readString("Enter close date > ");

		deal dl = new deal(dealID, itemName, sellerEmail, buyerEmail, transPrice, closeDate);
		return dl;
	}

	public static void addDeal(ArrayList<deal> dealList, deal dl) {
		dealList.add(dl);
		System.out.println("Deal added");
	}

	// =========== Delete deal =================================//

	public static int inputDealId(ArrayList<deal> dealList) {
		int deleteIndex = Helper.readInt("Enter deal ID > ");
		return deleteIndex;
	}

	// Delete deal
	public static void deleteDeal(ArrayList<deal> dealList, int id) {
		int index = id - 1;
		dealList.remove(index);
		System.out.println("Deal successfully deleted!");
	}

	// Checks deal has been deleted from arraylist
	public static boolean doDeleteDeal(ArrayList<deal> dealList, int index) {
		boolean isDeleted = true;
		for (int i = 0; i < dealList.size(); i++) {
			if (dealList.get(i).getDealId() == index) {
				isDeleted = false;
			}
		}
		return isDeleted;
	}

	// ================Validate deal===========================//
	public static boolean validateDeal(ArrayList<bid> bidList1, deal dl) {
		double highestBid = 0.0;
		String highestBidderEmail = "";
		String sellerEmail = "";
		String itemName = "";
		// Get the highest bid in dummy bid array
		for (int i = 0; i < bidList1.size(); i++) {
			if (bidList1.get(i).getBidPrice() > highestBid) {
				highestBid = bidList1.get(i).getBidPrice();
				highestBidderEmail = bidList1.get(i).getBuyerEmail();
				sellerEmail = bidList1.get(i).getSellerEmail();
				itemName = bidList1.get(i).getItemName();
			}
		}
		// Check transaction price, buyer email, seller email and item name matches with
		// the highest bidder
		if (highestBid == dl.getTransactionPrice() && highestBidderEmail == dl.getBuyerEmail()
				&& sellerEmail == dl.getSellerEmail() && itemName == dl.getItemName()) {
			return true;
		} else {
			return false;
		}
	}

	public static void doValidateDeal(boolean isValidated) {
		if (isValidated == true) {
			System.out.print("Deal has been validated");
		} else {
			System.out.print("Deal is not validated");
		}
	}

	// =========== Sprint 2 ===================================//

	// =========== Search deal =================================//

	public static boolean searchDeal(ArrayList<deal> dealList, String searchKeyword) {
		int findIndex = 0;
		for (int i = 0; i < dealList.size(); i++) {
			if (dealList.get(i).getItemName().toString().contains(searchKeyword)) {
				findIndex = i;
			}
		}
		if (findIndex != 0) {
			System.out.println("Deals found!");
			getDealDetails(dealList, findIndex);
			return true;
		} else {
			System.out.println("No Deals found!");
			return false;
		}
	}

	public static void getDealDetails(ArrayList<deal> dealList, int index) {
		String output = "";
		output += String.format("%-10d %-20s %-20s %-20s %-20.2f %-10s\n", dealList.get(index).getDealId(),
				dealList.get(index).getItemName(), dealList.get(index).getSellerEmail(),
				dealList.get(index).getBuyerEmail(), dealList.get(index).getTransactionPrice(),
				dealList.get(index).getCloseDate());

		System.out.println(output);
	}

}
