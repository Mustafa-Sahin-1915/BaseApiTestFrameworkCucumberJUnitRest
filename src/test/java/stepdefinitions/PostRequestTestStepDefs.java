package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PostRequestTestStepDefs {
    protected RequestSpecification spec;
    private final static String BASE_API_URL = "https://generator.swagger.io/api";
    private Response response;

    @Given("As a user generates setup for api call for post")
    public void as_a_user_generates_setup_for_api_call_for_post() {
        spec = new RequestSpecBuilder().
                setBaseUri(BASE_API_URL).
                build();
        spec.header("Accept", ContentType.JSON);
        spec.contentType(ContentType.JSON);
    }
    @Given("As a user on online generator swagger api base for post")
    public void as_a_user_on_online_generator_swagger_api_base_for_post() {
        spec.pathParams("first", "gen","second", "clients");
    }
    @When("As a user send POST request to generate a client library for {string}")
    public void as_a_user_send_post_request_to_generate_a_client_library_for(String language) {
        //spec.pathParam("language", language );
        //body should be ready
/*
   String payload="{"+
 "\"spec\":{}," +
  "\"options\": {"+
    "\"additionalProp1\": \"string\","+
    "\"additionalProp2\": \"string\","+
    "\"additionalProp3\": \"string\""+
  "},"+
  "\"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\","+
  "\"authorizationValue\": {" +
   " \"value\": \"string\","+
   " \"type\": \"string\","+
   " \"keyName\": \"string\","+
   " \"urlMatcher\": {}"+
  "},"+
  "\"usingFlattenSpec\": true,"+
  "\"securityDefinition\": {"+
    "\"type\": \"string\","+
    "\"description\": \"string\""+
  "}"+
"}";
   */
        String payload="{ \"swaggerUrl\":\"http://petstore.swagger.io/v2/swagger.json\"}";
        System.out.println(payload);
        response = given()
                .spec(spec)
                .body(payload).log().all()
                .when()
                .post("/{first}/{second}/"+language);
    }
    @Then("As a user verify that status code is {int} success for post")
    public void as_a_user_verify_that_status_code_is_success_for_post(int statusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, actualStatusCode);
    }
}
