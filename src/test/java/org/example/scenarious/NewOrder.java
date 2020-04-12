package org.example.scenarious;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.StepsLogicRestAPI;
import org.example.utils.Order;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class NewOrder extends Steps {

    StepsLogicRestAPI restAPI;
    Order order;

    @Given("Prepare request for an order")
    public void givenPrepareRequestForAnOrder(){
        order = new Order(8).status(Order.STATUS.APPROVED);
        restAPI = new StepsLogicRestAPI();
    }

    @When("I sent a new order")
    public void whenISentANewOrder(){
        restAPI.sendOrder(order.toString());
    }

    @Then("I get the response body with data which has been sent before")
    public void thenIGetTheResponseBodyWithDataWhichHasBeenSentBefore(){
        Assert.assertEquals(order.toString(), restAPI.getResponse().asString());
    }
}
