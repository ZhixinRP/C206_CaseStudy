import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<deal> dealList = new ArrayList<deal>();
		//===DUMMY BIDS===//
		ArrayList<bid> bidList = new ArrayList<bid>();
		
		
		
		
		//================================MENU===========================//
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
				//Delete a deal
				C206_CaseStudy.setHeader("DELETE DEAL");
				int d2 = inputDealId(dealList);
				C206_CaseStudy.deleteDeal(dealList, d2);
			} else if (option == 4) {
				//QUIT
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
	
	//=========== Sprint 1 =======================================//
	
	//=========== Show all deals =================================//
	public static String retrieveAllDeal(ArrayList<deal> dealList) {
		String output = "";

		for (int i = 0; i < dealList.size(); i++) {

			output += String.format("%-10d %-20s %-20s %-20s %-20.2f %-10s\n", dealList.get(i).getDealId(),
					dealList.get(i).getItemName(),
					dealList.get(i).getSellerEmail(), 
					dealList.get(i).getBuyerEmail(),
					dealList.get(i).getTransactionPrice(),
					dealList.get(i).getCloseDate());
		}
		return output;
	}
	
	public static void viewAllDeal(ArrayList<deal> dealList) {
		String output = "DEAL LIST\n";
		output += String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n", "ID","ITEM NAME","SELLER EMAIL","BUYER EMAIL","TRANSACTION PRICE","CLOSE DATE");
		output += retrieveAllDeal(dealList);
		System.out.println(output);
	}

	//===========  Add deal ==================================//
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
	
	
	//=========== Delete deal =================================//
	
	public static int inputDealId(ArrayList<deal> dealList) {
		int deleteIndex = Helper.readInt("Enter deal ID > ");
		return deleteIndex;
	}
	
	public static void deleteDeal(ArrayList<deal> dealList, int index) {
		dealList.remove(index);
		System.out.println("Deal successfully deleted!");
	}
	
	//================Validate deal===========================//
	public static boolean validateDeal(ArrayList<bid> bidList, deal dl) {
		double highestBid = 0.0;
		String highestBidderEmail = "";
		String sellerEmail = "";
		String itemName = "";
		//Get the highest bid in dummy bid array
		for(int i = 0; i < bidList.size(); i++) {
			if(bidList.get(i).getBidPrice() > highestBid) {
				highestBid = bidList.get(i).getBidPrice();
				highestBidderEmail = bidList.get(i).getBuyerEmail();
				sellerEmail = bidList.get(i).getSellerEmail();
				itemName = bidList.get(i).getItemName();
			}
		}
		//Check transaction price, buyer email, seller email and item name matches with the highest bidder
		if (highestBid == dl.getTransactionPrice() && highestBidderEmail == dl.getBuyerEmail() && sellerEmail == dl.getSellerEmail() && itemName == dl.getItemName()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void doValidateDeal(boolean isValidated) {
		if(isValidated == true) {
			System.out.print("Deal has been validated");
		}else {
			System.out.print("Deal is not validated");
		}
	}
	
	
	
	//=========== Sprint 2 ===================================//
	
	//=========== Search deal =================================//
	
	public static int searchDeal(ArrayList<deal> dealList) {
		int findIndex = 0;
		String searchKeyword = Helper.readString("Search > ");
		for(int i=0; i<dealList.size(); i++) {
			if(dealList.get(i).toString().contains(searchKeyword)) {
				findIndex = i;
			}
		}
		
		return findIndex;
	}
	
	public static void showfindDeal(ArrayList<deal> dealList, int findIndex) {
		System.out.println(dealList.get(findIndex));
	}
	
	//=========== Update deal ===============================//
	
	public static deal updateDeal() {
		
		int dealID = Helper.readInt("Enter deal ID > ");
		String itemName = Helper.readString("Enter item name > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double price = Helper.readDouble("Enter transcation price > ");
		String closeDate = Helper.readString("Enter close date > ");
		
		deal updateDL = new deal(dealID, itemName, sellerEmail, buyerEmail, price, closeDate);
		return updateDL;
	}
	
}
