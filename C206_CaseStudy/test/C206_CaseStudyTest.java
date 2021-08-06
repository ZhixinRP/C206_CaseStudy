import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private deal d1;
	private deal d2;
	private ArrayList<deal> dealList;
	private ArrayList<bid> bidList;
	@Before
	public void setUp() throws Exception {
		// prepare test data
		d1 = new deal(1, "VIVO HDR-ZX605", "pear@gmail.com","buyer1@gmail.com",20.50,"4/8/2021");
		d2 = new deal(2, "Sony HDR-CX405", "apple@gmail.com","buyer2@gmail.com", 40.50,"5/8/2021");
		dealList = new ArrayList<deal>();
		// Dummy bid data for add
		bidList = new ArrayList<bid>();
		bidList.add(new bid(1, "Sony HDR-CX405", "apple@gmail.com","buyer1@gmail.com", 20.50));
		bidList.add(new bid(2, "Sony HDR-CX405", "apple@gmail.com","buyer2@gmail.com", 40.50));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addDealTest() {
		// Deal list is not null, so that can add a new deal
		assertNotNull("Check if there is valid deal arraylist to add to", dealList);
		
		//Given an empty list, after adding 1 deal, the size of the list is 1
		//The deal just added is as same as the first deal of the list
		C206_CaseStudy.addDeal(dealList, d1);
		assertEquals("Check that deal arraylist size is 1", 1, dealList.size());
		assertSame("Check that deal is added", d1, dealList.get(0));
		
		//Add another deal. test The size of the list is 2?
		//The deal just added is as same as the second deal of the list
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Check that deal arraylist size is 2", 2, dealList.size());
		assertSame("Check that deal is added", d2, dealList.get(1));
		
		//Validate for highest that highest bider get the deal
		assertTrue(C206_CaseStudy.validateDeal(bidList,d2));
		C206_CaseStudy.doValidateDeal(C206_CaseStudy.validateDeal(bidList,d2));
		assertSame("Check that deal is validated and added", d2,dealList.get(1));
	}
	
	@Test
	public void retrieveAllDealTest() {
		
		// Test if deal list is not null but empty -boundary
		assertNotNull("Test if there is valid deal arraylist to retrieve deal", dealList);
		
		//test if the list of deals retrieved from the C206_CaseStudy is empty - boundary
		String allDeals = C206_CaseStudy.retrieveAllDeal(dealList);
		String testOutput = "";
		assertEquals("Check that ViewAllDeallist is empty", testOutput, allDeals);
		
		//Given an empty list, after adding 2 deals, test if the size of the list is 2 - normal
		C206_CaseStudy.addDeal(dealList, d1);
		C206_CaseStudy.addDeal(dealList, d2);
		assertEquals("Test that deal arraylist size is 2", 2, dealList.size());
		
		//test if the expected output string same as the list of deals retrieved from C206_CaseStudy	
		allDeals = C206_CaseStudy.retrieveAllDeal(dealList);
		testOutput = String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n","1", "VIVO HDR-ZX605", "pear@gmail.com","buyer1@gmail.com","20.50","4/8/2021");
		testOutput += String.format("%-10s %-20s %-20s %-20s %-20s %-10s\n","2","Sony HDR-CX405", "apple@gmail.com","buyer2@gmail.com","40.50","5/8/2021");

		assertEquals("Test that ViewAllDeallist is the same", testOutput, allDeals);
		
	}
	
	@Test
	public void deleteDealTest() {

	}

}
