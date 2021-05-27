package domaszka;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class CodeExampleForJunit5 {
    @BeforeAll
    static void setUp() {

        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }
    @Test
    void checkExampleOfCode(){
    //    - Откройте страницу Selenide в Github
        open("https://github.com/");
        $("[name='q']").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
    // - Перейдите в раздел Wiki проекта
        $("[data-tab-item=\"i4wiki-tab\"]").click();
    // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byText("Show 1 more pages…")).scrollTo().click();
        $x(("//a[contains(text(),'SoftAssertions')]"))
    // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
                .click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
        System.out.println("The test is complete!");

    }
}



