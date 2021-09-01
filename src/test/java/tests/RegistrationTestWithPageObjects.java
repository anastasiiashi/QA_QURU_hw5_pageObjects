package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTestWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @BeforeAll
    static void setup() {

        Configuration.startMaximized = true;
    }
    @Test
    void successfulRegistrationFormTest() {

        //define the test values
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Female";
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String day = "13";
        String month = "August";
        String year = "1991";
        String subject = "Comp";
        String hobby = "Reading";
        String pathToPicture = "src/test/resources/not_pass.jpg";
        String currentAddress = faker.address().fullAddress();
        String state = "Haryana";
        String city = "Karnal";

        //fill the form with test data
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .setGender(gender)
                .typePhoneNumber(phoneNumber)
                .setDateOfBirth(day, month, year)
                .selectSubject(subject)
                .setHobby(hobby)
                .uploadPicture(pathToPicture)
                .typeCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmitButton();

        //check if the filled in data is correct
        registrationPage.checkResultValue(firstName + " " + lastName)
                .checkResultValue(email)
                .checkResultValue(gender)
                .checkResultValue(phoneNumber)
                .checkResultValue(day + " " + month + "," + year)
                .checkResultValue(subject)
                .checkResultValue(hobby)
                .checkResultValue("not_pass.jpg")
                .checkResultValue(currentAddress)
                .checkResultValue(state + " " + city);
    }

}
