package Lesson10;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentModal {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By paymentFrame = By.xpath("//iframe[contains(@class,'payment-widget-iframe')]");
    private final By paySum = By.xpath("//div[contains(@class,'pay-description__cost')]//span");
    private final By paymentDescription = By.xpath("//div[contains(@class, 'pay-description__text')]/span");
    private final By payButton = By.xpath("//button[contains(., 'плат') or contains(., 'BYN')]");
    private final By cardNumberLabel = By.xpath("//label[text()='Номер карты']");
    private final By expirationDateLabel = By.xpath("//label[text()='Срок действия']");
    private final By cvcLabel = By.xpath("//label[text()='CVC']");
    private final By holderNameLabel = By.xpath("//label[text()='Имя и фамилия на карте']");
    private final By visaLogo = By.xpath("//img[contains(@src, 'visa-system')]");
    private final By mastercardLogo = By.xpath("//img[contains(@src, 'mastercard-system')]");
    private final By belkartLogo = By.xpath("//img[contains(@src, 'belkart-system')]");
    private final By activeRandomLogo = By.xpath("//div[contains(@class, 'cards-brands_random')]//img[contains(@style, 'opacity: 1')]");

    public PaymentModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void switchToPaymentFrame() {
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
    }

    private boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText().trim();
    }

    public String getPaySum() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paySum)).getText().trim();
    }

    public String getPaymentDescriptionText() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDescription)).getText();
        return text.replace("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public String getCardNumberLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)).getText(); }
    public String getExpirationDateLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDateLabel)).getText(); }
    public String getCvcLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabel)).getText(); }
    public String getHolderNameLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(holderNameLabel)).getText(); }
    public boolean isVisaLogoDisplayed() { return isElementVisible(visaLogo); }
    public boolean isMastercardLogoDisplayed() { return isElementVisible(mastercardLogo); }
    public boolean isBelkartLogoDisplayed() { return isElementVisible(belkartLogo); }
    public boolean isActiveRandomLogoDisplayed() { return isElementVisible(activeRandomLogo); }
}
