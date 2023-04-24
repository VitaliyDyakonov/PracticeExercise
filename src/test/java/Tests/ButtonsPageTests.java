package Tests;

import Pages.ButtonsPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.closeWindow;

public class ButtonsPageTests {

    ButtonsPage page = new ButtonsPage();

    @BeforeAll
    static void setUp(){
        Configuration.browserSize="1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void openPage() {
        page.openPage();
    }

    @AfterEach
    public void closePage(){
        closeWindow();
    }

    @Test
    @DisplayName("Click home button")
    public void clickHomeButton(){
        page.clickHomeButton();
    }

    @Test
    @DisplayName("Get position of button")
    public void checkButtonPosition(){
        String buttonPosition = page.getButtonPosition();
        Allure.addAttachment("Position (x,y) of button is", buttonPosition);
    }

    @Test
    @DisplayName("Get color of button")
    public void checkButtonColor(){
        String buttonColor = page.getButtonColor();;
        Allure.addAttachment("Color (RGB) of button is", buttonColor);
    }

    @Test
    @DisplayName("Get size of button")
    public void checkButtonSize(){
        String buttonPosition = page.getButtonSize();
        Allure.addAttachment("Size (width, height) of button is", buttonPosition);

    }
}
