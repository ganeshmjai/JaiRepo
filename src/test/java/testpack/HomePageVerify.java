package testpack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import mainpack.BasePage;
import mainpack.HomepageObjects;

public class HomePageVerify {
	BasePage BPage;
	HomepageObjects homeobj;

	public HomePageVerify() {
		BPage = new BasePage();
		homeobj = new HomepageObjects();
	}

	@Test
	public void verifypagemenus() {
		List<String> actual = homeobj.getmenunames();
		ArrayList<String> expected = new ArrayList<String>();
		expected.addAll(Arrays.asList("WOMEN", "DRESSES", "T-SHIRTS"));
		Assert.assertTrue(actual.containsAll(expected));
	}

	@Test
	public void newsletterinput() {
		int value= new Random().nextInt(600000);
		homeobj.newsletter().sendKeys("abcdxyz"+ value+"@abc.com");
		homeobj.submitnewsletter().click();
		BPage.wait(homeobj.subscriptionsuccess());
		String successmsg = homeobj.subscriptionsuccess().getText();
		Assert.assertEquals(successmsg, "Newsletter : You have successfully subscribed to this newsletter.");
	}
}
