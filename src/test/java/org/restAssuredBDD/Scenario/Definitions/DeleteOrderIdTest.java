package org.restAssuredBDD.Scenario.Definitions;

import org.restAssuredBDD.utils.ApiObjects.Order;
import net.thucydides.core.annotations.Steps;
import org.restAssuredBDD.Steps.StepsLogicRestAPI;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class DeleteOrderIdTest{

    @Steps
    StepsLogicRestAPI restAPI;
    Order order = new Order(8);

    @Given("I Sent delete response")
    public void givenISentDeleteResponse(){
        restAPI = new StepsLogicRestAPI();
    }

    @When("I sent the order id")
    public void whenISentTheOrderId(){
        restAPI.deletePetOrderId(order.id());
    }

    @Then("I get status code 200")
    public void thenIGetStatusCode(){
        Assert.assertEquals(200, restAPI.getResponse().getStatusCode());
    }
    }