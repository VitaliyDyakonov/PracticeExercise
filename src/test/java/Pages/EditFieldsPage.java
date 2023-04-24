package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditFieldsPage {

    private String baseUrl = "C:\\Users\\Виталий\\IdeaProjects\\OzonPractice\\src\\test\\resources\\PageSource\\Edit Fields.html";

    private SelenideElement emailField = $("#email");

    private SelenideElement appendTextField = $(byText("Append a text and press keyboard tab")).parent().$("input[type=text]");

    private SelenideElement getTextField = $(byText("Get default text entered")).parent().$("input[type=text]");

    private SelenideElement clearTextField = $(byText("Clear the text")).parent().$("input[type=text]");

    private SelenideElement disabledField = $(byText("Confirm that edit field is disabled")).parent().$("input[type=text]");

    public EditFieldsPage openPage(){
        open(baseUrl);
        return this;
    }

    public EditFieldsPage enterEmail(String email){
        emailField.setValue(email);
        return this;
    }

    public EditFieldsPage assertEnteredEmail(String assertedEmail){
        emailField.shouldHave(value(assertedEmail));
        return this;
    }

    public EditFieldsPage appendText(String text){
        appendTextField.append(text);
        return this;
    }

    public EditFieldsPage appendFieldPressTab(){
        appendTextField.pressTab();
        return this;
    }

    public EditFieldsPage assertAppendedText(String text){
        appendTextField.shouldHave(value(text));
        return this;
    }

    public String getTextInField(){
        return getTextField.getValue();
    }

    public EditFieldsPage assertGottenText(String text){
        getTextField.shouldHave(value(text));
        return this;
    }

    public EditFieldsPage clearText(){
        clearTextField.clear();
        return this;
    }

    public EditFieldsPage assertClearedText(){
        clearTextField.shouldBe(empty);
        return this;
    }

    public EditFieldsPage assertDisabledField(){
        disabledField.shouldNotBe(enabled);
        return this;
    }
}
