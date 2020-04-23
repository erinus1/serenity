package org.example.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.utils.*;

public class StepsLogicRestAPI extends ScenarioSteps {
    RequestSpecification spec;
    Response resp;

    public StepsLogicRestAPI() {
        spec = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(EnvironmentPropertyLoader.getProperty("url.base"));
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