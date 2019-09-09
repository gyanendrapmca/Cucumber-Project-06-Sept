package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement cartButton;
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement continueToCheckOut;
	
	public void clickOnCartButton() {
		cartButton.click();
	}
	
	public void clickOnContinueToCheckOut() {
		continueToCheckOut.click();
	}
}