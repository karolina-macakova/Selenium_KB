package base;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.BeforeEach;
import utils.WebDriverManager;
import java.time.Duration;

public class BaseTest {

    // WebDriver instance for the test
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        //TODO - parallel testing in different browsers
        driver = WebDriverManager.getDriver("firefox");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //TODO Navigate to a base URL (could come from config)
        driver.get("https://www.saucedemo.com");
    }

    @AfterEach
    public void tearDown() {
        // Quit the WebDriver after each test
        WebDriverManager.quitDriver();
    }
}
