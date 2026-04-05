package org.example;

import Lesson10.MtsPage;
import Lesson10.PaymentModal;
import io.qameta.allure.*;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование сайта МТС")
@Feature("Оплата услуг")
@ExtendWith(TestWatcherExtension.class)
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
    @DisplayName("Проверка заголовка блока оплаты")
    @Severity(SeverityLevel.TRIVIAL)
    void checkBlockTitle() {
        assertTrue(mtsPage.isBlockTitleDisplayed(), "Заголовок блока не виден");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    @Severity(SeverityLevel.MINOR)
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
    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
    @Story("Навигация по ссылкам")
    void checkMoreInfoLink() {
        mtsPage.clickMoreInfoLink();
        mtsPage.waitForUrlContains("poryadok-oplaty");
        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }

    @Test
    @DisplayName("Проверка кнопки оплаты услуг связи")
    @Description("Вводим данные и проверяем текст на итоговой кнопке в iframe")
    @Severity(SeverityLevel.CRITICAL)
    void checkContinueButtonForCommunication() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterSum("55");
        mtsPage.clickContinue();
        paymentModal.switchToPaymentFrame();
        String buttonText = paymentModal.getPayButtonText();
        assertEquals("Оплатить 55.00 BYN", buttonText, "Текст на кнопке не совпадает!");
    }

    @Test
    @DisplayName("Проверка опций выпадающего списка")
    void checkServiceDropdownOptions() {
        mtsPage.openServiceDropdown();
        WebElement dropdownContainer = mtsPage.getServiceDropdownContainerElement();
        mtsPage.scrollToElement(dropdownContainer);
        List<String> actualOptions = mtsPage.getServiceOptionsText();
        List<String> expectedOptions = List.of("Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность");
        assertEquals(expectedOptions, actualOptions, "Опции в списке не совпадают");
    }

    @Test
    @DisplayName("Комплексная проверка деталей в модальном окне")
    @Severity(SeverityLevel.BLOCKER)
    void checkPaymentDetails() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterSum("10");
        mtsPage.clickContinue();

        paymentModal.switchToPaymentFrame();

        assertAll("Логотипы и поля в модалке",
                () -> assertTrue(paymentModal.isVisaLogoDisplayed(), "Лого Visa не отображается"),
                () -> assertTrue(paymentModal.isMastercardLogoDisplayed(), "Лого Mastercard не отображается"),
                () -> assertTrue(paymentModal.isBelkartLogoDisplayed(), "Лого Белкарт не отображается"),
                () -> assertEquals("10.00 BYN", paymentModal.getPaySum()),
                () -> assertEquals("Номер карты", paymentModal.getCardNumberLabelText()),
                () -> assertEquals("Имя и фамилия на карте", paymentModal.getHolderNameLabelText())
        );
    }
}
