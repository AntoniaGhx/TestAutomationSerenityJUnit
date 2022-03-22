package curs11_12.steps.serenity;

import curs11_12.pages.CartPage;
import curs11_12.pages.DictionaryPage;
import curs11_12.pages.LoginPage;
import curs11_12.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void click_perfume_products() {dictionaryPage.click_perfumeProducts();}

    @Step
    public void click_on_page() {dictionaryPage.click_on_main();
    }
    @Step
    public void click_cart() {dictionaryPage.click_on_cart();
    }
    @Step
    public void click_account () {dictionaryPage.click_myAccount();}

    @Step
    public void insert_email(String email) {loginPage.enterEmail(email);}

    @Step
    public void insert_password(String password) {loginPage.enterPassword(password);}

    @Step
    public void click_login_button() {loginPage.clickLoginButton();}

    @Step
    public void choose_perfume() {productPage.click_perfume();}

    @Step
    public void add_to_card() {productPage.click_buy_button();}

    @Step
    public void scrollUpBy300() {productPage.pageUpBy300();}

    @Step
    public void click_on_message() {productPage.click_on_message_outside();}

    @Step
    public void click_for_cart() {productPage.click_go_see_cart();}

    @Step
    public void click_exit() {productPage.click_exit_button();}

    @Step
    public void continue_button_message() {productPage.continue_button();}

    @Step
    public void click_delete_item() {cartPage.clickDelete();}
}