package org.restAssuredBDD.Scenario.Definitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.restAssuredBDD.Steps.StepsLogicRestAPI;
import org.restAssuredBDD.utils.ApiObjects.Order;

public class NewOrderTest {

    @Steps
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
        Order responsedOrder = new Order(
                (int) restAPI.getResponse().jsonPath().get("id"),
                (int) restAPI.getResponse().jsonPath().get("quantity"),
                (String) restAPI.getResponse().jsonPath().get("shipDate"),
                Order.STATUS.valueOf(((String) restAPI.getResponse().jsonPath().get("status")).toUpperCase()),
                (boolean) restAPI.getResponse().jsonPath().get("complete")
        );
        Assert.assertTrue(order.equals(responsedOrder));
    }
}