package curs11_12.steps.serenity;

import curs11_12.pages.CartPage;
import net.thucydides.core.annotations.Step;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeleteProductSteps {
    CartPage cartPage;

    public void should_be_deleted() {
        assertThat(cartPage.getMessageDeletedProduct(), hasItem(true));
    }
    @Step
    public void go_to_main_page(){
        pause(2000);
        should_be_deleted();
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
