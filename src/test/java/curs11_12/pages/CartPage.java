package curs11_12.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends PageObject {

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div[1]/div/table/tbody/tr[1]/td[6]/div/form/button")
    private WebElementFacade deleteItem;

    public void clickDelete() {
        WebElementFacade aaa = deleteItem;
        deleteItem.waitUntilPresent();
        deleteItem.click();
    }

    public List<Boolean> getMessageDeletedProduct() {
        WebElementFacade definitionList = find(By.tagName("div"));
        List<Boolean> l = definitionList.findElements(By.xpath("//*[@id=\"pageHeader\"]/div[2]/div[2]")).stream()
                .map( element -> element.isDisplayed() )
                .collect(Collectors.toList());
        System.out.println(l+" "+l.size());
        return l;
    }
}
