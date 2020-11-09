package org.restAssuredBDD.Scenario.Definitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.restAssuredBDD.Steps.StepsLogicRestAPI;

public class CheckInventoryTest {

    @Steps
    StepsLogicRestAPI restAPI;

        @Given("Get request to inventory end point")
        public void givenGetRequestToInventoryEndPoint(){
        restAPI = new StepsLogicRestAPI();
        }

        @When("I sent request to the petStatus end point")
        public void whenISentRequestToThePetstatusEndPoint(){
            restAPI.callInventory();
        }

        @Then("I get responce status code 200")
        public void thenIGetResponceStatusCode () {
            Assert.assertEquals(200, restAPI.getResponse().getStatusCode());
        }
    }