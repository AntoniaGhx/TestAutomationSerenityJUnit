package curs11_12.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends PageObject {

    @FindBy(name = "logon_login")
    private WebElementFacade loginEmail;

    @FindBy(name = "logon_password")
    private WebElementFacade loginPassword;

    @FindBy(id = "submitLogin")
    private WebElementFacade loginButton;

    public void enterEmail(String email) {
        loginEmail.clear();
        loginEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        loginPassword.clear();
        loginPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public List<String> getAccountUsername() {
        WebElementFacade definitionList = find(By.tagName("div"));
        List<String> l = definitionList.findElements(By.xpath("//*[@id=\"col-content\"]/div[1]/div[1]/div[1]")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
        System.out.println(l + " " + l.size());
        return l;
    }

    public List<String> getErrorMessage() {
        WebElementFacade definitionList = find(By.tagName("p"));
        List<String> l = definitionList.findElements(By.xpath("//*[@id=\"loginCaptcha\"]/fieldset/p[1]/span/span[1]")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
        System.out.println(l + " " + l.size());
        return l;
    }



}
