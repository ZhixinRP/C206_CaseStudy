import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//=============Category===============
	private Category C1;
	private Category C2;
	private ArrayList<Category> listOfCategories;
	
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// =========Category==========
		C1 = new Category("Mouse");
		C2 = new Category("Laptops");
		listOfCategories = new ArrayList<Category>();
	}
	
	@Test
	 public void addCategoryTest() {
	  // Category list is not null, so that can add a new category
	  assertNotNull("Check if there is valid Category arraylist to add to", listOfCategories);
	  //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	  //The item just added is as same as the first item of the list
	  C206_CaseStudy.addCategory(listOfCategories, C1);
	  assertEquals("Check that Category arraylist size is 1", 1, listOfCategories.size());
	  assertSame("Check that Category is added", C1, listOfCategories.get(0));
	  
	  //Add another Category test The size of the list is 2? 
	  //The item just added is as same as the second item of the list
	  C206_CaseStudy.addCategory(listOfCategories, C2);
	  assertEquals("Check that Category arraylist size is 2", 2, listOfCategories.size());
	  assertSame("Check that Category is added", C2, listOfCategories.get(1));
	 }

	  @Test
	  public void retrieveAllCategoryTest() {
	    // Test if Category list is not null but empty 
	    assertNotNull("Test if there is valid Category arraylist to retrieve item", listOfCategories);
	    
	    //test if the list of Category retrieved from the SourceCentre is empty 
	    String viewCategory= C206_CaseStudy.retrieveCategories(listOfCategories);
	    String testOutput = "";
	    assertEquals("Check that ViewAllCategorylist", testOutput, viewCategory);
	    
	    //Given an empty list, after adding 2 items, test if the size of the list is 2 
	    C206_CaseStudy.addCategory(listOfCategories, C1);
	    C206_CaseStudy.addCategory(listOfCategories, C2);
	    assertEquals("Test that Category arraylist size is 2", 2, listOfCategories.size());
	    
	    //test if the expected output string same as the list of categories retrieved from the SourceCentre  
	    viewCategory= C206_CaseStudy.retrieveCategories(listOfCategories);
	    testOutput = String.format("%-5s \n", "Mouse");
	    testOutput += String.format("%-5s \n","Laptops" );
	  
	    //assertEquals("Test that ViewAllCategoryList", testOutput, viewCategory);
	    
	  }

	@Test
	  public void deleteCategoryTest() {
	    //fail("Not yet implemented");
	    // write your code here
	    
	    C206_CaseStudy.addCategory(listOfCategories,C1);
	    C206_CaseStudy.addCategory(listOfCategories,C2);
	    assertTrue(listOfCategories.get(0).isAvailableName());
	    C206_CaseStudy.deleteCategory(listOfCategories, "Mouse");
	    
	    //System.out.println("Deleted " + listOfCategories.get(0).isAvailableName());
	    assertEquals("Laptop",1,listOfCategories.size());
	    
	    assertEquals("Laptops",listOfCategories.get(0).getName());
	  }
	
	@After
	public void tearDown() throws Exception {
		//================Category=================
		C1 = null;
	    C2 = null;
	    listOfCategories = null;
	}

}
