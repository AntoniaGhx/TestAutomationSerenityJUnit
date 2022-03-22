package curs11_12.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.notino.ro/")
public class DictionaryPage extends PageObject {

    //@FindBy(name="search")
    //@FindBy(id="searchInput")
    //@FindBy(css="#searchInput")
    @FindBy(xpath = "//*[@id=\"pageHeader\"]/div[2]/div[3]/div/input")
    private WebElementFacade searchTerms;

    @FindBy(xpath="//*[@id=\"pageHeader\"]/div[2]/div[3]/div[1]/a")
    private WebElementFacade lookupButton;

    @FindBy(xpath = "//*[@id=\"pageHeader\"]/div[2]/a[1]")
    private WebElementFacade myAccount;

    @FindBy(xpath = "/html/body/nav/div[1]/div[2]/div[4]/a/div")
    private WebElementFacade perfumeProducts;

    @FindBy(xpath = "/html/body")
    private WebElementFacade clickMain;

    @FindBy(xpath = "//*[@id=\"pageHeader\"]/div[2]/div[4]/a")
    private WebElementFacade clickCart;

    public void enter_keywords(String keyword) {
        waitFor(searchTerms);
        //searchTerms.waitUntilVisible();
        //searchTerms.click();
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public void click_myAccount() {
        myAccount.click();
    }

    public void click_perfumeProducts() { perfumeProducts.click(); }

    public void click_on_main() {
        clickMain.click();
    }
    public void click_on_cart() {
        clickCart.waitUntilClickable();
        clickCart.click();
    }

//verify -Dcontext=chrome -Dwebdriver.driver=chrome -f pom.xml
}