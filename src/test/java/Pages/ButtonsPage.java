package Pages;

import com.codeborne.selenide.SelenideElement;

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

    public ButtonsPage clickHomeButton(){
        homeButton.click();
        return this;
    }

    public String getButtonPosition(){
        return positionButton.getCoordinates().onPage().toString();
    }

    public String getButtonColor() {
        return colorButton.getCssValue("background-color");

    }

    public String getButtonSize() {
        return sizeButton.getSize().toString();
    }
}
