package homeWork_16_9;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public static void openMainPage() {
        open("https://github.com/");
    }

    @Step("Search repository")
    public static void searchRepository(String repo) {
        $("[name=q]").click();
        $("[name=q]").setValue(repo).pressEnter();
    }

    @Step("Click on the link repository")
    public static void clickOnLinkRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Click on the tab Issue")
    public static void clickOnTabIssue() {
        $("#issues-tab").click();
    }

    @Step("Check for an Issue with a number")
    public static void checkNumberIssue(String issue) {
        $(".opened-by").shouldHave(text(issue));
    }


}
