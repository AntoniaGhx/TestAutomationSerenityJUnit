package curs11_12.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ProductPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"productsList\"]/li[1]")
    private WebElementFacade product;

    @FindBy(xpath = "//*[@id=\"pd-buy-button\"]/div/span")
    private WebElementFacade buyButton;

    @FindBy(xpath = "//*[@id=\"acad1eda-55cb-4181-b837-858d637b4d60\"]")
    private WebElementFacade clickMesssageOutside;

    @FindBy(xpath = "//*[@id=\"app-2249f1da-5024-4381-b410-3e62791716ab\"]/div/div/div/div[2]/div/div[2]/div/a/button")
    private WebElementFacade clickGoSeeCart;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div/div[1]/svg")
    private WebElementFacade exitButton;

    @FindBy(xpath = "//*[@id=\"upsellingContinueWithShopping\"]")
    private WebElementFacade continueButton;

    public void click_perfume() {
        pageDownBy800();
        pause(1000);
        product.click();
    }

    public void click_buy_button() {
        pageDownBy300();
        pause(1000);
        buyButton.click();
        pause(3000);
    }

    public void click_on_message_outside() {
        clickMesssageOutside.click();
    }

    public void click_go_see_cart() {
        clickGoSeeCart.click();
    }

    public void click_exit_button() {
        exitButton.click();
    }

    public void continue_button() {
        continueButton.waitUntilClickable();
        continueButton.click();
    }

    public List<String> getMessageAddedProduct() {
        WebElementFacade definitionList = find(By.tagName("div"));
        List<String> l = definitionList.findElements(By.xpath("//*[@id=\"col-content\"]/h1")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
        System.out.println(l+" "+l.size());
        return l;
    }

    public void pageDownBy800(){
        JavascriptExecutor jsExecutor =(JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,800)", "");
        // jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void pageDownBy300(){
        JavascriptExecutor jsExecutor =(JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,300)", "");
        // jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void pageUpBy300(){
        JavascriptExecutor jsExecutor =(JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,-300)", "");
        // jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
