package mainpack;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObjects extends BasePage {

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[2]")
	private WebElement Dress_menu;

	@FindBy(xpath = ".//*[@class='cat_desc']/span")
	private WebElement dress_page;

	@FindBys(@FindBy(xpath = ".//*[@class='product_list grid row']/li"))
	private List<WebElement> product;

	@FindBy(id = "selectProductSort")
	private WebElement sortdropdwn;

	@FindBy(xpath = ".//*[@title='Proceed to checkout']")
	private WebElement proceedtochkout;

	public DressesPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public String nav_dress() {
		Dress_menu.click();
		String page_nam = dress_page.getText();
		return page_nam;
	}

	public WebElement chkbuttons() {
		WebElement addtocartbtn = null;
		Dress_menu.click();
		for (int i = 0; i < product.size(); i++) {
			hover(product.get(i));
			addtocartbtn = product.get(i).findElement(By.xpath(".//*[@title='Add to cart']"));

		}
		return addtocartbtn;
	}

	public WebElement prdtname() {

		WebElement prdtname = null;
		Dress_menu.click();
		hover(product.get(0));
		prdtname = product.get(0).findElement(By.xpath(".//*[@class='product-name']"));
		return prdtname;

	}

	public WebElement pricepresent() {

		WebElement pricevalue = null;
		Dress_menu.click();
		for (int i = 0; i < product.size(); i++) {
			hover(product.get(i));
			pricevalue = product.get(i).findElement(By.xpath(".//*[@class='price product-price']"));

		}
		return pricevalue;
	}

	public List<String> pricelist() {
		ArrayList<String> pricelist = new ArrayList<String>();
		for (WebElement ele : product) {
			pricelist.add(ele.findElement(By.xpath(".//*[@class='right-block']//div[1]/span")).getText());
		}
		return pricelist;
	}

	public WebElement addtocart(int indx) {
		Dress_menu.click();
		hover(product.get(indx));
		WebElement addcart = product.get(indx).findElement(By.xpath(".//*[@title='Add to cart']"));
		isElementVisible(addcart);
		return addcart;
	}

	public void selectdrpdwm() throws Exception {
		selectFromDropDown(sortdropdwn, "price:asc");
		Thread.sleep(2000);
	}

	public WebElement proceedchkout() {
		return proceedtochkout;
	}

}
