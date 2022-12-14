package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends CoreTestCase {

    @Test
    public void testFindJava() {

        MainPageObject mainPO = new MainPageObject(this.driver);

        WebElement searchInit = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_container",
                "Cannot find Search Wikipedia init search input"
        );
        searchInit.click();

        WebElement searchInput = mainPO.waitForElementPresent(
                "id:org.wikipedia:id/search_src_text",
                "Cannot find search input"
        );

        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPO.waitForElementPresent(
                "xpath://*[contains(@text,'Island of Indonesia, Southeast Asia')]/..",
                "Cannot find result 'Island of ' on 'Java' search"
        );

        expectedResult.click();
    }
}
