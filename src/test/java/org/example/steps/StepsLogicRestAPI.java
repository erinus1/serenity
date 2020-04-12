package org.example.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.example.utils.EndPoints;

public class StepsLogicRestAPI {

    RequestSpecification spec;
    Response resp;

    public StepsLogicRestAPI() {
        spec = RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
//                .log().uri()
//                .log().body()
                .baseUri(EndPoints.URL);
    }

    @Step
    public void callInventory() {
        resp = spec
            .when()
            .get(EndPoints.pet_Status)
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
//
//    @Step
//    public Response getPetOrderId(int id) {
//        return createBaseSpec()
//                .pathParam("orderId", id)
//                .when()
//                .get(EndPoints.pet_OrderId)
//                .then()
//                .extract()
//                .response();
//    }
//
//    @Step
//    public Response deletePetOrderId(int id) {
//        return createBaseSpec()
//                .baseUri(EndPoints.URL)
//                .pathParam("orderId", id)
//                .when()
//                .delete(EndPoints.pet_OrderId)
//                .then()
//                .extract()
//                .response();
//    }

    public Response getResponse() {
        return resp;
    }
}