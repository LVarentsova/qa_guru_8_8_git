package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SecondTest {

    @Test
    void shouldFindJUnit5OnSelenideWikiPage() {
        // открыть страницу github.com
        open("https://github.com");
        // ввести selenide в поле поиска
        // нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем линк первого результата поиска
        $$(".repo-list li").first().$("a").click();
        // нажимаем на tab Wiki
        $("#wiki-tab").click();
        // проверяем, что отобразилась wiki page
        $("#wiki-content h1").shouldHave(text("Welcome to the selenide wiki!"));
        // нажимаем на Show 2 more pages…
        $("#wiki-pages-box").$(byText("Show 2 more pages…")).click();
        // нажимаем на линк Soft assertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        // проверка: на странице SoftAssertions встречается JUnit5
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
