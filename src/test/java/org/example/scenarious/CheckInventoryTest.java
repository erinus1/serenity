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
public class CheckInventoryTest extends Steps {

    StepsLogicRestAPI restAPI;
    @Given("Get request to inventory pet_Status end point")
    public void givenGetRequestToInventoryPetstatusEndPoint(){
        restAPI = new StepsLogicRestAPI();
    }

    @When("I sent request to the pet_Status end point")
    public void whenISentRequestToThePetstatusEndPoint() throws Throwable{
        restAPI.callInventory();
    }

    @Then("I get responce status code 200")
    public void thenIGetResponceStatusCode(){
       Assert.assertEquals(200, restAPI.getResponse().getStatusCode());
    }
}