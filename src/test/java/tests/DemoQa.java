package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class DemoQa {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll()
    public static void config() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "-10x0";
    }

    @Test
    void homeworkTest() {
         registrationFormPage.openPage()
                  .setFirstName("Vadim")
                  .setLastName("Frolov")
                  .setEmail("vadim.frolov.2018@inbox.ru")
                  .setGender("Male")
                  .setNumber("89968060794")
                  .setBirthDate("15", "October", "1998")
                  .setSubjects("Maths")
                  .setHobbies("Sports")
                  .downloadPic("test.png")
                  .setState("NCR")
                  .setAddress("Moscow")
                  .setCity("Delhi")
                  .submit()
                  .checkVisible()

                  .resultsTable("Date of Birth", "15 October,1998")
                  .resultsTable("Student Email", "vadim.frolov.2018@inbox.ru")
                  .resultsTable("Student Name", "Vadim Frolov");
    }
}
