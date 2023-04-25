package Tests;

import Pages.ButtonsPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.closeWindow;

public class ButtonsPageTests {

    static ButtonsPage buttonsPage = new ButtonsPage();

    @BeforeAll
    static void openPage(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        buttonsPage.openPage();
    }

    @AfterAll
    static void closePage(){
        closeWindow();
    }

    @Test
    @DisplayName("Click home button")
    public void clickHomeButton(){
        buttonsPage.clickHomeButton();
        back();
    }

    @Test
    @DisplayName("Get position of button")
    public void checkButtonPosition(){
        String buttonPosition = buttonsPage.getButtonPosition();
        Allure.addAttachment("Position (x,y) of button is", buttonPosition);
    }

    @Test
    @DisplayName("Get color of button")
    public void checkButtonColor(){
        String buttonColor = buttonsPage.getButtonColor();;
        Allure.addAttachment("Color (RGB) of button is", buttonColor);
    }

    @Test
    @DisplayName("Get size of button")
    public void checkButtonSize(){
        String buttonPosition = buttonsPage.getButtonSize();
        Allure.addAttachment("Size (width, height) of button is", buttonPosition);

    }
}
