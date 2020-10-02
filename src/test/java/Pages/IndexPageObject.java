package Pages;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://automationpractice.com")
public class IndexPageObject extends PageObject {

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElementFacade inputSearch;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElementFacade btnSearch;

    @FindBy(xpath = "//div[@id='contact-link']")
    WebElementFacade btnContactUs;

    @FindBy(xpath = "//a[@class='login']")
    WebElementFacade btnSignIn;

    public void insertProductToSearch(String product) {
        inputSearch.type(product);
    }

    public void searchAProduct() {
        btnSearch.click();
    }

    public List<String> productsReturned() {
        return findAll("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed ')]")
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public void goToContactUs() {
        btnContactUs.click();
    }

    public void goToSignInPage() {
        btnSignIn.click();
    }
}
