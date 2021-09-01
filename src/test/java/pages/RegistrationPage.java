package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final static String FORM_TITLE = "Student Registration Form";
    private final Calendar calendar = new Calendar();

    private SelenideElement modal = $("[role=document]");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {

        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage typePhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationPage uploadPicture(String pathToPicture) {
        $("#uploadPicture").uploadFile(new File(pathToPicture));
        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public RegistrationPage selectState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }


    public RegistrationPage clickSubmitButton() {
        $("#submit").scrollTo().click();
        return this;
    }

    public RegistrationPage checkResultValue(String formValue) {
        modal.$(".table-responsive").shouldHave(text(formValue));
        return this;
    }

}
