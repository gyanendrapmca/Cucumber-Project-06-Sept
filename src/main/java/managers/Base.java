package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Base {
	private WebDriver driver;
	private HomePage homePage;
	private CartPage cartPage;
	private ProductListingPage productList;
	private CheckOutPage checkOutPage;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getInstanceOfHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public CartPage getInstanceOfCartPage() {
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

	public ProductListingPage getInstanceOfProductListing() {
		return (productList == null) ? productList = new ProductListingPage(driver) : productList;
	}

	public CheckOutPage getInstanceOfCheckOutPage() {
		return (checkOutPage == null) ? checkOutPage = new CheckOutPage(driver) : checkOutPage;
	}
}