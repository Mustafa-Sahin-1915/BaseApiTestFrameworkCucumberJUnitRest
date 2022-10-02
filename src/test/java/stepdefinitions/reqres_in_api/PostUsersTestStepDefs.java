package stepdefinitions.reqres_in_api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.UserOfReqresIn;
import utilities.ApiUtil;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostUsersTestStepDefs {
    private RequestSpecification spec;
    private Response response;

    UserOfReqresIn user;

    @Given("create user pojo with name as {string} and email as {string}")
    public void create_user_pojo_with_name_as_and_email_as(String name, String email) {
       user = new UserOfReqresIn(name, email);
        spec = ApiUtil.getSpec();
        spec.pathParam("first", "users" );
        spec.contentType(ContentType.JSON);
        spec.accept(ContentType.JSON);
    }
    @When("call POST request to create user")
    public void call_post_request_to_create_user() {
        spec = ApiUtil.getSpec();
        response = given().log().all()
                .spec(spec)
                .body(user)
                .when()
                .post("/{first}");
        ApiUtil.setResponse(response);
    }
    @Then("verify that response body name is {string}")
    public void verify_that_response_body_name_is(String name) {
        response = ApiUtil.getResponse();
        response.then().log().all().body("name",equalTo(name));
    }

    @Then("verify that response body id is {int}")
    public void verify_that_response_body_id_is(Integer id) {
        response = ApiUtil.getResponse();
        response.then().body("id",equalTo(id));
    }
    @Then("verify that response body email is {string}")
    public void verify_that_response_body_email_is(String email) {
        response = ApiUtil.getResponse();
        response.then().body("email",equalTo(email));
    }

}
