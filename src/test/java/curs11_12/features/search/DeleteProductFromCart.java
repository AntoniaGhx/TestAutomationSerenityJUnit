package curs11_12.features.search;

import curs11_12.steps.serenity.AddProductSteps;
import curs11_12.steps.serenity.DeleteProductSteps;
import curs11_12.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
@RunWith(SerenityRunner.class)
public class DeleteProductFromCart {

        @Managed(uniqueSession = true, driver="chrome")
        public WebDriver webdriver;

        @Steps
        public EndUserSteps steps;

        @Steps
        public DeleteProductSteps deleteSteps;

        @Issue("#WIKI-1")
        @Test
        public void deleteproductFromCart() {
            steps.is_the_home_page();
            steps.click_perfume_products();
            steps.choose_perfume();
            steps.add_to_card();
            steps.scrollUpBy300();
            steps.continue_button_message();
            steps.scrollUpBy300();
            steps.click_cart();
            steps.click_delete_item();
            deleteSteps.go_to_main_page();
        }
}
