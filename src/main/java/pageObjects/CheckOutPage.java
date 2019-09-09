package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using="#billing_first_name")
	private WebElement firstName;
	
	@FindBy(how = How.CSS, using="#billing_last_name")
	private WebElement lastName;
	
	@FindBy(how = How.CSS, using="#billing_company")
	private WebElement companyName;
	
	@FindBy(how = How.CSS, using="input#billing_address_1")
	private WebElement houseNo;
	
	@FindBy(how = How.CSS, using="input#billing_address_2")
	private WebElement apartment;
	
	@FindBy(how = How.CSS, using="input#billing_city")
	private WebElement city;
	
	@FindBy(how = How.CSS, using="input#billing_postcode")
	private WebElement postCode;
	
	@FindBy(how = How.CSS, using="input#billing_phone")
	private WebElement phone;
	
	@FindBy(how = How.CSS, using="input#billing_email")
	private WebElement email;
	
	@FindBy(how = How.CSS, using="#select2-billing_country-container")
	private WebElement countryDropDown;
	
	@FindBy(how = How.CSS, using="#select2-billing_state-container")
	private WebElement stateDropDown;
	
	@FindBy(how = How.CSS, using="input.select2-search__field")
	private WebElement selectCountryState;
	
	@FindBy(how = How.CSS, using="#terms.input-checkbox")
	private WebElement acceptTermCondition;
	
	@FindBy(how = How.CSS, using="#place_order")
	private WebElement placeOrder;
	
	public void clickOnCountryDropDown() {
		countryDropDown.click();
	}
	
	public void clickOnStateDropDown() {
		stateDropDown.click();
	}
	
	public void selectCountryStateOption(String arg) {
		selectCountryState.sendKeys(arg);
		selectCountryState.sendKeys(Keys.RETURN);
	}
	
	public void enterFirstName(String arg) {
		firstName.sendKeys(arg);
	}
	
	public void enterLastName(String arg) {
		lastName.sendKeys(arg);
	}
	
	public void enterCompanyName(String arg) {
		companyName.sendKeys(arg);
	}
	
	public void enterHouseNo(String arg) {
		houseNo.sendKeys(arg);
	}
	
	public void enterAppartment(String arg) {
		apartment.sendKeys(arg);
	}
	
	public void enterCityName(String arg) {
		city.sendKeys(arg);
	}
	
	public void enterPostCode(String arg) {
		postCode.sendKeys(arg);
	}
	
	public void enterPhone(String arg) {
		phone.sendKeys(arg);
	}
	
	public void enterEmail(String arg) {
		email.sendKeys(arg);
	}
	
	public void clickOnAcceptTerm() {
		acceptTermCondition.click();
	}
	
	public void clickOnPlaceOrder() {
		placeOrder.click();
	}
}