package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ButtonsPage {

    private String baseUrl = "C:\\Users\\Виталий\\IdeaProjects\\OzonPractice\\src\\test\\resources\\PageSource\\Buttons.html";

    private SelenideElement homeButton = $("#home");

    private SelenideElement positionButton = $("#position");

    private SelenideElement colorButton = $("#color");

    private SelenideElement sizeButton = $("#size");

    public ButtonsPage openPage() {
        open(baseUrl);
        return this;
    }

    @Step("Нажать кнопку \"Go to home page\"")
    public ButtonsPage clickHomeButton(){
        homeButton.click();
        return this;
    }

    @Step("Получить координаты кнопки \"Get Position\"")
    public String getButtonPosition(){
        return positionButton.getCoordinates().onPage().toString();
    }

    @Step("Получить RGB цвет кнопки \"What color am i?\"")
    public String getButtonColor() {
        return colorButton.getCssValue("background-color");

    }

    @Step("Получить значения ширины и высоты кнопки \"What is my size?\"")
    public String getButtonSize() {
        return sizeButton.getSize().toString();
    }
}
