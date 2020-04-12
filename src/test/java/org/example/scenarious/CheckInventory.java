package org.example.scenarious;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.StepsLogicRestAPI;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CheckInventory extends Steps {

    StepsLogicRestAPI restAPI;
    @Given("Get request to inventory 'pet_Status' end point")
    public void givenGetRequestToInventoryPetstatusEndPoint(){
        restAPI = new StepsLogicRestAPI();
    }

    @When("I sent request to the 'pet_Status' end point")
    public void whenISentRequestToThePetstatusEndPoint() throws Throwable{
        restAPI.callInventory();
    }

    @Then("I get 'status code 200'")
    public void thenIGetStatusCode() {
       Assert.assertEquals(200, restAPI.getResponse().getStatusCode());
    }



    /*

    @Test(priority = 1)
    public void addOrderId() {
        API_STORE.createPet(order8.toString())
                .then()
                .body("id", Matchers.equalTo(order8.id()))
                .body("status", Matchers.equalTo(order8.status().toString().toLowerCase()))
                .statusCode(200);
    }

    @Test(priority = 2)
    public void getOrderId() {
        API_STORE.getPetOrderId(order8.id())
                .then()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void deleteOrderById() {
        API_STORE.deletePetOrderId(order8.id())
                .then()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void getDeletedOrderId() {
        API_STORE.getPetOrderId(order8.id())
                .then()
                .statusCode(404);
    }

     */
    }