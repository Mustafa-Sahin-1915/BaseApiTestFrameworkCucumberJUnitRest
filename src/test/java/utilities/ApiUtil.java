package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiUtil {
    private static String baseURI;
    private static String basePath;
    private static RequestSpecification spec;
    private static Response response;

    public static void setupSpec(){
        if (spec==null){
            spec = (new RequestSpecBuilder())
                    .setBaseUri(baseURI)
                    .setBasePath(basePath).build();
        }
    }
    public static RequestSpecification getSpec(){
        return spec;
    }
    public static Response getResponse(){
        return response;
    }

    public static void setResponse(Response response) {
        ApiUtil.response = response;
    }

    public static String getBaseURI() {
        return baseURI;
    }

    public static void setBaseURI(String baseURI) {
        ApiUtil.baseURI = baseURI;
    }

    public static String getBasePath() {
        return basePath;
    }

    public static void setBasePath(String basePath) {
        ApiUtil.basePath = basePath;
    }
}
