package Tests;

import Steps.UsuarioStore;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenIDontInsertAnEmail {

    @Steps
    UsuarioStore anto;

    @Managed
    WebDriver driver;

    @Test
    public void dontInsertEmail()
    {
        anto.goToStore();
        anto.goToSignIn();
        anto.signInWithoutEmail();
        anto.shouldSeeAnErrorMessage("An email address required.");
    }
}
