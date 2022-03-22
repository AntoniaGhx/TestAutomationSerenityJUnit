package curs11_12.steps.serenity;

import curs11_12.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class AddProductSteps {
    ProductPage productPage;

    @Step
    public void should_be_added(String definition) {
        assertThat(productPage.getMessageAddedProduct(), hasItem(containsString(definition)));
    }

    @Step
    public void go_to_message(String definition){
        pause(2000);
        should_be_added(definition);
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
