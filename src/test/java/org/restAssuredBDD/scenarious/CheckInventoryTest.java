package org.restAssuredBDD.scenarious;

import net.thucydides.core.annotations.Steps;
import org.restAssuredBDD.steps.StepsLogicRestAPI;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class CheckInventoryTest {

    @Steps
    StepsLogicRestAPI restAPI;

        @Given("Get request to inventory pet_Status end point")
        public void givenGetRequestToInventoryPetstatusEndPoint () {
            restAPI = new StepsLogicRestAPI();
        }

        @When("I sent request to the pet_Status end point")
        public void whenISentRequestToThePetstatusEndPoint (){
            restAPI.callInventory();
        }

        @Then("I get responce status code 200")
        public void thenIGetResponceStatusCode () {
            Assert.assertEquals(200, restAPI.getResponse().getStatusCode());
        }
    }