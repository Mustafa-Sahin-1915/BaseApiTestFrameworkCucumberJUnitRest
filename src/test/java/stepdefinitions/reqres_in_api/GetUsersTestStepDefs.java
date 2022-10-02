package stepdefinitions.reqres_in_api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ApiUtil;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUsersTestStepDefs {
//https://howtodoinjava.com/java/library/rest-assured-tutorial/
    /*
    baseURI:https://reqres.in
    basePath:/api
    HTTP GET /users/2

{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver"
        ...
        ...
    }
}
     */
    private RequestSpecification spec;
    private Response response;
    @Given("setup api {string} and {string}")
    public void setup_api_and(String baseUri, String basePath) {
        ApiUtil.setBaseURI(baseUri);
        ApiUtil.setBasePath(basePath);
        ApiUtil.setupSpec();
    }
    @Given("set {int} to get user info")
    public void set_user_number_to_get_user_info(Integer usernumber) {

        spec= ApiUtil.getSpec();
        spec.pathParam("first", "users");
        spec.pathParam("second",usernumber);
        spec.contentType(ContentType.JSON);
        spec.accept(ContentType.JSON);
    }
    @When("call GET request to get user info")
    public void call_get_request_to_get_user_info() {
        response = given()
                .spec(spec)
                .when().get("/{first}/{second}");
        ApiUtil.setResponse(response);
    }
    @Then("verify that status code is {int}")
    public void verify_that_status_code_is(Integer statusCode) {
        response = ApiUtil.getResponse();
        response.then().statusCode(equalTo(statusCode));
    }
    @Then("verify that response body data id is {int}")
    public void verify_that_response_body_data_id_is(Integer id) {
        response = ApiUtil.getResponse();
        response.then().body("data.id", equalTo(id));
    }
    @Then("verify that response body data email is {string}")
    public void verify_that_response_body_data_email_is(String email) {
        response = ApiUtil.getResponse();
        response.then().body("data.email", equalTo(email));
    }
}
