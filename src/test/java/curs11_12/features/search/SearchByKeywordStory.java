package curs11_12.features.search;

import curs11_12.steps.serenity.ResultSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import curs11_12.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps steps;

    @Steps
    public ResultSteps resSteps;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_nuxe_should_display_the_products() {
        steps.is_the_home_page();
        steps.looks_for("nuxe");
        //steps.starts_search();
       resSteps.go_to_definition("Cosmeticele Nuxe combină puterea naturii, eficiența științei și plăcerea simțurilor, " +
               "pentru trăiri intense, pline de bucurii. Acest concept este reflectat atât de numele brandului, " +
               "creat prin combinarea cuvintelor „Natură“ și „Lux“, cât și de toate produsele Nuxe." +
               " Cosmeticele Nuxe nu conțin parabeni sau uleiuri minerale.");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {}
} 