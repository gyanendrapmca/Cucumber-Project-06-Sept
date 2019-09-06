package selenium_testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E_TestNG {
	private WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Test
	public void ExecuteTestCase() throws InterruptedException {
		driver.get("http://www.shop.demoqa.com");
		
		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");

		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();

		Thread.sleep(10000);
		Select color = new Select(driver.findElement(By.id("pa_color")));
		color.selectByIndex(1);
		Select size = new Select(driver.findElement(By.id("pa_size")));
		size.selectByIndex(2);
		for (int i = 1; i <= 3; i++)
			driver.findElement(By.cssSelector("button.qty-increase")).click();
		Thread.sleep(10000);
		
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();

		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();

		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();

		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");

		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");

		WebElement countryDropDown = driver.findElement(By.cssSelector("#select2-billing_state-container"));
		countryDropDown.click();
		Thread.sleep(10000);

		List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
		for (WebElement country : countryList) {
			if (country.getText().equals("India")) {
				country.click();
				Thread.sleep(3000);
				break;
			}
		}

		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");

		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");
		
		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");

		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Shalimar Bagh");

		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("110088");

		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();

		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
