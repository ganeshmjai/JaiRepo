package mainpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartpageObjects extends BasePage {

	@FindBy(xpath = ".//*[@id='cart_summary']/tbody/tr[1]")
	private WebElement product1;

	@FindBy(xpath = ".//*[@id='total_price']")
	private WebElement Totalprice;

	public CartpageObjects() {
		PageFactory.initElements(driver, this);
	}

	public WebElement prddesc() {
		WebElement partdesc = product1.findElement(By.xpath(".//*[@class='product-name']/a"));
		return partdesc;
	}
}
