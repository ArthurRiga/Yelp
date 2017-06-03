package pageObjects;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
 
public class Home_Page {
 
	private static WebElement element = null;
 
	public static WebElement find_Field(WebDriver driver){
		element = driver.findElement(By.id("find_desc"));
		return element; 
	}
 
	public static WebElement suggestion_Dropdown(WebDriver driver, String suggestion){
		element = driver.findElement(By.xpath("//*[@id='header_find_form']//ul[@class='suggestions-list']//*[@class='suggestion-detail suggestion-title suggestion-name' and text()='"+suggestion+"']"));
		return element; 
    } 
	
	public static WebElement search_Button(WebDriver driver){
		element = driver.findElement(By.id("header-search-submit"));
		return element; 
	}
}