package curs11_12.steps.serenity;

import curs11_12.pages.LoginPage;
import curs11_12.pages.ResultPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void should_be_logged_in(String definition) {
        assertThat(loginPage.getAccountUsername(), hasItem(containsString(definition)));
    }

    @Step
    public void should_fail_login(String definition) {
        assertThat(loginPage.getErrorMessage(), hasItem(containsString(definition)));
    }

    @Step
    public void go_to_account(String definition){
        pause(2000);
        should_be_logged_in(definition);
    }

    @Step
    public void check_failed_message(String definition){
        pause(1000);
        should_fail_login(definition);
    }


    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
