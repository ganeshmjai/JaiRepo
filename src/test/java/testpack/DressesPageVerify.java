package testpack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import mainpack.BasePage;
import mainpack.DressesPageObjects;

public class DressesPageVerify {
	DressesPageObjects dressobj;
	BasePage BPage;

	public DressesPageVerify() {
		BPage = new BasePage();
		dressobj = new DressesPageObjects();
	}

	@Test
	public void nav_page() {
		String page = dressobj.nav_dress();
		Assert.assertTrue(page.contains("Dresses"));
	}

	@Test
	public void sort() throws Exception {
		List<String> pricelist = dressobj.pricelist();
		ArrayList<String> expectedlist = new ArrayList<String>();
		for (int i =0; i <pricelist.size(); i++) {
			String expected = pricelist.get(i).replace("$", "");
			expectedlist.addAll(Arrays.asList(expected));
		}
		
		System.out.println(expectedlist);

		dressobj.selectdrpdwm();
		List<String> actual = dressobj.pricelist();
		System.out.println(actual);
	}

	@Test
	public void buttonsinprdt() {
		Assert.assertTrue(BPage.elementFound(dressobj.chkbuttons()));
		Assert.assertTrue(BPage.elementFound(dressobj.pricepresent()));
	}
}
