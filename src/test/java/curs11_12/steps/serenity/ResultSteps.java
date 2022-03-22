package curs11_12.steps.serenity;

import curs11_12.pages.ResultPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class ResultSteps {

    ResultPage resultPage;

    @Step
    public void should_see_definition(String definition) {
        assertThat(resultPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void go_to_definition(String definition){
        resultPage.pageDown();
        pause(4000);
        should_see_definition(definition);
        pause(4000);
        resultPage.pageUp();
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}