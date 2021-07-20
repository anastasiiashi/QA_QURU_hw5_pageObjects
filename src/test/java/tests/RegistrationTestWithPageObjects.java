package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTestWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    void successfulRegistrationFormTest() {
        registrationPage.openPage();
        faker.name().firstName();
        faker.name().lastName();
    }
}
