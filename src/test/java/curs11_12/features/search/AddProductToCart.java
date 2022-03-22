package curs11_12.features.search;

import curs11_12.steps.serenity.AddProductSteps;
import curs11_12.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddProductToCart {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps steps;

    @Steps
    public AddProductSteps addsteps;

    @Issue("#WIKI-1")
    @Test
    public void addOneProductToCart() {
        steps.is_the_home_page();
        steps.click_perfume_products();
        steps.choose_perfume();
        steps.add_to_card();
        steps.scrollUpBy300();
        steps.continue_button_message();
        steps.scrollUpBy300();
        steps.click_cart();
        addsteps.go_to_message("Coș de cumpărături");
    }

}
