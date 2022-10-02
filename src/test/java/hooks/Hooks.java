package hooks;

import io.cucumber.java.Before;
import utilities.ApiUtil;

public class Hooks {

    @Before(value = "api")
    public void setup(){

    }
}
