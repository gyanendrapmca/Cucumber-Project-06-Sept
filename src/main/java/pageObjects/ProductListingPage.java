package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
	private WebElement buttonAddToCart;
	
	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> productList;
	
	@FindBy(how = How.ID, using="pa_color")
	private WebElement selectProductColor;
	
	@FindBy(how = How.ID, using = "pa_size")
	private WebElement selectProductSize;
	
	@FindBy(how=How.CSS, using = "button.qty-increase")
	private WebElement buttonQuantityIncrease;
	
	public void clickAddToCart() {
		buttonAddToCart.click();
	}
	
	public void selectProduct(int number) {
		productList.get(number).click();
	}
	
	public void clickQuantityIncrease() {
		buttonQuantityIncrease.click();
		buttonQuantityIncrease.click();
		buttonQuantityIncrease.click();
	}
	
	public Select productColor() {
		return new Select(selectProductColor);
	}
	
	public Select productSize() {
		return new Select(selectProductSize);
	}
}