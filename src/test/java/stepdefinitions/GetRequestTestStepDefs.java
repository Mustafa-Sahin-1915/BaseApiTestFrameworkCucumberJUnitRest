package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetRequestTestStepDefs {
    protected RequestSpecification spec;
    private final static String BASE_API_URL = "https://generator.swagger.io/api";
    private Response response;

    @Given("As a user generates setup for api call")
    public void as_a_user_generates_setup_for_api_call() {
        spec = new RequestSpecBuilder().
                setBaseUri(BASE_API_URL).
                build();
        spec.header("Accept", ContentType.JSON);
        spec.contentType(ContentType.JSON);
    }
    @Given("As a user on online generator swagger api base")
    public void as_a_user_on_online_generator_swagger_api_base() {
        spec.pathParams("first", "gen","second", "clients");
    }
    @When("As a user send GET request to get languages supported by client generator")
    public void as_a_user_send_get_request_to_get_languages_supported_by_client_generator() {
      response = given()
                .spec(spec)
                .get("/{first}/{second}");
    }
    @Then("As a user verify that status code is {int} success")
    public void as_a_user_verify_that_status_code_is_success(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }
}
