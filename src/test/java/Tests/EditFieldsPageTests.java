package Tests;

import Pages.EditFieldsPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWindow;


public class EditFieldsPageTests {

    static EditFieldsPage EditFieldsPage = new EditFieldsPage();

    @BeforeAll
    static void openPage(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        EditFieldsPage.openPage();
    }

    @AfterAll
    static void closePage(){
        closeWindow();
    }

    @Test
    @DisplayName("Enter email address")
    public void enterEmailInField(){
        EditFieldsPage.enterEmail("test_email@mail.ru");
        EditFieldsPage.assertEnteredEmail("test_email@mail.ru");
    }

    @Test
    @DisplayName("Append text in field and press keyboard tab")
    public void appendTextInField(){
        EditFieldsPage.appendText("New text");
        EditFieldsPage.appendFieldPressTab();
        EditFieldsPage.assertAppendedText("New text");
    }

    @Test
    @DisplayName("Get text from field")
    public void getTextInField(){
        String text = EditFieldsPage.getTextInField();
        Allure.addAttachment("Default text in field is", text);
        EditFieldsPage.assertGottenText(text);
    }

    @Test
    @DisplayName("Clear text in field")
    public void clearTextInField(){
        EditFieldsPage.clearText();
        EditFieldsPage.assertClearedText();
    }

    @Test
    @DisplayName("Confirm that field is disabled")
    public void checkDisabledField(){
        EditFieldsPage.assertDisabledField();
    }
}
