package Tests;

import Pages.EditFieldsPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.sleep;

public class EditFieldsPageTests {

    EditFieldsPage page = new EditFieldsPage();

    @BeforeAll
    static void setUp(){
        Configuration.browserSize="1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void openPage(){
        page.openPage();
    }

    @AfterEach
    public void closePage(){
        closeWindow();
    }

    @Test
    @DisplayName("Enter email address")
    public void enterEmailInField(){
        page.enterEmail("test_email@mail.ru");
        page.assertEnteredEmail("test_email@mail.ru");
    }

    @Test
    @DisplayName("Append text in field and press keyboard tab")
    public void appendTextInField(){
        page.appendText("New text");
        page.appendFieldPressTab();
        page.assertAppendedText("New text");
    }

    @Test
    @DisplayName("Get text from field")
    public void getTextInField(){
        String text = page.getTextInField();
        Allure.addAttachment("Default text in field is", text);
        page.assertGottenText(text);
    }

    @Test
    @DisplayName("Clear text in field")
    public void clearTextInField(){
        page.clearText();
        page.assertClearedText();
    }

    @Test
    @DisplayName("Confirm that field is disabled")
    public void checkDisabledField(){
        page.assertDisabledField();
    }
}
