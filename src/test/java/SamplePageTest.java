import Consts.Consts;
import Pages.SamplePage;
import Utils.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SamplePageTest extends BaseTest {

    private static SamplePage samplePage;

    @BeforeAll
    public static void beforeAllSetup() {
        samplePage = new SamplePage();
    }


    @Test
    public void test1() {
        assertTrue(samplePage.isLoaded());
        assertTrue(samplePage.emailBoxExists());
        assertTrue(samplePage.passwordBoxExists());
        assertTrue(samplePage.loginButtonExists());

        String emailAddress = samplePage.populateEmailAddress(Consts.EMAIL);
        assertEquals(emailAddress, Consts.EMAIL);

        String password = samplePage.populatePassword(Consts.PASSWORD);
        assertEquals(password, Consts.PASSWORD);
    }


    @Test
    public void test2() {
        assertTrue(samplePage.isLoaded());
        assertEquals(3, samplePage.getNumberOfValuesInList());

        ArrayList<String> values = samplePage.getValuesList();
        assertTrue(values.get(1).contains("List Item 2"));
        ArrayList<String> badges = samplePage.getBadgesList();
        assertEquals("6", badges.get(1));
    }

    @Test
    public void test3() {
        assertTrue(samplePage.isLoaded());
        assertEquals("Option 1", samplePage.getButtonOption());
        samplePage.chooseOption(3);
        assertEquals("Option 3", samplePage.getButtonOption());
    }

    @Test
    public void test4() {
        assertTrue(samplePage.isFirstButtonEnabled());
        assertTrue(samplePage.isSecondButtonDisabled());
    }

    @Test
    public void test5() {
        samplePage.clickTest5Button();
        assertTrue(samplePage.isTest5ButtonEnabled());
        assertTrue(samplePage.isAlertDisplayed());
    }

    @Test
    public void test6() {
        assertEquals("Ventosanzap", samplePage.findInTable(3, 2));
    }
}
