package mainpack;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomepageObjects extends BasePage {

	@FindBys(@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li"))
	private List<WebElement> Menu;

	@FindBy(id = "newsletter-input")
	private WebElement newsletterinput;

	@FindBy(xpath = ".//*[@name='submitNewsletter']")
	private WebElement newslettersubmit;
	
	@FindBy(xpath = ".//*[@class='alert alert-success']")
	private WebElement subscriptionsuccess;

	public HomepageObjects() { // constructor-will be called auto when object instance created
		PageFactory.initElements(driver, this);
	}

	public List<String> getmenunames() {
		ArrayList<String> menulist = new ArrayList<String>();
		for (WebElement ele : Menu) {
			menulist.add(ele.getText());
		}
		return menulist;
	}

	public WebElement newsletter() {
		return newsletterinput;
	}

	public WebElement submitnewsletter() {
		return newslettersubmit;
	}

	public WebElement subscriptionsuccess() {
		return subscriptionsuccess;
	}

}
