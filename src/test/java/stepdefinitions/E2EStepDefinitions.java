package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class E2EStepDefinitions {
	private WebDriver driver;
	
	@Given("^user is on Home Page$")
    public void user_is_on_home_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
    }

	@When("^he search for \"([^\"]*)\"$")
    public void he_search_for_dress(String dress){
		driver.navigate().to("http://shop.demoqa.com/?s=" + dress + "&post_type=product");
    }

    @And("^choose to buy the first item$")
    public void choose_to_buy_the_first_item() throws InterruptedException{
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
    }

    @And("^moves to checkout from mini cart$")
    public void moves_to_checkout_from_mini_cart(){
    	WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();

		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();
    }

    @And("^enter personal details on checkout page$")
    public void enter_personal_details_on_checkout_page() throws InterruptedException{
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
    }

    @And("^select same delivery address$")
    public void select_same_delivery_address(){
        System.out.println("Select same delivery address");
    }

    @And("^select payment method as \"([^\"]*)\" payment$")
    public void select_payment_method_as_check_payment(String check){
        System.out.println("Select payment method as "+check+" payment.");
    }

    @And("^place the order$")
    public void place_the_order(){
    	WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();

		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
    }
    
    @After
    public void tearDown() {
    	driver.close();
    }
}