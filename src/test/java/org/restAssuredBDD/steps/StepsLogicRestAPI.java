package org.restAssuredBDD.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.restAssuredBDD.utils.EndPoints;
import org.restAssuredBDD.utils.EnvironmentPropertyLoader;

public class StepsLogicRestAPI extends ScenarioSteps {
    RequestSpecification spec;
    Response resp;

    public StepsLogicRestAPI() {
        String baseURL = EnvironmentPropertyLoader.getProperty("url.base");

        spec = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(baseURL);
    }

    @Step
    public void callInventory() {
        resp = spec
            .when()
            .get(EnvironmentPropertyLoader.getProperty("endpoint.inventory.get"))
            .then()
            .extract()
            .response();
    }

    @Step
    public void sendOrder(String body) {
        resp = spec
                .body(body)
                .post(EndPoints.new_OrderPet);
    }

    @Step
    public void getPetOrderId(int id) {
        resp = spec
                .pathParam("orderId", id)
                .when()
                .get(EndPoints.pet_OrderId)
                .then()
                .extract()
                .response();
    }

    @Step
    public void deletePetOrderId(int id) {
        resp = spec
                .baseUri(EndPoints.URL)
                .pathParam("orderId", id)
                .when()
                .delete(EndPoints.pet_OrderId)
                .then()
                .extract()
                .response();
    }

    public Response getResponse() {
        return resp;
    }
}