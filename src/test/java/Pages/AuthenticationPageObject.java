package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://automationpractice.com")
public class AuthenticationPageObject extends PageObject {

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    WebElementFacade btnSignIn;

    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElementFacade lblMessage;

    public void signInWithoutEmail() { btnSignIn.click(); }

    public String messageReturned() {
        return lblMessage.getText();
    }
}
