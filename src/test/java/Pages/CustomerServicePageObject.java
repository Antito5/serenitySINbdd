package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerServicePageObject extends PageObject {

    WebDriver driver;

    @FindBy(xpath = "//select[@id='id_contact']")
    WebElementFacade cmbSubject;

    @FindBy(xpath = "//input[@id='email']")
    WebElementFacade inputEmail;

    @FindBy(xpath = "//input[@id='id_order']")
    WebElementFacade inputOrder;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElementFacade txtareaMessage;

    @FindBy(xpath = "//span[contains(text(),'Send')]")
    WebElementFacade btnSend;

    @FindBy(xpath = "//div[@id='uniform-fileUpload']")
    WebElementFacade btnFile;

    @FindBy(xpath = "//span[@class='filename']")
    WebElementFacade inputFile;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElementFacade lblMessage;

    public void insertAMessage(String value, String email, String order, String message) {
        //crear un objeto select para el combo
        Select select=new Select(cmbSubject);

        //seleccionar del combo la opción que le pasamos por parámetro
        select.selectByVisibleText(value);

        //ingresar email,orden y enviar
        inputEmail.type(email);
        inputOrder.type(order);
        txtareaMessage.type(message);
        btnSend.click();
    }

    public void uploadFile(String path) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(inputFile);
        upload(path).to(inputFile);
        //element(inputFile).sendKeys(path);
        //btnFile.click();
       // inputFile.sendKeys(path);

    }


    public String messageReturned()
    { return lblMessage.getText(); }
}
