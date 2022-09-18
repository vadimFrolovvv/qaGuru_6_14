package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTable resultsTable = new ResultsTable();

    private SelenideElement
            inputFirstName =  $("#firstName"),
            inputLastname =  $("#lastName"),
            inputEmail = $("#userEmail"),
            radiobuttonGender = $("#genterWrapper"),
            inputNumber =  $("#userNumber"),
            buttonDateOfBirth = $("#dateOfBirthInput"),
            inputSubjects = $("#subjectsInput"),
            checkboxHobbies = $("#hobbiesWrapper"),
            buttonDownloadPic = $("#uploadPicture"),
            buttonState = $("#state"),
            selectState = $("#stateCity-wrapper"),
            inputAddress = $("#currentAddress"),
            buttonCity = $("#city"),
            selectCity = $("#stateCity-wrapper"),
            buttonSubmit = $("#submit");

    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        inputFirstName.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        inputLastname.setValue(lastName);

        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        inputEmail.setValue(email);

        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        radiobuttonGender.$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String number) {
        inputNumber.setValue(number);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        buttonDateOfBirth.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String subjects) {
        inputSubjects.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String hobbies) {
        checkboxHobbies.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationFormPage downloadPic(String nameFile) {
        buttonDownloadPic.uploadFromClasspath(nameFile);

        return this;
    }

    public RegistrationFormPage setState(String state) {
        buttonState.click();
        selectState.$(byText(state)).click();

        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        inputAddress.setValue(address);

        return this;
    }

    public RegistrationFormPage setCity(String city) {
        buttonCity.click();
        selectCity.$(byText(city)).click();

        return this;
    }

    public RegistrationFormPage submit() {
        buttonSubmit.click();

        return this;
    }

    public RegistrationFormPage checkVisible() {
        resultsTable.checkWindow();

        return this;
    }

    public RegistrationFormPage resultsTable(String key, String value) {
        resultsTable.checkTable(key, value);

        return this;
    }
}
