package Utils;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    private static WebDriver driver;
    private static BasePage page;


    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        driver = ShareDriver.getWebDriver();
        page.setWebDriver(driver);
        Path sampleFile = Paths.get("QE-index.html");
        driver.get(sampleFile.toUri().toString());
    }

    @AfterAll
    public static void tearDownMain() {
        ShareDriver.closeDriver();
        driver = null;
    }
}
