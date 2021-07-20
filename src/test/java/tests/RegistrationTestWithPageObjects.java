package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTestWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Anastasiia");
        registrationPage.typeLastName("Morozova");
    }
}
