package curs11_12.features.search;

import curs11_12.steps.serenity.EndUserSteps;
import curs11_12.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ValidAndInvalidId {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps steps;

    @Steps
    public LoginSteps loginSteps;

    @Issue("#WIKI-1")
    @Test
    public void validLogin() {
        steps.is_the_home_page();
        steps.click_account();
        steps.insert_email("sibianu.antonia@gmail.com");
        steps.insert_password("validLogIn");
        steps.click_login_button();
        loginSteps.go_to_account("ANTONIA MIHAELA");
    }

    @Test
    public void invalidLogin() {
        steps.is_the_home_page();
        steps.click_account();
        steps.insert_email("sibianu.antonia@gmail.com");
        steps.insert_password("wrongPassword");
        steps.click_login_button();
        loginSteps.check_failed_message("Login incorect");
    }
}
