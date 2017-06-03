package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 
import pageObjects.Home_Page;
import pageObjects.Search_Result;
import pageObjects.Restaurant_Details;
 
   public class PizzaTC {
 
     private static WebDriver driver = null;    
 	
     @Test(dataProvider="registerData")
     public static void test1(String restaurant_type, String food_type) throws InterruptedException {
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to yelp.com
        driver.get("http://www.yelp.com");   

        //2. Select “Restaurants” in the drop­down box in Find
        Home_Page.find_Field(driver).click();
        Home_Page.suggestion_Dropdown(driver, restaurant_type).click();
        TimeUnit.SECONDS.sleep(5);
        //3. Click Search button
        Home_Page.search_Button(driver).click();
        
        //4. Append Pizza to Restaurants to make the search text as “Restaurants Pizza”
        Search_Result.find_Field(driver).sendKeys(restaurant_type+" "+food_type);
        
        //5. Report total no. of Search results with no. of results in the current page
        Reporter.log(Search_Result.showing_Result(driver).getText());
        
        //6. Parameterize any 2 of the filtering parameters (Neighborhoods, Distance, Price,
        //Features, etc.)
        //7. Apply the filter
        TimeUnit.SECONDS.sleep(5);
        Search_Result.suggested_filter(driver, 7).click();
        TimeUnit.SECONDS.sleep(5);
        Search_Result.filter(driver, 2, 2).click();
        TimeUnit.SECONDS.sleep(5);
        Search_Result.filter1(driver, 3, 1).click();
        
        //8. Report total no. of Search results with no. of results in the current page
        Reporter.log(Search_Result.showing_Result(driver).getText());
        
        //9. Report the star rating of each of the results in the first result page
        Search_Result.star_rating(driver);
        
        //10. Click and expand the first result from the search results
        Search_Result.result_link(driver, 1).click();
        
        //11. Log all critical information of the selected restaurant details, for the reporting purpose
        // Address, Phone No, web site details
        // First 3 customer reviews
        Restaurant_Details.details(driver);
     }
     
     @AfterTest
     public void CloseBrowser() {  
      driver.quit();  
     }
 
 	@DataProvider
 	public Object[][] registerData(){
 		
 		//row - number of times test has to be repeated
 		//col - parameters in data
 		Object data[][]=new Object[2][2];
 		
 		data[0][0]="Restaurants";
 		data[0][1]="Pizza";

 		data[1][0]="Bars";
 		data[1][1]="Tacos";

 		return data;
 	}
 	
}