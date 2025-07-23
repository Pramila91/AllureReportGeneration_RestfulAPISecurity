package org.exampleSeleniumFrameworkProjectVWO.SecurityTesting;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDRestfulAPISecurityTesting extends BaseTest {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    @Owner("Pramila")
    @Description("Ensures the endpoint /booking/1 is protected against clickjacking and bad path injection by sending a malicious path segment. Expects a 404 Not Found, indicating the server rejects malformed or malicious resource paths.")

    public void nonBDD_getBookingById_shouldReturnErrorforXSS_ScriptingInGetRequest(){
            System.out.println("Inside Test nonBDD_getBookingById_shouldReturnErrorforXSS_ScriptingInGetRequest ");

        r = RestAssured.given();

        // WHEN
        response = r.when().log().all().get("/booking/<script>alert('XSS')</script>");
        System.out.println("Printing response as string-->");
        System.out.println(response.asString());

        // THEN
        vr = response.then().log().all();
        vr.statusCode(404);

    }
}
