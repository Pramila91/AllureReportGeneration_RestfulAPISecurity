package org.exampleSeleniumFrameworkProjectVWO.SecurityTesting;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }
}
