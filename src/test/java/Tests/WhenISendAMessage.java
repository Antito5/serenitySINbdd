package Tests;

import Steps.UsuarioStore;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class WhenISendAMessage {

    @Steps
    UsuarioStore anto;

    @Managed
    WebDriver driver;

    @Test
    public void contact() throws InterruptedException {
        anto.goToStore();
        anto.goToContactUs();
        anto.sendtAMessage("Customer service","anto_m5@hotmail.com", "2","Hello world");
        anto.shouldSeeSuccefullConfirmation("Your message has been successfully sent to our team.");

    }

}
