package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTable {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsTable checkWindow() {
        $(".modal-content").shouldBe(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text(TITLE_TEXT));

        return this;
    }

    public ResultsTable checkTable(String key, String value) {
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(Condition.text(value));

        return this;
    }
}
