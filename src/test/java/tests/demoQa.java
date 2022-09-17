package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class demoQa {
    @Test
    void homeworkTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "-10x0";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Frolov");
        $("#userEmail").setValue("vadim.frolov.2018@inbox.ru");
        $(byTagAndText("label", "Male")).click();
        $("#userNumber").setValue("89968060794");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byTagAndText("label", "Sports")).click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#currentAddress").setValue("Moscow");
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldBe(Condition.appear);
        $(".table-responsive table").shouldHave(Condition.text("vadim.frolov.2018@inbox.ru"),Condition.text("8996806079"));
        sleep(3000);
    }
}
