package ru.netology;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import ru.netology.page.PurchasePage;



import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataGenerator.*;
import static ru.netology.data.DataHelper.*;

public class TourPurchaseTest {

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void openPage() {
        open("http://localhost:8080");
    }

    @AfterAll
    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        databaseCleanUp();
    }

    @Nested
    //Тесты на валидацию полей платежной формы:
    public class PaymentFormFieldValidation {

        @BeforeEach
        public void setPayment() {
            var purchasePage = new PurchasePage();
            purchasePage.cardPayment();
        }

        @Test
        @DisplayName("Отправка пустой формы")
        public void shouldEmpty() {
            var purchasePage = new PurchasePage();
            purchasePage.emptyForm();
        }

        @Test
        @DisplayName("Поле 'Номер карты', пустое поле")
        public void shouldEmptyCardNumberField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyCardNumberField(info);
        }

        @Test
        @DisplayName("Поле 'Номер карты', не полный номер карты")
        public void shouldCardWithIncompleteCardNumber() {
            var purchasePage = new PurchasePage();
            var info = getCardWithIncompleteCardNumber();
            purchasePage.invalidCardNumberField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', пустое поле")
        public void shouldEmptyMonthField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', просроченный месяц")
        public void shouldCardWithOverdueMonth() {
            var purchasePage = new PurchasePage();
            var info = getCardWithOverdueMonth();
            purchasePage.invalidMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', нижнее негативное значение '00'")
        public void shouldCardWithLowerMonthValue() {
            var purchasePage = new PurchasePage();
            var info = getCardWithLowerMonthValue();
            purchasePage.invalidMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', верхнее негативное значение '13'")
        public void shouldCardWithGreaterMonthValue() {
            var purchasePage = new PurchasePage();
            var info = getCardWithGreaterMonthValue();
            purchasePage.invalidMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Год', пустое поле")
        public void shouldEmptyYearField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyYearField(info);
        }

        @Test
        @DisplayName("Поле 'Год', просроченный год")
        public void shouldCardWithOverdueYear() {
            var purchasePage = new PurchasePage();
            var info = getCardWithOverdueYear();
            purchasePage.invalidYearField(info);
        }

        @Test
        @DisplayName("Поле 'Год', год из отдаленного будущего")
        public void shouldCardWithYearFromFuture() {
            var purchasePage = new PurchasePage();
            var info = getCardWithYearFromFuture();
            purchasePage.invalidYearField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', пустое поле")
        public void shouldEmptyOwnerField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', с пробелом или дефисом")
        public void shouldCardWithSpaceOrHyphenOwner() {
            var purchasePage = new PurchasePage();
            var info = getCardWithSpaceOrHyphenOwner();
            purchasePage.invalidOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', с несколькими спец символами")
        public void shouldCardWithSpecialSymbolsOwner() {
            var purchasePage = new PurchasePage();
            var info = getCardWithSpecialSymbolsOwner();
            purchasePage.invalidOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', с цифрами")
        public void shouldCardWithNumbersOwner() {
            var purchasePage = new PurchasePage();
            var info = getCardWithNumbersOwner();
            purchasePage.invalidOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'CVC/CVV', пустое поле")
        public void shouldEmptyCVCField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyCVCField(info);
        }

        @Test
        @DisplayName("Поле 'CVC/CVV', не полный номер")
        public void shouldCardWithIncompleteCVC() {
            var purchasePage = new PurchasePage();
            var info = getCardWithIncompleteCVC();
            purchasePage.invalidCVCField(info);
        }
    }

    @Nested
    //Тесты на валидацию полей кредитной формы:
    public class CreditFormFieldValidation {

        @BeforeEach
        public void setPayment() {
            var purchasePage = new PurchasePage();
            purchasePage.cardCredit();
        }

        @Test
        @DisplayName("Отправка пустой формы")
        public void shouldEmpty() {
            var purchasePage = new PurchasePage();
            purchasePage.emptyForm();
        }

        @Test
        @DisplayName("Поле 'Номер карты', пустое поле")
        public void shouldEmptyCardNumberField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyCardNumberField(info);
        }

        @Test
        @DisplayName("Поле 'Номер карты', не полный номер карты")
        public void shouldCardWithIncompleteCardNumber() {
            var purchasePage = new PurchasePage();
            var info = getCardWithIncompleteCardNumber();
            purchasePage.invalidCardNumberField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', пустое поле")
        public void shouldEmptyMonthField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', просроченный месяц")
        public void shouldCardWithOverdueMonth() {
            var purchasePage = new PurchasePage();
            var info = getCardWithOverdueMonth();
            purchasePage.invalidMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', нижнее негативное значение '00'")
        public void shouldCardWithLowerMonthValue() {
            var purchasePage = new PurchasePage();
            var info = getCardWithLowerMonthValue();
            purchasePage.invalidMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Месяц', верхнее негативное значение '13'")
        public void shouldCardWithGreaterMonthValue() {
            var purchasePage = new PurchasePage();
            var info = getCardWithGreaterMonthValue();
            purchasePage.invalidMonthField(info);
        }

        @Test
        @DisplayName("Поле 'Год', пустое поле")
        public void shouldEmptyYearField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyYearField(info);
        }

        @Test
        @DisplayName("Поле 'Год', просроченный год")
        public void shouldCardWithOverdueYear() {
            var purchasePage = new PurchasePage();
            var info = getCardWithOverdueYear();
            purchasePage.invalidYearField(info);
        }

        @Test
        @DisplayName("Поле 'Год', год из отдаленного будущего")
        public void shouldCardWithYearFromFuture() {
            var purchasePage = new PurchasePage();
            var info = getCardWithYearFromFuture();
            purchasePage.invalidYearField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', пустое поле")
        public void shouldEmptyOwnerField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', с пробелом или дефисом")
        public void shouldCardWithSpaceOrHyphenOwner() {
            var purchasePage = new PurchasePage();
            var info = getCardWithSpaceOrHyphenOwner();
            purchasePage.invalidOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', с несколькими спец символами")
        public void shouldCardWithSpecialSymbolsOwner() {
            var purchasePage = new PurchasePage();
            var info = getCardWithSpecialSymbolsOwner();
            purchasePage.invalidOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'Владелец', с цифрами")
        public void shouldCardWithNumbersOwner() {
            var purchasePage = new PurchasePage();
            var info = getCardWithNumbersOwner();
            purchasePage.invalidOwnerField(info);
        }

        @Test
        @DisplayName("Поле 'CVC/CVV', пустое поле")
        public void shouldEmptyCVCField() {
            var purchasePage = new PurchasePage();
            var info = getApprovedCard();
            purchasePage.emptyCVCField(info);
        }

        @Test
        @DisplayName("Поле 'CVC/CVV', не полный номер")
        public void shouldCardWithIncompleteCVC() {
            var purchasePage = new PurchasePage();
            var info = getCardWithIncompleteCVC();
            purchasePage.invalidCVCField(info);
        }
    }
}
