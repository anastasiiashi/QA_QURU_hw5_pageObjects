package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }
}
