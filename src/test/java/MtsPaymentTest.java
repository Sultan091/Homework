import Lesson10.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MtsPaymentTest extends BaseTest {
    private MtsPage mtsPage;
    private PaymentModal paymentModal;

    @BeforeEach
    void setup() {
        mtsPage = new MtsPage(driver);
        paymentModal = new PaymentModal(driver);
        mtsPage.clickCookieAgreeButton();
    }

    @Test
    void checkBlockTitle() {
        assertTrue(mtsPage.isBlockTitleDisplayed(), "Заголовок блока не виден");
    }

    @Test
    void checkPaymentLogos() {
        assertAll("Логотипы платежных систем",
                () -> assertTrue(mtsPage.isVisaLogoDisplayed()),
                () -> assertTrue(mtsPage.isVerifiedVisaLogoDisplayed()),
                () -> assertTrue(mtsPage.isMasterCardLogoDisplayed()),
                () -> assertTrue(mtsPage.isSecureCodeLogoDisplayed()),
                () -> assertTrue(mtsPage.isBelkartLogoDisplayed())
        );
    }

    @Test
    void checkMoreInfoLink() {
        mtsPage.clickMoreInfoLink();
        mtsPage.waitForUrlContains("poryadok-oplaty");
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    void checkContinueButtonForCommunication() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterSum("55");
        mtsPage.clickContinue();
        paymentModal.switchToPaymentFrame();
        String buttonText = paymentModal.getPayButtonText();
        assertEquals("Оплатить 55.00 BYN", buttonText, "Текст на кнопке не совпадает!");
    }

    @Test
    void checkServiceDropdownOptions() {
        mtsPage.openServiceDropdown();
        WebElement dropdownContainer = mtsPage.getServiceDropdownContainerElement();
        mtsPage.scrollToElement(dropdownContainer);
        List<String> actualOptions = mtsPage.getServiceOptionsText();
        List<String> expectedOptions = List.of("Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность");
        assertEquals(expectedOptions, actualOptions, "Опции в списке не совпадают");
    }

    @Test
    void checkPaymentDetails() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterSum("10");
        mtsPage.clickContinue();

        paymentModal.switchToPaymentFrame();
        assertAll("Логотипы в модалке оплаты",
                () -> assertTrue(paymentModal.isVisaLogoDisplayed(), "Лого Visa не отображается"),
                () -> assertTrue(paymentModal.isMastercardLogoDisplayed(), "Лого Mastercard не отображается"),
                () -> assertTrue(paymentModal.isBelkartLogoDisplayed(), "Лого Белкарт не отображается"),
                () -> assertTrue(paymentModal.isActiveRandomLogoDisplayed(), "Рандомный логотип (МИР/Maestro) не виден")
        );
        assertAll("Детали платежа в модалке",
                () -> assertEquals("10.00 BYN", paymentModal.getPaySum()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", paymentModal.getPaymentDescriptionText()),
                () -> assertEquals("Номер карты", paymentModal.getCardNumberLabelText()),
                () -> assertEquals("Срок действия", paymentModal.getExpirationDateLabelText()),
                () -> assertEquals("CVC", paymentModal.getCvcLabelText()),
                () -> assertEquals("Имя и фамилия на карте", paymentModal.getHolderNameLabelText())
        );
    }
}
