package Steps;

import Pages.AuthenticationPageObject;
import Pages.CustomerServicePageObject;
import Pages.IndexPageObject;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioStore {
    String actor;

    IndexPageObject indexPageObject;
    CustomerServicePageObject customerServicePageObject;
    AuthenticationPageObject authenticationPageObject;

    @Step("#actor goes to MyStore")
    public void goToStore() {
        indexPageObject.open();
    }

    @Step("#actor searchs products that contain {0}")
    public void searchAProduct(String product) {
        indexPageObject.insertProductToSearch(product);
        indexPageObject.searchAProduct();

    }

    @Step("#actor could see results that contains the word {0}")
    public void shouldSeeAProduct(String expectedProduct) {
        List<String> results= indexPageObject.productsReturned();
        System.out.println(results);
        System.out.println(expectedProduct);
        assertThat(results, Matchers.everyItem(containsString(expectedProduct)));
    }

    @Step("#actor go to ContactUs page")
    public void goToContactUs() {
        indexPageObject.goToContactUs();
    }

    @Step("#actor make a message, with the following data: " +
            "\n Subject Heading: {0} " +
            "\n Email address: {1}" +
            "\n Order reference: {2}" +
            "\n Message: {3}")
    public void sendtAMessage(String value, String email, String order, String message) {
        customerServicePageObject.insertAMessage(value,email,order,message);
    }

    /*@Step("#actor upload a file")
    public void uploadFile(String path) throws InterruptedException {
        customerServicePageObject.uploadFile(path);
    }*/


    @Step("#actor should see the following message: {0}")
    public void shouldSeeSuccefullConfirmation(String confirmation) {
        //creo una variable para asignarle el mensaje que devuelve la página
        String result=customerServicePageObject.messageReturned();
        System.out.println(confirmation);
        System.out.println(result);

        //comparo que sean iguales
        assertThat(result, Matchers.equalTo(confirmation));
    }

    @Step("#actor got to SignIn page")
    public void goToSignIn() {
        indexPageObject.goToSignInPage();
    }

    @Step("#actor signIn without email")
    public void signInWithoutEmail() {
        authenticationPageObject.signInWithoutEmail();
    }

    @Step("#actor should see an error message")
    public void shouldSeeAnErrorMessage(String msgExpected) {
        String result=authenticationPageObject.messageReturned();
        System.out.println(msgExpected);
        System.out.println(result);
        assertThat(result,Matchers.equalTo(msgExpected));

    }
}
