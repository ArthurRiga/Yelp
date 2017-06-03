package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class Search_Result {
	
	private static WebElement element = null;

	public static WebElement find_Field(WebDriver driver){
		element = driver.findElement(By.id("find_desc"));
		return element; 
	}
	
	public static WebElement showing_Result(WebDriver driver){
		return driver.findElement(By.xpath("//*[@class='pagination-results-window']"));	
	}

	public static WebElement suggested_filter(WebDriver driver, int filter){
		return driver.findElement(By.xpath("//ul[@class='suggested-filters_filter-list']/li["+filter+"]"));
	}

	public static WebElement filter(WebDriver driver, int filter_name, int filter_value){
		return driver.findElement(By.xpath("//div[@class='filter-panel_filters']/div/div["+filter_name+"]//li["+filter_value+"]//input"));
	}

	public static WebElement filter1(WebDriver driver, int filter_name, int filter_value){
		return driver.findElement(By.xpath("//div[@class='filter-panel_filters']/div/div["+filter_name+"]//li["+filter_value+"]//span"));
	}
	
	public static void star_rating(WebDriver driver){
		WebElement restaraunts = driver.findElement(By.xpath("//*[@class='search-results-content']/ul[2]"));
	    List<WebElement> links = restaraunts.findElements(By.tagName("li"));
	    for (int i = 0; i < links.size(); i++)
	    {
	    	String rating = links.get(i).findElement(By.xpath("//div[@class='i-stars i-stars--regular-4-half rating-large']")).getText();
	        Reporter.log("Restaurant "+i+" has "+ rating);
	    }
	}

	public static WebElement result_link(WebDriver driver, int i) {
		return driver.findElement(By.xpath("//*[@class='search-results-content']/ul[2]/li["+i+"]//a[@class='biz-name js-analytics-click']"));
	}

}
