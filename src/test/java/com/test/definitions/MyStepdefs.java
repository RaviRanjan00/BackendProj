package com.test.definitions;

import com.test.steps.javaSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.Assertions;
@Slf4j
public class MyStepdefs {

    javaSteps js =  new javaSteps();

    @Given("Send a get request to url {string}")
    public void sendAGetRequestToUrl(String url) {
        Serenity.setSessionVariable("endpoint").to(url);
    }

    @And("set username as {string} in body")
    public void setUsernameAsInBody(String userName) {
        js.sendPost(Serenity.sessionVariableCalled("endpoint"), userName);
    }

    @Then("check response {int}")
    public void checkResponse(int responseCode) {
        Response res = Serenity.sessionVariableCalled("response");
        int status = res.then().extract().statusCode();
        Assertions.assertThat(responseCode).isEqualTo(status);
    }

    @Then("validate the response where username as {string}")
    public void validateTheResponseWhereUsernameAs(String username) {
        js.responseValidation(username);
    }
}
