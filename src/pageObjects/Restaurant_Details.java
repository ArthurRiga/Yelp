package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Restaurant_Details {

	public static void details(WebDriver driver){
		WebElement address = driver.findElement(By.xpath("//div[@class='mapbox-text']/ul/li[1]"));
		WebElement phone = driver.findElement(By.xpath("//div[@class='mapbox-text']/ul/li[3]"));
		WebElement web_site_details = driver.findElement(By.xpath("//div[@class='mapbox-text']/ul/li[4]"));
	       
		Reporter.log("Restaurant address: "+ address);
	    	Reporter.log("Restaurant phone: "+ phone);
	    	Reporter.log("Restaurant phone: "+ web_site_details);
	    
		WebElement restaraunts = driver.findElement(By.xpath("//div[@class='review-list']/ul"));
	    	List<WebElement> links = restaraunts.findElements(By.tagName("li"));
	    	for (int i = 2; i <= 4; i++)
	    	{
	    		String review = links.get(i).findElement(By.xpath("//div[@class='review-content']/p")).getText();
	        	Reporter.log("Restaurant review #"+i+" :"+ review);
	    	}
	}
}
