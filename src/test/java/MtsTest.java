import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");

        try {
            WebElement cookieButton = driver.findElement(By.xpath("//button[contains(text(),'Принять')]"));
            cookieButton.click();
        } catch (Exception e) {
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        assertTrue(title.getText().contains("Онлайн пополнение"));
    }

    @Test
    public void checkPaymentLogos() {
        List<WebElement> logos = driver.findElements(
                By.xpath("//div[@class='pay__partners']//img")
        );
        assertFalse(logos.isEmpty());
        assertEquals(5, logos.size());
    }

    @Test
    public void checkMoreLink() {
        WebElement link = driver.findElement(
                By.xpath("//section[@class='pay']//a")
        );
        link.click();
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    public void fillFormAndSubmit() {
        WebElement phone = driver.findElement(By.id("connection-phone"));
        WebElement sum = driver.findElement(By.id("connection-sum"));
        WebElement email = driver.findElement(By.id("connection-email"));
        WebElement button = driver.findElement(By.xpath("//form[@id='pay-connection']//button"));
        phone.sendKeys("297777777");
        sum.sendKeys("10");
        email.sendKeys("test@test.com");
        button.click();
        assertTrue(driver.getCurrentUrl().contains("mts.by"));
    }
}