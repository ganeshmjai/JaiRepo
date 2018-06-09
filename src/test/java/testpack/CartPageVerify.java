package testpack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import mainpack.BasePage;
import mainpack.CartpageObjects;
import mainpack.DressesPageObjects;

public class CartPageVerify {
	
	CartpageObjects cartobj;
	BasePage BPage;
	DressesPageObjects dressobj;

	public CartPageVerify() {

		BPage = new BasePage();
		cartobj = new CartpageObjects();
		dressobj=new DressesPageObjects();
	}
	@Test
	public void  addtocart() {
		String expt_name= dressobj.prdtname().getText();
		dressobj.addtocart(0).click();
		BPage.isElementVisible(dressobj.proceedchkout());
		dressobj.proceedchkout().click();
		String actual=cartobj.prddesc().getText();
		Assert.assertTrue(actual.contains(expt_name));
		}

}
