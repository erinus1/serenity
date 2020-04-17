package org.example.scenarious;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.StepsLogicRestAPI;
import org.example.utils.OrderInformation;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class NewOrderTest extends Steps {

    StepsLogicRestAPI restAPI;
    OrderInformation order;

    @Given("Prepare request for an order")
    public void givenPrepareRequestForAnOrder(){
        order = new OrderInformation(8).status(OrderInformation.STATUS.APPROVED);
        restAPI = new StepsLogicRestAPI();
    }

    @When("I sent a new order")
    public void whenISentANewOrder(){
        restAPI.sendOrder(order.toString());
    }

    @Then("I get the response body with data which has been sent before")
    public void thenIGetTheResponseBodyWithDataWhichHasBeenSentBefore(){
        OrderInformation responsedOrder = new OrderInformation(
                (int) restAPI.getResponse().jsonPath().get("id"),
                (int) restAPI.getResponse().jsonPath().get("quantity"),
                (String) restAPI.getResponse().jsonPath().get("shipDate"),
                OrderInformation.STATUS.valueOf(((String) restAPI.getResponse().jsonPath().get("status")).toUpperCase()),
                (boolean) restAPI.getResponse().jsonPath().get("complete")
        );
        Assert.assertTrue(order.equals(responsedOrder));
    }
}