package org.restAssuredBDD.scenarious;

import net.thucydides.core.annotations.Steps;
import org.restAssuredBDD.steps.StepsLogicRestAPI;
import org.restAssuredBDD.utils.Order;
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