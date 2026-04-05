package Lesson10;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class PaymentModal {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By paymentFrame = By.xpath("//iframe[contains(@class,'payment-widget-iframe')]");
    private final By paySum = By.xpath("//div[contains(@class,'pay-description__cost')]//span");
    private final By paymentDescription = By.xpath("//div[contains(@class, 'pay-description__text')]/span");
    private final By payButton = By.xpath("//button[contains(., 'плат') or contains(., 'BY n')]");
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

    @Step("Переключение во фрейм оплаты")
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

    @Step("Получение текста кнопки оплаты")
    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText().trim();
    }

    @Step("Получение суммы оплаты из модального окна")
    public String getPaySum() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paySum)).getText().trim();
    }

    @Step("Получение описания платежа")
    public String getPaymentDescriptionText() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDescription)).getText();
        return text.replace("\n", " ").replaceAll("\\s+", " ").trim();
    }

    @Step("Проверка текста лейбла 'Номер карты'")
    public String getCardNumberLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel)).getText(); }

    @Step("Проверка текста лейбла 'Срок действия'")
    public String getExpirationDateLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDateLabel)).getText(); }

    @Step("Проверка текста лейбла 'CVC'")
    public String getCvcLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabel)).getText(); }

    @Step("Проверка текста лейбла 'Имя и фамилия'")
    public String getHolderNameLabelText() { return wait.until(ExpectedConditions.visibilityOfElementLocated(holderNameLabel)).getText(); }

    @Step("Проверка отображения логотипа Visa во фрейме")
    public boolean isVisaLogoDisplayed() { return isElementVisible(visaLogo); }

    @Step("Проверка отображения логотипа Mastercard во фрейме")
    public boolean isMastercardLogoDisplayed() { return isElementVisible(mastercardLogo); }

    @Step("Проверка отображения логотипа Белкарт во фрейме")
    public boolean isBelkartLogoDisplayed() { return isElementVisible(belkartLogo); }

    @Step("Проверка отображения случайного логотипа системы")
    public boolean isActiveRandomLogoDisplayed() { return isElementVisible(activeRandomLogo); }
}
