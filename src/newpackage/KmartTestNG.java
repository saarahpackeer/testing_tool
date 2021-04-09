package newpackage;

/*
 * CSIT314 - PROJECT PART 2
 * GROUP NUMBER: 14
 * 
 * ***************************
 * This JUnit test uses TestNG library
 * can be installed using Eclipse Marketplace
 * OR
 * from the link below:
 * https://testng.org/doc/download.html  
 * 
 * */



import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class KmartTestNG {
	
	static WebDriver webDriver;
	WebElement element;

	String registeredEmail = "testing1122@test.com";
	String newEmail = "csit3148@gmail.com";

	String password = "Testing101";
	String errorMessage = "Error:This email address is already registered. To continue, use a different address or call 1800 570 933 for assistance.";

	String[] categories = {"latest","home","electronics","toys","women","men","kids","sports","gifts","clearance"};
    ArrayList<String> elementList = new ArrayList<String>(); 
    String category;
    String x_path;
    String expectedTitle = "";
    String actualTitle = "";
    Actions action;
    int value;
    
    static int productCount=0;
	static int imgCount=0;
	private static ArrayList<String> colour_list = new ArrayList<String>();
	private static ArrayList<String> brand_list = new ArrayList<String>();
	private static ArrayList<String> price_list = new ArrayList<String>();
	private static ArrayList<String> material_list = new ArrayList<String>();
	private static ArrayList<String> packsize_list = new ArrayList<String>();
	private static ArrayList<String> suitableforages_list = new ArrayList<String>();
	private static ArrayList<String> threadcount_list = new ArrayList<String>();
	private static ArrayList<String> machinewashable_list = new ArrayList<String>();
	private static ArrayList<String> reversible_list = new ArrayList<String>();
	private static ArrayList<String> covermaterial_list = new ArrayList<String>();
	private static ArrayList<String> fillmaterial_list = new ArrayList<String>();
	private static ArrayList<String> warmthrating_list = new ArrayList<String>();
	private static ArrayList<String> sizerange_list = new ArrayList<String>();
	private static ArrayList<String> capacity_list = new ArrayList<String>();
	private static ArrayList<String> features_list = new ArrayList<String>();
	private static ArrayList<String> carrier_list = new ArrayList<String>();
	private static ArrayList<String> compatibility_list = new ArrayList<String>();
	private static ArrayList<String> sleevelength_list = new ArrayList<String>();
	private static ArrayList<String> gender_list = new ArrayList<String>();
	private static ArrayList<String> fit_list = new ArrayList<String>();
	private static ArrayList<String> style_list = new ArrayList<String>();
	private static ArrayList<String> formulation_list = new ArrayList<String>();
	private static ArrayList<String> quantity_list = new ArrayList<String>();
	private static ArrayList<String> size_list = new ArrayList<String>();
	private static ArrayList<String> producttype_list = new ArrayList<String>();
	private static ArrayList<String> manufacturer_list = new ArrayList<String>();
	private static ArrayList<String> character_list = new ArrayList<String>();
	private static ArrayList<String> collection_list = new ArrayList<String>();
	private static ArrayList<String> microwavesafe_list = new ArrayList<String>();
	private static ArrayList<String> dishwashersafe_list = new ArrayList<String>();
	private static ArrayList<String> selected_element_list = new ArrayList<String>();
	private static ArrayList<String> getFilterType_list = new ArrayList<String>();
    
    
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");		
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		webDriver.get("https://www.kmart.com.au");
		Thread.sleep(2000);
	}
	
	
	/*
	 * This test creating new account using already regesterd email address
	 * The test will read the error message and return pass
	 * */
	@Test
	public void tryToCreateNewAccountWithRegisteredEmail() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());

		webDriver.findElement(By.id("SignInLink")).click();
		Thread.sleep(2000);

		checkPopUpWin();

		webDriver.findElement(By.id("WC_AccountDisplay_links_3")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_firstName_1")).sendKeys("First");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_lastName_1")).sendKeys("Last");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1")).sendKeys("0400000000");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_addressSearch_1")).sendKeys("12 Northfields Ave");
		Thread.sleep(2000);
		webDriver.findElement(By.id("address-1")).click();
		Thread.sleep(2000);

		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_email1_In_Register_1")).sendKeys(registeredEmail);
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1")).sendKeys(password);
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1")).sendKeys("Testing101");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_links_1")).click();

		Thread.sleep(2000);


		try {
			element = webDriver.findElement(By.id("MessageArea1"));
		} catch (Exception e) {

			e.printStackTrace();
		} Assert.assertEquals(errorMessage, element.getText());


		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);

	}
	
	
	/*
	 * This test creating new account with new email
	 * The test will read the account creation message and pass
	 * After passing it will log of of the account
	 * */
	/*@Test (dependsOnMethods={"tryToCreateNewAccountWithRegisteredEmail"})
	public void creatNewAccount() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());

		webDriver.findElement(By.id("SignInLink")).click();
		Thread.sleep(2000);

		webDriver.findElement(By.id("WC_AccountDisplay_links_3")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_firstName_1")).sendKeys("First");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_lastName_1")).sendKeys("Last");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1")).sendKeys("0400000000");
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_addressSearch_1")).sendKeys("12 Northfields Ave");
		Thread.sleep(2000);
		webDriver.findElement(By.id("address-1")).click();
		Thread.sleep(2000);

		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_email1_In_Register_1")).sendKeys(newEmail);
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1")).sendKeys(password);
		Thread.sleep(2000);
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1")).sendKeys("Testing101");
		Thread.sleep(2000);
		
		webDriver.findElement(By.id("WC_UserRegistrationAddForm_links_1")).click();

		Thread.sleep(2000);

		try {
			element = webDriver.findElement(By.className("show-for-large-up"));
		} catch (Exception e) {

			e.printStackTrace();
		} Assert.assertEquals("My Account", element.getText());
		Reporter.log("New account has been created with email = " + newEmail + "  and password = " + password);

		Thread.sleep(2000);
		

		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());

	}*/
	
	/*
	 * This test the search wedget it will start with entering half word and selecct from the suggestions
	 * after selecting the suggestion the test will pick a product and add it to the bag
	 * after that it will access the page to test the subtotal of the product with shipping
	 * The test will read the price and pass
	 * */
	@Test (dependsOnMethods={"tryToCreateNewAccountWithRegisteredEmail"})
	public void searchingForProductAndAddItToCart() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
		webDriver.findElement(By.id("SimpleSearchForm_SearchTerm")).sendKeys("Spea");
		webDriver.findElement(By.id("suggestionItem_1")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.cssSelector("[data-attribute-position=\"1\"]")).click();
		Thread.sleep(2000);
		String price = webDriver.findElement(By.xpath("//span[@class='price']")).getText();
		webDriver.findElement(By.className("add-to-bag-btn")).click();
		Thread.sleep(5000);
		
		//if there is the pop-up
		
		webDriver.findElement(By.xpath("//input[@id='WC__AddressEntryForm_FormInput_zipCode_0']")).sendKeys("2500");
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//div[@class='form-wrapper mobile adl-postcodemodal']//a[1]")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("//a[@id='GotoCartButton2']")).click();
		Thread.sleep(2000);
		

		try {
			element = webDriver.findElement(By.xpath("//span[@class='value'][contains(text(),'"+price+"')]"));
		} catch (Exception e) {
			e.printStackTrace();
		} Assert.assertEquals(price, element.getText());

		webDriver.findElement(By.className("link-uppercase")).click();
		Thread.sleep(2000);
		
		//webDriver.findElement(By.id("SignOutLink")).click();

		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
	}

	/*
	 * This test login to the newly created account
	 * The test will read the account login message and pass
	 * */
	@Test (dependsOnMethods={"searchingForProductAndAddItToCart"})
	public void signInToNewAccount() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());
		//Thread.sleep(2000);
		webDriver.findElement(By.id("SignInLink")).click();
		Thread.sleep(2000);

		webDriver.findElement(By.id("WC_AccountDisplay_FormInput_logonId_In_Logon_1")).sendKeys(newEmail);
		webDriver.findElement(By.id("WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")).sendKeys(password);
		webDriver.findElement(By.id("WC_AccountDisplay_links_2")).click();

		Thread.sleep(2000);

		try {
			element = webDriver.findElement(By.className("show-for-large-up"));
		} catch (Exception e) {
			e.printStackTrace();
		} Assert.assertEquals("My Account", element.getText());


		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);

	}
	
	
	
	/*
	 * This test selection from catagory, it will go through different selection
	 * after reaching the desired catagory it pick an item and check its price
	 * The test will pass after reading the price
	 * */
	@Test (dependsOnMethods={"signInToNewAccount"})
	public void selectFromCategoryAndCheckPrice() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
		webDriver.findElement(By.id("level1a_men")).click();
		webDriver.findElement(By.id("topCatClass_men")).click();

		Thread.sleep(2000);


		webDriver.findElement(By.id("level1a_men")).click();
		webDriver.findElement(By.id("level3a_men")).click();
		Thread.sleep(2000);

		webDriver.findElement(By.partialLinkText("Mens Jeans & Pants")).click();//partiallinkText locator for links
		Thread.sleep(2000);
		webDriver.findElement(By.className("product")).findElement(By.id("catalogEntry_img2401326")).click();

		Thread.sleep(2000);

		try {
			element = webDriver.findElement(By.className("price"));
		} catch (Exception e) {
			e.printStackTrace();
		} Assert.assertEquals("$15.00", element.getText());
		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);


	}
	


	@Test (dependsOnMethods={"selectFromCategoryAndCheckPrice"})
	  public void testingTheWebsiteLinkToSpecificCategory() throws InterruptedException {
		  
		  webDriver.get("https://www.kmart.com.au/category/electronics/electronics-by-category/computer-&-laptop-accessories/482501");
		  webDriver.manage().window().maximize();
		  String title = webDriver.getTitle();
			if(title.equalsIgnoreCase("Kmart | Toys, Furniture, Bedding & more - Online Shopping Australia")) 
			{
				Reporter.log("Kmart web successfully opened");
			}
			else 
			{
				Reporter.log("You are at " + title + " webpage");
			}

			WebElement element = webDriver.findElement(By.xpath("//div[@class='product product_box small-6 medium-4 large-4 columns clearfix col ']"));
			WebElement element2 = element.findElement(By.xpath(".//a[@id='catalogEntry_img2997302\']"));
			element2.click();
			Thread.sleep(2000);
			
			//Click add-to-bag button
			WebElement bag_btn = webDriver.findElement(By.className("add-to-bag-btn"));
			bag_btn.click();
			Thread.sleep(2000);
			
	  }


	/*
	 * This test finding store using zipCode
	 * after entering the zipCode "2500" it will pick figtree store and find the phone number
	 * The test will pass after reading the phone number
	 * */
	@Test (dependsOnMethods={"testingTheWebsiteLinkToSpecificCategory"})
	public void findStoreLocationAndPhoneNumber() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
		webDriver.findElement(By.className("stores")).click();

		Thread.sleep(2000);

		webDriver.findElement(By.id("inputLocation")).sendKeys("2500");
		webDriver.findElement(By.id("inputLocationGo")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.cssSelector("a[href='/store-detail/Figtree?storeSearch=2500']")).click();
		Thread.sleep(3000);

		try {
			element = webDriver.findElement(By.cssSelector("[itemprop='telephone']"));
		} catch (Exception e) {

			e.printStackTrace();
		} Assert.assertEquals("(02) 4220 2600", element.getText());
		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());


	}
	
	
	@Test (dependsOnMethods={"findStoreLocationAndPhoneNumber"})
    public void testingRandomCategories() throws InterruptedException {
		Reporter.log("Starting test => " + new Object(){}.getClass().getEnclosingMethod().getName());
        
        
        try {
            
        	webDriver.findElement(By.xpath(getRandomCategory())).click();
        	Reporter.log("Selected main category: "+category);
            Thread.sleep(2000);
            webDriver.findElement(By.xpath(generateXPath("//body[@id='homePage']/div[@id='page']/div[@id='headerWidget']/div[@class='header_wrapper']/div[@class='nav-redesign-wrapper']/ul[@class='menu-overflow']/li[@class='has-submenu level1']/div[@class='sub-menu open']/ul/li[1]/div[1]/ul[1]/li[", getRandomInt(4,1), "]/a[1]"))).click();
            Thread.sleep(2000);
            WebElement openSubCategory = webDriver.findElement(By.xpath("//div[@class='level4-holder open']//ul"));
            List<WebElement> links = openSubCategory.findElements(By.tagName("a"));
            for (int i = 1; i < links.size(); i++) {
                elementList.add(links.get(i).getText());
            }
            value = getRandomInt((elementList.size()-1), 0);
            String selectOption = "//*[contains(text(),'" + elementList.get(value) + "')]";
            Reporter.log("Final selected option: " + elementList.get(value));
            
            WebElement element = webDriver.findElement(By.xpath(selectOption));
            JavascriptExecutor js = (JavascriptExecutor) webDriver;  
            js.executeScript("arguments[0].click();",element);
            Thread.sleep(3000);
            
            Actions actions = new Actions(webDriver);
            actions.sendKeys(Keys.ESCAPE).perform();
            
            checkTitle(webDriver);        
            
        } catch(Exception e){
                Reporter.log("Error: " + e);
        }
        
        Reporter.log("Ending test   => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
    }
	
	@Test (dependsOnMethods={"testingRandomCategories"})
	public void Test_Scroll_Window() throws InterruptedException {
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		try {
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,950)", "");
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1550)", "");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,-1200)", "");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,-2200)", "");
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
	}
	
	
	/*
	 1.Test Clear All btn
	 2.Test individual clear btn
	 3.Randomly click on checkbox 
	 4.Check if product count match with the total display products
	*/
	@Test (dependsOnMethods={"Test_Scroll_Window"})
	public void Filter() throws InterruptedException {
		WebElement getcategory = null;
		Reporter.log("Starting test=> " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		/*-----  Randomly choose a category and store filter element in array list   -----*/
		String[] Category = {"Dining","Bedding","Laundry & Storage ","Books","Electronics","Toys","Nursery"};
		String random_Category = (Category[new Random().nextInt(Category.length)]);

		//checkPopUpWin();   //close kmailSignupDialog if appear
		Thread.sleep(1000);
  	if(random_Category=="Women's Clothing") 
  	{
  		webDriver.findElement(By.linkText("Women's Clothing")).click();
  	}else 
  	{
  		getcategory = webDriver.findElement(By.cssSelector("a[title='"+random_Category+"']"));
  		getcategory.click();
  	}
  	Thread.sleep(2000);
  	
  	
  	//retrieve filter type and store in array list
	    List<WebElement> elements_type = webDriver.findElements(By.xpath("//form/div/div/h3"));
	    ArrayList<String> typelArray = new ArrayList<String>(elements_type.size());
		for(int i = 0; i < elements_type.size(); ++i) 
		{
			typelArray.add(elements_type.get(i).getText());   
			getFilterType_list.add(elements_type.get(i).getText());
		}
		
		String last_cb_type = typelArray.get(typelArray.size()-1);
		
		
		/*-----  Test "Clear All" btn   -----*/
		for (String checkboxs_type : typelArray) 
		{
         //for each filter type, retrieve checkboxs info 
	        getFilterElements(checkboxs_type.toLowerCase());
	        
	        //Click on all Checkboxs 
	        Test_All_Checkboxs(checkboxs_type.toLowerCase(),1500);
	        Thread.sleep(2000);
	        
	        //click "Clear All" btn if all checkbox had clicked
	        if(checkboxs_type.equals(last_cb_type)) 
	        {
	        	WebElement ele = webDriver.findElement(By.cssSelector("span[id='LeftNavigationSearchClearAllLink']"));

	        	Actions action = new Actions(webDriver);

	        	action.moveToElement(ele).click().perform();
	        	
	    		//webDriver.findElement(By.cssSelector("span[id='LeftNavigationSearchClearAllLink']")).click();

	        }
	        Thread.sleep(2000);
		}
		
		 
		/*-----  Test individual clear btn   -----*/
		for (String checkboxs_type : typelArray) 
		{
	        Test_All_Checkboxs(checkboxs_type.toLowerCase(),1500);
	        Thread.sleep(1000);
	        
	        if(checkboxs_type.equals(last_cb_type)) 
	        {
	        	Test_Clear_Btn(1000);
	        }
	        Thread.sleep(2000);
		}
		
		/*-----  Randomly click on checkbox and check if the product count match with the number of products  -----*/
		for (String checkboxs_type : typelArray) 
		{
			Randomly_Test_Checkboxs(checkboxs_type.toLowerCase(),1500);
		    Thread.sleep(2000);
		}
		
		GetProductsCount();
		//Assert.assertEquals(productCount, imgCount);
  	
		Reporter.log("Ending test  => " + new Object(){}.getClass().getEnclosingMethod().getName());
		Thread.sleep(2000);
	}
	
	
	
	@AfterClass
	public void afterClass() {
		webDriver.close();
		webDriver.quit();
	}
	
	/*
	 * 
	 * Helper functions
	 * 
	 * */
	
	public static void GetProductsCount() 
	{
		//get product count from string
		String getProductCountStr = webDriver.findElement(By.cssSelector("span#leftNaveCount")).getText();
		//String getProductCountInt = getProductCountStr.substring(0);
		int getProductCount = 0;
		
		//check if product count had changed
       if(webDriver.findElement(By.cssSelector("span#leftNaveCount")).getText()!=getProductCountStr) 
       {
       	getProductCountStr = webDriver.findElement(By.cssSelector("span#leftNaveCount")).getText();
       	getProductCount = Integer.parseInt(getProductCountStr.replaceAll("[\\D]", ""));
       }        
       
       //get product count from product img list
       List<WebElement> img_count_p1 = webDriver.findElements(By.cssSelector("a[id^='catalogEntry_img']"));
       //int total_img_count =0;
       imgCount=img_count_p1.size();    
       productCount = getProductCount;
	}
	
	public static void Test_Clear_Btn(int waitSeconds) 
	{
		try 
		{
			List<WebElement> ele = webDriver.findElements(By.xpath("//form/div/div/h3/a/span"));
			int y =0;
			for(int i=0;i<ele.size();i++) 
			{
       		if(ele.get(i).isDisplayed()) 
       		{
       			Thread.sleep(2000);
       			Actions a = new Actions(webDriver);
       			a.moveToElement(ele.get(i)).click().perform();
       			//ele.get(i).click();
       		}        		
			}
		}catch(ElementClickInterceptedException e) 
		{
			e.printStackTrace();
		}catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	//for each filter type, obtain all filter elements
	public static void getFilterElements(String checkboxs_type) 
	{
		switch (checkboxs_type) 
		{
           case "colour":  
           	
           	List<WebElement> elements_colour = webDriver.findElements(By.cssSelector("label[class^='input-checkbox color']"));
        	    
        		for(int i = 0; i < elements_colour.size(); ++i) 
        		{
        			
        			colour_list.add(elements_colour.get(i).getText());
        		}
               break;
           case "brand":
           	
           	List<WebElement> elements_brand = webDriver.findElements(By.cssSelector("input[name^='brand_checkboxes']"));
       		for(int i = 0; i < elements_brand.size(); ++i) 
       		{
       			brand_list.add(elements_brand.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "price":
           	
           	List<WebElement> elements_price = webDriver.findElements(By.cssSelector("input[name^='price_checkboxes']"));        	   
       		for(int i = 0; i < elements_price.size(); ++i) 
       		{
       			price_list.add(elements_price.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "material":
           	List<WebElement> elements_m = webDriver.findElements(By.cssSelector("input[name^='material_checkboxes']"));        	   
       		for(int i = 0; i < elements_m.size(); ++i) 
       		{
       			material_list.add(elements_m.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "pack size":
           	List<WebElement> elements_ps = webDriver.findElements(By.cssSelector("input[name^='pack size_checkboxes']"));        	   
       		for(int i = 0; i < elements_ps.size(); ++i) 
       		{
       			packsize_list.add(elements_ps.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "suitable for ages":
           	List<WebElement> elements_sfa = webDriver.findElements(By.cssSelector("input[name^='suitable for ages_checkboxes']"));        	   
       		for(int i = 0; i < elements_sfa.size(); ++i) 
       		{
       			suitableforages_list.add(elements_sfa.get(i).getAttribute("data-facet-value"));
       		}
                break;
           case "thread count":
           	List<WebElement> elements_tc = webDriver.findElements(By.cssSelector("input[name^='thread count_checkboxes']"));        	   
       		for(int i = 0; i < elements_tc.size(); ++i) 
       		{
       			threadcount_list.add(elements_tc.get(i).getAttribute("data-facet-value"));
       		}
                break;
           case "machine washable":
           	List<WebElement> elements_mw = webDriver.findElements(By.cssSelector("input[name^='machine washable_checkboxes']"));        	   
       		for(int i = 0; i < elements_mw.size(); ++i) 
       		{
       			machinewashable_list.add(elements_mw.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "reversible":
           	List<WebElement> elements_reversible = webDriver.findElements(By.cssSelector("input[name^='reversible_checkboxes']"));        	   
       		for(int i = 0; i < elements_reversible.size(); ++i) 
       		{
       			reversible_list.add(elements_reversible.get(i).getAttribute("data-facet-value"));
       	    }
               break;
           case "cover material":
           	List<WebElement> elements_cm = webDriver.findElements(By.cssSelector("input[name^='cover material_checkboxes']"));        	   
       		for(int i = 0; i < elements_cm.size(); ++i) 
       		{
       			covermaterial_list.add(elements_cm.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "fill material":
           	List<WebElement> elements_fm = webDriver.findElements(By.cssSelector("input[name^='fill material_checkboxes']"));        	   
       		for(int i = 0; i < elements_fm.size(); ++i) 
       		{
       			fillmaterial_list.add(elements_fm.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "warmth rating":
           	List<WebElement> elements_wt = webDriver.findElements(By.cssSelector("input[name^='warmth rating_checkboxes']"));        	   
       		for(int i = 0; i < elements_wt.size(); ++i) 
       		{
       			warmthrating_list.add(elements_wt.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "size range":
           	List<WebElement> elements_sr = webDriver.findElements(By.cssSelector("input[name^='size range_checkboxes']"));        	   
       		for(int i = 0; i < elements_sr.size(); ++i) 
       		{
       			sizerange_list.add(elements_sr.get(i).getAttribute("data-facet-value"));
       		}
               break;
           case "capacity":
           	List<WebElement> elements_capacity = webDriver.findElements(By.cssSelector("input[name^='capacity_checkboxes']"));        	   
       		for(int i = 0; i < elements_capacity.size(); ++i) 
       		{
       			capacity_list.add(elements_capacity.get(i).getAttribute("data-facet-value"));
       		}
       		break;
           case "collection":
           	List<WebElement> elements_Collection  = webDriver.findElements(By.cssSelector("input[name^='collection_checkboxes']"));        	   
       		for(int i = 0; i < elements_Collection.size(); ++i) 
       		{
       			collection_list.add(elements_Collection.get(i).getAttribute("data-facet-value"));
       		}
       		break;
           case "microwave safe":
           	List<WebElement> elements_Microwave_Safe = webDriver.findElements(By.cssSelector("input[name^='microwave safe_checkboxes']"));        	   
       		for(int i = 0; i < elements_Microwave_Safe.size(); ++i) 
       		{
       			microwavesafe_list.add(elements_Microwave_Safe.get(i).getAttribute("data-facet-value"));
       		}
       		break;
           case "dishwasher safe":
           	List<WebElement> elements_Dishwasher_Safe  = webDriver.findElements(By.cssSelector("input[name^='dishwasher safe_checkboxes']"));        	   
       		for(int i = 0; i < elements_Dishwasher_Safe.size(); ++i) 
       		{
       			dishwashersafe_list.add(elements_Dishwasher_Safe.get(i).getAttribute("data-facet-value"));
       		}
       		break;
		    case "features":
		    	List<WebElement> elements_features = webDriver.findElements(By.cssSelector("input[name^='features_checkboxes']"));        	   
       		for(int i = 0; i < elements_features.size(); ++i) 
       		{
       			features_list.add(elements_features.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "carrier":
		    	List<WebElement> elements_carrier = webDriver.findElements(By.cssSelector("input[name^='carrier_checkboxes']"));        	   
       		for(int i = 0; i < elements_carrier.size(); ++i) 
       		{
       			carrier_list.add(elements_carrier.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "compatibility":
		    	List<WebElement> elements_compatibility = webDriver.findElements(By.cssSelector("input[name^='compatibility_checkboxes']"));        	   
       		for(int i = 0; i < elements_compatibility.size(); ++i) 
       		{
       			compatibility_list.add(elements_compatibility.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "sleeve length":
		    	List<WebElement> elements_sl = webDriver.findElements(By.cssSelector("input[name^='sleeve length_checkboxes']"));        	   
       		for(int i = 0; i < elements_sl.size(); ++i) 
       		{
       			sleevelength_list.add(elements_sl.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "gender":
		    	List<WebElement> elements_genders = webDriver.findElements(By.cssSelector("input[name^='gender_checkboxes']"));        	   
       		for(int i = 0; i < elements_genders.size(); ++i) 
       		{
       			gender_list.add(elements_genders.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "fit":
		    	List<WebElement> elements_fit = webDriver.findElements(By.cssSelector("input[name^='fit_checkboxes']"));        	   
       		for(int i = 0; i < elements_fit.size(); ++i) 
       		{
       			fit_list.add(elements_fit.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "style":
		    	List<WebElement> elements_style = webDriver.findElements(By.cssSelector("input[name^='style_checkboxes']"));        	   
       		for(int i = 0; i < elements_style.size(); ++i) 
       		{
       			style_list.add(elements_style.get(i).getAttribute("data-facet-value"));
       		}
		        break;
		    case "formulation":
		    	List<WebElement> elements_formulation = webDriver.findElements(By.cssSelector("input[name^='formulation_checkboxes']"));        	   
       		for(int i = 0; i < elements_formulation.size(); ++i) 
       		{
       			formulation_list.add(elements_formulation.get(i).getAttribute("data-facet-value"));
       		}
		        break;    
		    case "quantity":
		    	List<WebElement> elements_quantity = webDriver.findElements(By.cssSelector("input[name^='quantity_checkboxes']"));        	   
       		for(int i = 0; i < elements_quantity.size(); ++i) 
       		{
       			quantity_list.add(elements_quantity.get(i).getAttribute("data-facet-value"));
       		}
           	break;
		   case "size":
			   List<WebElement> elements_size = webDriver.findElements(By.cssSelector("input[name^='size_checkboxes']"));        	   
      		for(int i = 0; i < elements_size.size(); ++i) 
      		{
      			size_list.add(elements_size.get(i).getAttribute("data-facet-value"));
      		}
		   		break;
		   case "product type":
			   List<WebElement> elements_pt = webDriver.findElements(By.cssSelector("input[name^='product type_checkboxes']"));        	   
      		for(int i = 0; i < elements_pt.size(); ++i) 
      		{
      			producttype_list.add(elements_pt.get(i).getAttribute("data-facet-value"));
      		}
		         break;
		   case "manufacturer":
			   List<WebElement> elements_manufacturer = webDriver.findElements(By.cssSelector("input[name^='manufacturer_checkboxes']"));        	   
      		for(int i = 0; i < elements_manufacturer.size(); ++i) 
      		{
      			manufacturer_list.add(elements_manufacturer.get(i).getAttribute("data-facet-value"));
      		}
		         break;
		   case "character":
			   List<WebElement> elements_character = webDriver.findElements(By.cssSelector("input[name^='character_checkboxes']"));        	   
	       		for(int i = 0; i < elements_character.size(); ++i) 
	       		{
	       			character_list.add(elements_character.get(i).getAttribute("data-facet-value"));
	       		}
		        break; 
           default:
           	Reporter.log("Can not retriveve filter type from getFilterElements.");
                    break;
       }
	}
	
	//generate random filter elements Generate_Random_Filter_Element
	public static void Generate_Random_Filter_Element(ArrayList<String> arraylist) 
	{

		selected_element_list.clear();
		if(arraylist.size()!=0) 
		{
			//if the filter type only contains Yes or No, then only choose one.
			if(arraylist.equals(microwavesafe_list) || arraylist.equals(dishwashersafe_list)) 
			{
				int ran = new Random().nextInt(3); 
				if(ran==0) 
				{
					Collections.shuffle(arraylist); //shuffle the array list
					selected_element_list.add(arraylist.get(0));
				}
			}else 
			{
				int ran = new Random().nextInt(4); 
				if(ran!=0) 
				{
					Collections.shuffle(arraylist); //shuffle the array list
					Random r = new Random();
			        int ranInt = Math.abs(r.nextInt() % arraylist.size());
			        
			        //select the first ranInt element from the filter
			        for(int i=0;i<ranInt;i++) 
			        {
			        	selected_element_list.add(arraylist.get(i));
			        }
				}
			}
			
		}
	}
	
	public static void Generate_All_Filter_Element(ArrayList<String> arraylist) 
	{
		selected_element_list.clear();
		for(int i=0;i<arraylist.size();i++) 
       {
       	selected_element_list.add(arraylist.get(i));
       }
	}
		
	public static void Test_All_Checkboxs(String checkboxs_type, int waitSeconds) 
	{
		switch (checkboxs_type) 
		{
           case "colour":  
           	Generate_All_Filter_Element(colour_list); //will assign random checkboxs to selected_element_list
           	
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
           			String getColour = selected_elem.toLowerCase();
           			WebElement check_element = webDriver.findElement(By.xpath("//*[@name='colour_checkboxes'][@data-facet-value='"+selected_elem+"']"));
               		WebElement element = webDriver.findElement(By.cssSelector("label[class^='input-checkbox color "+getColour+"']"));
               		element.click();
               		Thread.sleep(waitSeconds);
               		////Assert.assertTrue(check_element.isSelected());
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "brand":
           	Generate_All_Filter_Element(brand_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='brand_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
               		////Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           		
           	}
			   break;
           case "price":
           	Generate_All_Filter_Element(price_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='price_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
               		////Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "material":
           	Generate_All_Filter_Element(material_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='material_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 	            		
	            		WebElement element_click=webDriver.findElement(By.cssSelector("label[for='"+getId+"']"));
	            		boolean click_able = element_click.isSelected();
	            		if(!click_able) 
	            		{
	            			element_click.click();
	            		}
	            		////Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "pack size":
           	Generate_All_Filter_Element(packsize_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='pack size_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		////Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "suitable for ages":
           	Generate_All_Filter_Element(suitableforages_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='suitable for ages_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		////Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "thread count":
           	Generate_All_Filter_Element(threadcount_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='thread count_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "machine washable":
           	Generate_All_Filter_Element(machinewashable_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='machine washable_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "reversible":
           	Generate_All_Filter_Element(reversible_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='reversible_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "cover material":
           	Generate_All_Filter_Element(covermaterial_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='cover material_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "fill material":
           	Generate_All_Filter_Element(fillmaterial_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='fill material_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "warmth rating":
           	Generate_All_Filter_Element(warmthrating_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='warmth rating_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "size range":
           	Generate_All_Filter_Element(sizerange_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
           			WebElement element = webDriver.findElement(By.xpath("//*[@name='size range_checkboxes'][@data-facet-value='"+selected_elem+"']"));
               		String getId = element.getAttribute("id"); 
               		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
               		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "capacity":
           	Generate_All_Filter_Element(capacity_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='capacity_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "features":
		    	Generate_All_Filter_Element(features_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try 
		    		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='features_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "collection":
			   Generate_All_Filter_Element(collection_list);
			   for(String selected_elem:selected_element_list) 
	           	{
				   try 
				   {
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='collection_checkboxes'][@data-facet-value='"+selected_elem+"']"));
		           		String getId = element.getAttribute("id"); 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
		           		}catch(ElementClickInterceptedException e) 
		           		{
		           			e.printStackTrace();
		           			continue;
		           		}catch(InterruptedException e) 
		           		{
		           			e.printStackTrace();
		           			continue;
		           		}
	           		}
			       break;
		    case "microwave safe":
			   Generate_All_Filter_Element(microwavesafe_list);
			   for(String selected_elem:selected_element_list) 
	           	{
				   try {
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='microwave safe_checkboxes'][@data-facet-value='"+selected_elem+"']"));
		           		String getId = element.getAttribute("id"); 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
			    break;
		    case "dishwasher safe":
			   Generate_All_Filter_Element(dishwashersafe_list);
			   for(String selected_elem:selected_element_list) 
	           	{
				   try {
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='dishwasher safe_checkboxes'][@data-facet-value='"+selected_elem+"']"));
		           		String getId = element.getAttribute("id"); 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
          		}catch(ElementClickInterceptedException e) 
          		{
          			e.printStackTrace();
          			continue;
          		}catch(InterruptedException e) 
          		{
          			e.printStackTrace();
          			continue;
          		}
	           	}
			    break;
		    case "carrier":
		    	Generate_All_Filter_Element(carrier_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='carrier_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "compatibility":
		    	Generate_All_Filter_Element(compatibility_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
           		WebElement element = webDriver.findElement(By.xpath("//*[@name='compatibility_checkboxes'][@data-facet-value='"+selected_elem+"']"));
           		String getId = element.getAttribute("id"); 
           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
           		//Assert.assertTrue(element.isSelected());
	            	Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "sleeve length":
		    	Generate_All_Filter_Element(sleevelength_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='sleeve length_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);

		    		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "gender":
		    	Generate_All_Filter_Element(gender_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
			    		WebElement element = webDriver.findElement(By.xpath("//*[@name='gender_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "fit":
		    	Generate_All_Filter_Element(fit_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
           		WebElement element = webDriver.findElement(By.xpath("//*[@name='fit_checkboxes'][@data-facet-value='"+selected_elem+"']"));
           		String getId = element.getAttribute("id"); 
           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
		    	break;
		    case "style":
		       Generate_All_Filter_Element(style_list); 
		       for(String selected_elem:selected_element_list) 
	           	{
		    	   try {
				    	WebElement element = webDriver.findElement(By.xpath("//*[@name='style_checkboxes'][@data-facet-value='"+selected_elem+"']"));
		           		String getId = element.getAttribute("id"); 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		    case "formulation":
		       Generate_All_Filter_Element(formulation_list); 
		       for(String selected_elem:selected_element_list) 
          		{
		    	   try {
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='formulation_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	           		String getId = element.getAttribute("id"); 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
			   break;
		   case "quantity":
		       Generate_All_Filter_Element(quantity_list); 
		       for(String selected_elem:selected_element_list) 
	           	{
		    	   try {
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='quantity_checkboxes'][@data-facet-value='"+selected_elem+"']"));
		           		String getId = element.getAttribute("id"); 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
			   break;
		   case "size":
			   Generate_All_Filter_Element(size_list); 
			   for(String selected_elem:selected_element_list) 
          	  {
				   try {
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='size_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		WebElement element_click=webDriver.findElement(By.cssSelector("label[for='"+getId+"']"));
	            		boolean click_able = element_click.isSelected();
	            		if(!click_able) 
	            		{
	            			element_click.click();
	            			//Assert.assertTrue(element.isSelected());
       			    }
				    
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		   case "product type":
			   Generate_All_Filter_Element(producttype_list);
			   for(String selected_elem:selected_element_list) 
          		{
				   try {
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='product type_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	           		String getId = element.getAttribute("id"); 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            	Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		   case "manufacturer":
			   Generate_All_Filter_Element(manufacturer_list);
			   for(String selected_elem:selected_element_list) 
          	   {
				   try {
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='manufacturer_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	           		String getId = element.getAttribute("id"); 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            	Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		   case "character":
			   Generate_All_Filter_Element(character_list);
			   for(String selected_elem:selected_element_list) 
          		{
				   try {
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='character_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	           		String getId = element.getAttribute("id"); 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            	Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break; 
           default:
           	Reporter.log("Can not retriveve filter type from TestCheckboxs.");
               break;
       }
	}
	
	public static void Randomly_Test_Checkboxs(String checkboxs_type, int waitSeconds) 
	{
		switch (checkboxs_type) 
		{
           case "colour":  
           	Generate_Random_Filter_Element(colour_list); //will assign random checkboxs to selected_element_list
           	
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
           			
           			String getColour = selected_elem.toLowerCase();
               		WebElement element = webDriver.findElement(By.cssSelector("label[class^='input-checkbox color "+getColour+"']"));
               		element.click();
               		//Assert.assertTrue(element.isSelected());

	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "brand":
           	Generate_Random_Filter_Element(brand_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='brand_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           		
           	}
			   break;
           case "price":
           	Generate_Random_Filter_Element(price_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='price_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "material":
           	Generate_Random_Filter_Element(material_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='material_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 	            		
	            		WebElement element_click=webDriver.findElement(By.cssSelector("label[for='"+getId+"']"));
	            		boolean click_able = element_click.isSelected();
	            		if(!click_able) 
	            		{
	            			element_click.click();
	            			//Assert.assertTrue(element.isSelected());
	            		}
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "pack size":
           	Generate_Random_Filter_Element(packsize_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='pack size_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "suitable for ages":
           	Generate_Random_Filter_Element(suitableforages_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='suitable for ages_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "thread count":
           	Generate_Random_Filter_Element(threadcount_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='thread count_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "machine washable":
           	Generate_Random_Filter_Element(machinewashable_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='machine washable_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "reversible":
           	Generate_Random_Filter_Element(reversible_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='reversible_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "cover material":
           	Generate_Random_Filter_Element(covermaterial_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='cover material_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "fill material":
           	Generate_Random_Filter_Element(fillmaterial_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='fill material_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "warmth rating":
           	Generate_Random_Filter_Element(warmthrating_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try {
	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='warmth rating_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "size range":
           	Generate_Random_Filter_Element(sizerange_list); 
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
           			 
               		WebElement element = webDriver.findElement(By.xpath("//*[@name='size range_checkboxes'][@data-facet-value='"+selected_elem+"']"));
               		String getId = element.getAttribute("id"); 
               		 
               		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
               		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
           case "capacity":
           	Generate_Random_Filter_Element(capacity_list);
           	for(String selected_elem:selected_element_list) 
           	{
           		try 
           		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='capacity_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		//WebElement element = webDriver.findElement(By.id("SubmitButton"));  
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "features":
		    	Generate_Random_Filter_Element(features_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try 
		    		{
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='features_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "collection":
			   Generate_Random_Filter_Element(collection_list);
			   for(String selected_elem:selected_element_list) 
	           	{
				   try 
				   {
					    
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='collection_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	 
		           		String getId = element.getAttribute("id"); 
		           		 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
		           		}catch(ElementClickInterceptedException e) 
		           		{
		           			e.printStackTrace();
		           			continue;
		           		}catch(InterruptedException e) 
		           		{
		           			e.printStackTrace();
		           			continue;
		           		}
	           		}
			       break;
		    case "microwave safe":
			   Generate_Random_Filter_Element(microwavesafe_list);
			   for(String selected_elem:selected_element_list) 
	           	{
				   try {
					    
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='microwave safe_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	 
		           		String getId = element.getAttribute("id"); 
		           		 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
			    break;
		    case "dishwasher safe":
			   Generate_Random_Filter_Element(dishwashersafe_list);
			   for(String selected_elem:selected_element_list) 
	           	{
				   try {
					    
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='dishwasher safe_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	 
		           		String getId = element.getAttribute("id"); 
		           		 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
          		}catch(ElementClickInterceptedException e) 
          		{
          			e.printStackTrace();
          			continue;
          		}catch(InterruptedException e) 
          		{
          			e.printStackTrace();
          			continue;
          		}
	           	}
			    break;
		    case "carrier":
		    	Generate_Random_Filter_Element(carrier_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
		    			 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='carrier_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id"); 
	            		 
	            		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	            		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "compatibility":
		    	Generate_Random_Filter_Element(compatibility_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
		    		 
           		WebElement element = webDriver.findElement(By.xpath("//*[@name='compatibility_checkboxes'][@data-facet-value='"+selected_elem+"']"));
           		String getId = element.getAttribute("id"); 
           		 
           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "sleeve length":
		    	Generate_Random_Filter_Element(sleevelength_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
		    		 
           		WebElement element = webDriver.findElement(By.xpath("//*[@name='sleeve length_checkboxes'][@data-facet-value='"+selected_elem+"']"));
           		String getId = element.getAttribute("id"); 
           		 
           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "gender":
		    	Generate_Random_Filter_Element(gender_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
           		WebElement element = webDriver.findElement(By.xpath("//*[@name='gender_checkboxes'][@data-facet-value='"+selected_elem+"']"));
           		String getId = element.getAttribute("id"); 
           		 
           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
			   break;
		    case "fit":
		    	Generate_Random_Filter_Element(fit_list); 
		    	for(String selected_elem:selected_element_list) 
           	{
		    		try {
		    		 
           		WebElement element = webDriver.findElement(By.xpath("//*[@name='fit_checkboxes'][@data-facet-value='"+selected_elem+"']"));
           		String getId = element.getAttribute("id"); 
           		 
           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
           		}catch(ElementClickInterceptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}catch(InterruptedException e) 
           		{
           			e.printStackTrace();
           			continue;
           		}
           	}
		    	break;
		    case "style":
		       Generate_Random_Filter_Element(style_list); 
		       for(String selected_elem:selected_element_list) 
	           	{
		    	   try {
			    	 
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='style_checkboxes'][@data-facet-value='"+selected_elem+"']"));

	           		String getId = element.getAttribute("id"); 
	           		 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		    case "formulation":
		       Generate_Random_Filter_Element(formulation_list); 
		       for(String selected_elem:selected_element_list) 
          		{
		    	   try {
		    	    
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='formulation_checkboxes'][@data-facet-value='"+selected_elem+"']"));

	           		String getId = element.getAttribute("id"); 
	           		 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
			   break;
		   case "quantity":
		       Generate_Random_Filter_Element(quantity_list); 
		       for(String selected_elem:selected_element_list) 
	           	{
		    	   try {
	           	
				    	    
		           		WebElement element = webDriver.findElement(By.xpath("//*[@name='quantity_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	 
		           		String getId = element.getAttribute("id"); 
		           		 
		           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
		           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
			   break;
		   case "size":
			   Generate_Random_Filter_Element(size_list); 
			   for(String selected_elem:selected_element_list) 
          	  {
				   try {	            		 
	            		WebElement element = webDriver.findElement(By.xpath("//*[@name='size_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	            		String getId = element.getAttribute("id");
	            		WebElement element_click=webDriver.findElement(By.cssSelector("label[for='"+getId+"']"));
	            		boolean click_able = element_click.isSelected();
	            		if(!click_able) 
	            		{
	            			element_click.click();
	            			if(element_click.isSelected()) 
	            			{
	            				element_click.click();
	            				//Assert.assertTrue(element_click.isSelected());
	            			}
	            		}
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		   case "product type":
			   Generate_Random_Filter_Element(producttype_list);
			   for(String selected_elem:selected_element_list) 
          		{
				   try {
          	
				    
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='product type_checkboxes'][@data-facet-value='"+selected_elem+"']"));

	           		String getId = element.getAttribute("id"); 
	           		 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		   case "manufacturer":
			   Generate_Random_Filter_Element(manufacturer_list);
			   for(String selected_elem:selected_element_list) 
          	{
				   try {
          	
				    
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='manufacturer_checkboxes'][@data-facet-value='"+selected_elem+"']"));

	           		String getId = element.getAttribute("id"); 
	           		 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break;
		   case "character":
			   Generate_Random_Filter_Element(character_list);
			   for(String selected_elem:selected_element_list) 
          		{
				   try {
	           		WebElement element = webDriver.findElement(By.xpath("//*[@name='character_checkboxes'][@data-facet-value='"+selected_elem+"']"));
	           		String getId = element.getAttribute("id"); 
	           		webDriver.findElement(By.cssSelector("label[for^='"+getId+"']")).click();
	           		//Assert.assertTrue(element.isSelected());
	            		Thread.sleep(waitSeconds);
	           		}catch(ElementClickInterceptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}catch(InterruptedException e) 
	           		{
	           			e.printStackTrace();
	           			continue;
	           		}
	           	}
		       break; 
           default:
           	//Reporter.log("Can not retriveve filter type from TestCheckboxs.");
               break;
       }	
	 }

	/*
	 * 
	 * Helper functions
	 * 
	 * */
	
	public static void checkPopUpWin() 
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
		        .ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
				 WebElement element = driver.findElement(By.id("kmailSignupDialog"));
				 boolean status = element.isEnabled();
				 
				 if(status){
					 driver.findElement(By.cssSelector("a[class^='close-modal-dialog']")).click();
					 return element;
			     }else{ 
					 Reporter.log("Cannot close the pop up window.");
					 return null;
				 }
			 }
		 });
	}
	
	 public int getRandomInt(int max, int min){
	        Random random = new Random();
	        int r = random.nextInt(max - min + 1) + min;
	        return r;
	    }
	    
	    public String getRandomCategory(){
	        Random random = new Random();
	        int r = random.nextInt(9 - 0 + 1) + 0;
	        String st = String.join("_", "level1a", categories[r]);
	        category = "//a[@id='"+st+"']";
	        return category;
	    }
	    
	    public String generateXPath(String s1, int s2, String s3){
	        return s1+s2+s3;
	    }
	    
	    
	    public void checkTitle(WebDriver driver) {
	        List<WebElement> elems = driver.findElements(By.tagName("h1"));
	        if (elems.size() > 0) {
	          WebElement h1Element = driver.findElement(By.tagName("h1"));
	          actualTitle = h1Element.getText();
	          expectedTitle = elementList.get(value);
	          Reporter.log("Expected Title: "+expectedTitle+"\nActual Title: "+actualTitle);
	        } else {
	            WebElement h2Element = driver.findElement(By.tagName("h2"));
	            actualTitle = h2Element.getText();
	            expectedTitle = elementList.get(value);
	    		Assert.assertEquals(expectedTitle,actualTitle);
	            Reporter.log("Expected Title: "+expectedTitle+"\nActual Title: "+expectedTitle);
	        }
	    }

}


