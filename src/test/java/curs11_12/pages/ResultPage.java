package curs11_12.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.stream.Collectors;


public class ResultPage extends PageObject {

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.xpath("//*[@id=\"main\"]/div[1]/div[5]/div/div[2]"));
        List<String> l= definitionList.findElements(By.xpath("//*[@id=\"ca-uid-11-ca-box-0\"]/p[1]")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
        System.out.println(l+" "+l.size());
        return l;
    }


    public void pageDown(){
        JavascriptExecutor jsExecutor =(JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,800)", "");
       // jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void pageUp(){
        JavascriptExecutor jsExecutor =(JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,-500)", "");
        // jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}