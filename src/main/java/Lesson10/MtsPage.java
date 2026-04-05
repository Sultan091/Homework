package Lesson10;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By blockTitle = By.xpath("//section[@class='pay']//h2[contains(text(),'Онлайн пополнение')]");
    private final By visaLogo = By.xpath("//section[@class='pay']//img[@alt='Visa']");
    private final By verifiedVisaLogo = By.xpath("//section[@class='pay']//img[@alt='Verified By Visa']");
    private final By masterCardLogo = By.xpath("//section[@class='pay']//img[@alt='MasterCard']");
    private final By secureCodeLogo = By.xpath("//section[@class='pay']//img[@alt='MasterCard Secure Code']");
    private final By belkartLogo = By.xpath("//section[@class='pay']//img[@alt='Белкарт']");
    private final By cookiesAgreeButton = By.id("cookie-agree");
    private final By moreInfoLink = By.xpath("//section[contains(@class,'pay')]//a[contains(text(),'Подробнее о сервисе')]");
    private final By serviceDropdown = By.xpath("//button[@class='select__header']");
    private final By serviceOptions = By.xpath("//ul[@class='select__list']//p[@class='select__option']");
    private final By serviceDropdownContainer = By.xpath("//section[contains(@class,'pay')]//div[@class='select']");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[contains(text(),'Продолжить')]");

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Проверка отображения заголовка блока 'Онлайн пополнение'")
    public boolean isBlockTitleDisplayed() { return isElementVisible(blockTitle); }

    @Step("Проверка отображения логотипа Visa")
    public boolean isVisaLogoDisplayed() { return isElementVisible(visaLogo); }

    @Step("Проверка отображения логотипа Verified By Visa")
    public boolean isVerifiedVisaLogoDisplayed() { return isElementVisible(verifiedVisaLogo); }

    @Step("Проверка отображения логотипа MasterCard")
    public boolean isMasterCardLogoDisplayed() { return isElementVisible(masterCardLogo); }

    @Step("Проверка отображения логотипа Secure Code")
    public boolean isSecureCodeLogoDisplayed() { return isElementVisible(secureCodeLogo); }

    @Step("Проверка отображения логотипа Белкарт")
    public boolean isBelkartLogoDisplayed() { return isElementVisible(belkartLogo); }

    @Step("Принятие cookie")
    public void clickCookieAgreeButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookiesAgreeButton)).click();
        } catch (Exception ignored) {}
    }

    @Step("Нажатие на ссылку 'Подробнее о сервисе'")
    public void clickMoreInfoLink() { wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink)).click(); }

    @Step("Ожидание, пока URL будет содержать: {text}")
    public void waitForUrlContains(String text) { wait.until(ExpectedConditions.urlContains(text)); }

    @Step("Открытие выпадающего списка услуг")
    public void openServiceDropdown() { wait.until(ExpectedConditions.elementToBeClickable(serviceDropdown)).click(); }

    @Step("Получение списка доступных услуг")
    public List<String> getServiceOptionsText() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(serviceOptions))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public WebElement getServiceDropdownContainerElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serviceDropdownContainer));
    }

    @Step("Скролл к элементу")
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    @Step("Ввод номера телефона: {phone}")
    public void enterPhone(String phone) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        input.clear();
        input.sendKeys(phone);
    }

    @Step("Ввод суммы: {sum}")
    public void enterSum(String sum) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput));
        input.clear();
        input.sendKeys(sum);
    }

    @Step("Нажатие кнопки 'Продолжить'")
    public void clickContinue() { wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click(); }
}
