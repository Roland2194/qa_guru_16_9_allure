package homeWork_16_9;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static homeWork_16_9.WebSteps.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GitHubTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "#81";

    @Test
    public void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("[name=q]").click();
        $("[name=q]").setValue("eroshenkoam/allure-example").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(".opened-by").shouldHave(text("#81"));
    }

    @Test
    public void searchIssueTestWithLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com/");
        });
        step("Search repository " + REPOSITORY, () -> {
            $("[name=q]").click();
            $("[name=q]").setValue(REPOSITORY).pressEnter();
        });
        step("Click on the link repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Click on the tab Issue", () -> {
            $("#issues-tab").click();
        });
        step("Check for an Issue with a number " + ISSUE, () -> {
            $(".opened-by").shouldHave(text(ISSUE));
        });
    }

    @Test
    public void searchIssueTestWithAnnotationStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        openMainPage();
        searchRepository(REPOSITORY);
        clickOnLinkRepository(REPOSITORY);
        clickOnTabIssue();
        checkNumberIssue(ISSUE);
    }
}