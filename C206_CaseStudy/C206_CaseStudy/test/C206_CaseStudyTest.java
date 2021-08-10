import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// =============Deal
	private deal d1;
	private deal d2;
	private ArrayList<deal> dealList;
	private ArrayList<bid> bidList1;
	// =============BID
	private BidDetails bd1;
	private BidDetails bd2;
	private ArrayList<BidDetails> bidList;
	// =============Item
	private ArrayList<Item> itemsList;
	private Item object1;
	private Item object2;
	// =============Category
	private Category C1;
	private Category C2;
	private ArrayList<Category> listOfCategories;
	// =============Customer
	private Customer c1;
	private Customer c2;

	private ArrayList<Customer> customerList;

	String name = "1";
	String email = "1@gmail.com";
	String password = "1";
	String role = "admin";

	@Before
	public void setUp() throws Exception {
		// ==========DEAL
		// prepare test data
		d1 = new deal(1, "VIVO HDR-ZX605", "pear@gmail.com", "buyer1@gmail.com", 20.50, "4/8/2021");
		d2 = new deal(2, "Sony HDR-CX405", "apple@gmail.com", "buyer2@gmail.com", 40.50, "5/8/2021");
		dealList = new ArrayList<deal>();
		// Dummy bid data for add
		bidList1 = new ArrayList<bid>();
		bidList1.add(new bid(1, "Sony HDR-CX405", "apple@gmail.com", "buyer1@gmail.com", 20.50));
		bidList1.add(new bid(2, "Sony HDR-CX405", "apple@gmail.com", "buyer1@gmail.com", 30.50));
		bidList1.add(new bid(3, "Sony HDR-CX405", "apple@gmail.com", "buyer2@gmail.com", 40.50));
		// =======BID
		bd1 = new BidDetails(21217830, "wearenice34@gmail.com", "hellobuyer@gmail.com", 1112345, "Table");
		bd2 = new BidDetails(21217831, "wearenice35@gmail.com", "hellobuyer1@gmail.com", 1112432, "Chair");
		bidList = new ArrayList<BidDetails>();
		// ===========Item
		object1 = new Item("2B Pencil", "A wooden 2B Pencil.", 2, "27-07-21", "01-08-21");
		object2 = new Item("Laptop Case", "A slightly used laptop case in good condition.", 2, "5-08-21", "10-10-21");
		itemsList = new ArrayList<Item>();
		// ==========Category
		C1 = new Category("Mouse");
		C2 = new Category("Laptops");
		listOfCategories = new ArrayList<Category>();
		// ==============Customer
		c1 = new Customer("1", "1@gmail.com", "one", "admin");
		c2 = new Customer("2", "2@gmail.com", "two", "customer");

		customerList = new ArrayList<Customer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	// ========================Customer======================//
	@Test
	public void testAddCustomer() {
		assertNotNull("Test if there is valid Customer arraylist to add to", customerList);
		C206_CaseStudy.addCustomer(customerList, c1);
		assertEquals("Test if that Customer arraylist size is 1?", 1, customerList.size());
		assertSame("Test that Customer is added same as 1st item of the list?", c1, customerList.get(0));
		C206_CaseStudy.addCustomer(customerList, c2);
		assertEquals("Test that Customer arraylist size is 2?", 2, customerList.size());
	}

	@Test
	public void testDeleteCustomer() {
		C206_CaseStudy.addCustomer(customerList, c1);
		C206_CaseStudy.addCustomer(customerList, c2);
		assertEquals("Test if that Customer arraylist size is 2?", 2, customerList.size());
		C206_CaseStudy.deleteCustomer(customerList, email);
		assertEquals("Test if that Customer arraylist size is 1?", 1, customerList.size());
	}

	@Test
	public void testViewAllCustomer() {
		C206_CaseStudy.addCustomer(customerList, c1);
		C206_CaseStudy.addCustomer(customerList, c2);

		String allCustomer = C206_CaseStudy.retrieveAllCustomer(customerList);

		String testOutput = "";

		testOutput = String.format("%-10s %-20s %-10s\n", "1", "1@gmail.com", "admin");
		testOutput += String.format("%-10s %-20s %-10s\n", "2", "2@gmail.com", "customer");

		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCustomer);
	}

	// ========================Category======================//
	@Test
	public void addCategoryTest() {
		// Category list is not null, so that can add a new category
		assertNotNull("Check if there is valid Category arraylist to add to", listOfCategories);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addCategory(listOfCategories, C1);
		assertEquals("Check that Category arraylist size is 1", 1, listOfCategories.size());
		assertSame("Check that Category is added", C1, listOfCategories.get(0));

		// Add another Category test The size of the list is 2?
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addCategory(listOfCategories, C2);
		assertEquals("Check that Category arraylist size is 2", 2, listOfCategories.size());
		assertSame("Check that Category is added", C2, listOfCategories.get(1));
	}

	@Test
	public void retrieveAllCategoryTest() {
		// Test if Category list is not null but empty
		assertNotNull("Test if there is valid Category arraylist to retrieve item", listOfCategories);

		// test if the list of Category retrieved from the SourceCentre is empty
		String viewCategory = C206_CaseStudy.retrieveCategories(listOfCategories);
		String testOutput = "";
		assertEquals("Check that ViewAllCategorylist", testOutput, viewCategory);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addCategory(listOfCategories, C1);
		C206_CaseStudy.addCategory(listOfCategories, C2);
		assertEquals("Test that Category arraylist size is 2", 2, listOfCategories.size());

		// test if the expected output string same as the list of categories retrieved
		// from the SourceCentre
		viewCategory = C206_CaseStudy.retrieveCategories(listOfCategories);
		testOutput = String.format("%-5s \n", "Mouse");
		testOutput += String.format("%-5s \n", "Laptops");

		// assertEquals("Test that ViewAllCategoryList", testOutput, viewCategory);

	}

	@Test
	public void deleteCategoryTest() {
		// fail("Not yet implemented");
		// write your code here

		C206_CaseStudy.addCategory(listOfCategories, C1);
		C206_CaseStudy.addCategory(listOfCategories, C2);
		assertTrue(listOfCategories.get(0).isAvailableName());
		C206_CaseStudy.deleteCategory(listOfCategories, "Mouse");

		// System.out.println("Deleted " + listOfCategories.get(0).isAvailableName());
		assertEquals("Laptop", 1, listOfCategories.size());

		assertEquals("Laptops", listOfCategories.get(0).getName());
	}

	// ======================Item==========================//
	public void addItemTest() {
		// Test if itemsList is not null, so that a new item can be added in.
		assertNotNull(itemsList);

		// Add an item into the list.
		// Then check that the size of the list has increased by 1.
		// Check if the item inserted into the list is the same as the one just added
		// in.
		C206_CaseStudy.addItem(itemsList, object1);
		assertEquals(1, itemsList.size());
		assertSame(object1, itemsList.get(0));

		// Add an item into the list.
		// Then check that the size of the list has increased by 1.
		// Check if the item inserted into the list is the same as the one just added
		// in.
		C206_CaseStudy.addItem(itemsList, object2);
		assertEquals(2, itemsList.size());
		assertSame(object2, itemsList.get(1));

	}

	public void viewAllItemsTest() {

		// Test if ItemList is null or not.
		assertNotNull(itemsList);

		// Retrieve all items and display them
		String output = C206_CaseStudy.retrieveAllItems(itemsList);
		C206_CaseStudy.viewAllItems(itemsList);

	}

	public void deleteSearchedItemTest() {

		// Test if ItemList is null or not.
		assertNotNull(itemsList);

		// Add two items into the list
		itemsList.add(object1);
		itemsList.add(object2);

		// Check if they have been added into the arraylist by checking if the size of
		// the arraylist is 2
		assertEquals(2, itemsList.size());

		// Remove the first item and check if it gets deleted by checking if the size of
		// the list is now 1
		itemsList.remove(0);
		assertEquals(1, itemsList.size());

		// Repeat the steps and remove the list
		itemsList.remove(0);
		assertEquals(1, itemsList.size());

	}

	// ====================BID=============================//
	@Test
	public void testAddBid() {
		// fail("Not yet implemented");
		// Item list is not null, so that can add a new its
		assertNotNull("Test if there is valid Bid arraylist to add to", bidList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBid(bidList, bd1);
		assertEquals("Test if that Bid arraylist size is 1?", 1, bidList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that bid is added same as 1st item of the list?", bd1, bidList.get(0));

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addBid(bidList, bd2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, bidList.size());
		assertSame("Test that bid is added same as 2ndt item of the list?", bd2, bidList.get(0));

		int O1 = bidList.get(0).getBidId();
		int O2 = bidList.get(0).getBid();
		assertSame("Test that retrieved bid is the same as bid id", 01, 02);

		String n1 = bidList.get(0).getItemName();
		assertSame("Test if item name is for retrieved bid ", 01, n1);

		String v1 = bidList.get(0).getSellerEmail();
		assertSame("Test if seller email is for retrieved bid", 01, v1);

		boolean msg = C206_CaseStudy.displayBidMsg();

		if (bd1 == null) {

			assertTrue(msg);

		} else {
			assertFalse(msg);
		}

	}

	@Test
	public void testRetrieveAllBids() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid bid arraylist to add to", bidList);

		// test if the list of bds retrieved from the SourceCentre is empty
		String allBids = C206_CaseStudy.retrieveAllBids(bidList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allBids);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addBid(bidList, bd1);
		C206_CaseStudy.addBid(bidList, bd2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, bidList.size());

		// test if the expected output string same as the list of bid retrieved from the
		// SourceCentre
//		allBids=  C206_CaseStudy.retrieveAllBids(bidList);
//
//		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","21217830", "wearenice34@gmail.com", "hellobuyer@gmail.com" , "1112345", "Table");
//		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","21217831", "wearenice35@gmail.com", "hellobuyer1@gmail.com" , "1112432", "Chair");
//	
//		assertEquals("Check that ViewAllCamcorderlist", testOutput, allBids);

	}

	@Test
	public void testDeleteBid() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid bid arraylist to add to", bidList);

		boolean d1 = C206_CaseStudy.deleteBid(bidList);
		boolean msg = C206_CaseStudy.displayBidMsg();

		if (bd1 == null) {

			assertTrue(d1);
			assertFalse(msg);

		} else {
			assertFalse(d1);
			assertTrue(msg);
		}

	}

	// ====================DEAL============================//
	@Test
	public void addDealTest() {
		// Deal list is not null, so that can add a new deal
		assertNotNull("Check if there is valid deal arraylist to add to", dealList);

		// Given an empty list, after adding 1 deal, the size of the list is 1
		// The deal just added is as same as the first deal of the list
		C206_CaseStudy.addDeal(dealList, d1);
		assertEquals("Check that deal arraylist size is 1", 1, dealList.size());
		assertSame("Check that deal is added", d1, dealList.get(0));

		// Add another deal. test The size of the list is 2?
		// The deal just added is as same as the second deal of the list
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Check that deal arraylist size is 2", 2, dealList.size());
		assertSame("Check that deal is added", d2, dealList.get(1));

		// Validate that only the highest bider gets the deal for an item
		assertTrue(C206_CaseStudy.validateDeal(bidList1, d2));
		C206_CaseStudy.doValidateDeal(C206_CaseStudy.validateDeal(bidList1, d2));
		assertSame("Check that deal is validated and added", d2, dealList.get(1));
	}

	@Test
	public void retrieveAllDealTest() {

		// Test if deal list is not null but empty -boundary
		assertNotNull("Test if there is valid deal arraylist to retrieve deal", dealList);

		// test if the list of deals retrieved from the C206_CaseStudy is empty -
		// boundary
		String allDeals = C206_CaseStudy.retrieveAllDeal(dealList);
		String testOutput = "";
		assertEquals("Check that ViewAllDeallist is empty", testOutput, allDeals);

		// Given an empty list, after adding 2 deals, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addDeal(dealList, d1);
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Test that deal arraylist size is 2", 2, dealList.size());

		// test if the expected output string same as the list of deals retrieved from
		// C206_CaseStudy
		allDeals = C206_CaseStudy.retrieveAllDeal(dealList);
		testOutput = String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n", "1", "VIVO HDR-ZX605", "pear@gmail.com",
				"buyer1@gmail.com", "20.50", "4/8/2021");
		testOutput += String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n", "2", "Sony HDR-CX405", "apple@gmail.com",
				"buyer2@gmail.com", "40.50", "5/8/2021");

		assertEquals("Test that ViewAllDeallist is the same", testOutput, allDeals);

	}

	@Test
	public void deleteDealTest() {
		// boundary
		assertNotNull("Test if there is valid deal arraylist to add to", dealList);
		// ADD deal id 1 to test
		C206_CaseStudy.addDeal(dealList, d1);

		// error
		Boolean isDeleted = C206_CaseStudy.doDeleteDeal(dealList, 1);
		assertFalse("Test if deal id 1 is deleted", isDeleted);

		// normal
		C206_CaseStudy.deleteDeal(dealList, 1); // Delete deal id 1
		System.out.println(C206_CaseStudy.retrieveAllDeal(dealList));
		isDeleted = C206_CaseStudy.doDeleteDeal(dealList, 1);
		assertTrue("Test if deal id 1 is deleted", isDeleted);

	}

	@Test
	public void searchDealTest() {
		// boundary
		assertNotNull("Test if there is valid deal arraylist to search fromm", dealList);
		// ADD deals to test
		C206_CaseStudy.addDeal(dealList, d1);
		C206_CaseStudy.addDeal(dealList, d2);

		// Error - Cannot find deal's item name from deal list
		Boolean isFound = C206_CaseStudy.searchDeal(dealList, "test123");
		assertFalse("Test if keyword test123 is found", isFound);

		// Normal - Can find deal's item name from deal list
		// Display search result
		isFound = C206_CaseStudy.searchDeal(dealList, "Sony");
		assertTrue("Test if keyword Sony is found", isFound);

	}

}
