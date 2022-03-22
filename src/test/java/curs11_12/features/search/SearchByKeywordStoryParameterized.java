package curs11_12.features.search;

import curs11_12.steps.serenity.EndUserSteps;
import curs11_12.steps.serenity.ResultSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/search/SearchData.csv")
public class SearchByKeywordStoryParameterized {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps steps;

    @Steps
    public ResultSteps resSteps;

    String word,description;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_should_display_the_corresponding_article_parameterized() {
        steps.is_the_home_page();
        steps.looks_for(word);
        resSteps.should_see_definition(description);

    }
}