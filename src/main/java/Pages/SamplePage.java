package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SamplePage extends BasePage {


    //Test 1
    public Boolean isLoaded() {
        boolean testPageHeader = isElementExists(Consts.TEST_PAGE);
        return testPageHeader;
    }

    public Boolean emailBoxExists() {
        boolean emailAddressInput = isElementExists(Consts.EMAIL_ADDRESS_FIELD);
        return emailAddressInput;
    }

    public Boolean passwordBoxExists() {
        boolean passwordInput = isElementExists(Consts.PASSWORD_FIELD);
        return passwordInput;
    }

    public Boolean loginButtonExists() {
        boolean signInButton = isElementExists(Consts.SIGN_IN_BUTTON);
        return signInButton;
    }

    public String populateEmailAddress(String email) {
        sendTextToField(Consts.EMAIL_ADDRESS_FIELD, email);
        return email;
    }

    public String populatePassword(String password) {
        sendTextToField(Consts.PASSWORD_FIELD, password);
        return password;
    }


    //Test 2
    public int getNumberOfValuesInList() {
        List<WebElement> values = driver.findElements(
                By.xpath(Consts.LIST_GROUP_ITEM));
        return values.size();
    }


    public ArrayList<String> getValuesList() {
        List<WebElement> elements = driver.findElements(
                By.xpath(Consts.LIST_GROUP_ITEM));

        ArrayList<String> valuesList = new ArrayList();
        for (WebElement webElement : elements) {
            valuesList.add(webElement.getText());
        }
        return valuesList;
    }

    public ArrayList<String> getBadgesList() {
        List<WebElement> elements = driver.findElements(
                By.xpath(Consts.BADGES_LIST));


        ArrayList<String> valuesList = new ArrayList();
        for (WebElement webElement : elements) {
            valuesList.add(webElement.getText());
        }
        return valuesList;
    }


    //Test 3
    public String getButtonOption() {
        return findElementByXpath(Consts.BUTTON).getText();
    }

    public void chooseOption(int num) {
        clickElementByXpath(Consts.DROPDOWN_MENU);
        clickElementByXpath(String.format(Consts.OPTION_NUMBER, num));
    }


    //Test 4
    public Boolean isFirstButtonEnabled() {
        String disabled = findElementByXpath(Consts.BUTTON_IS_ENABLED).getAttribute("disabled");
        return disabled == null;
    }

    public Boolean isSecondButtonDisabled() {
        String disabled = findElementByXpath(Consts.BUTTON_IS_DISABLED).getAttribute("disabled");
        return Boolean.valueOf(disabled);
    }


    //Test 5
    public void clickTest5Button() {
        waitElementIsClickable(Consts.BUTTON_IS_DISPLAYED).click();
    }

    public Boolean isTest5ButtonDisabled() {
        return Boolean.valueOf(findElementByXpath(Consts.BUTTON_IS_DISPLAYED).getAttribute("disabled"));
    }

    public boolean isAlertDisplayed() {
        return isElementExists(Consts.ALERT_DISPLAYED);
    }

    //Test 6
    public String findInTable(int a, int b) {
        List<WebElement> rows = driver.findElements(By.xpath(Consts.TABLE));

        try {
            String[] row = rows.get(a).getText().split(" ");
            return row[b];
        }
        catch (IndexOutOfBoundsException error){
            System.out.println("ERROR: please check the size of the table and choose correct coordinates");
            throw error;
        }

    }
}