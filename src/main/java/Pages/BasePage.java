package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;


    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected static void clickElementByXpath(String xpath) {
        findElementByXpath(xpath).click();
    }

    protected static WebElement findElementByXpath(String xpath) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception exception) {
            return null;
        }
    }


    protected static WebElement waitElementIsClickable(String xpath) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception exception) {
            return null;
        }
    }

    protected static boolean isElementExists(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))) != null;
    }

    protected static String sendTextToField(String xpath, String text) {
        WebElement element = findElementByXpath(xpath);
        element.sendKeys(text);

        return findElementByXpath(xpath).getAttribute("value");

    }
}
