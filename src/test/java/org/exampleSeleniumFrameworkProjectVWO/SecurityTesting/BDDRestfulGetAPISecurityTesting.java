package org.exampleSeleniumFrameworkProjectVWO.SecurityTesting;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class BDDRestfulGetAPISecurityTesting extends BaseTest{
    //XSS testing
    @Description("Ensures the endpoint /booking/1 is protected against clickjacking and bad path injection by sending a malicious path segment. Expects a 404 Not Found, indicating the server rejects malformed or malicious resource paths.")
    @Test
    public void bdd_getBookingById_shouldReturnErrorforXSS_ScriptingInGetRequest() {
        given()
                .when()
                .get("/booking/<script>alert('XSS')</script>")
                .then()
                .log().all()
                .statusCode(404)
                .body(not(containsString("<script>alert('XSS')</script>")));  //assertThat().statusCode(200);
    }
    //SQL Injection Security Testing
    @Test
    public void bdd_getBookingById_shouldReturnErrorforSQL_InjectionInGetRequest() {
        given()
                .when()
                .get("/booking/id\", \"1 OR 1=1")
                .then()
                .log().all()
                .statusCode(404)  //assertThat().statusCode(200)
                .body(not(containsString("id\", \"1 OR 1=1")));
    }

}
