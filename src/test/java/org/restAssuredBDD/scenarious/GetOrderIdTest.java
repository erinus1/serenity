package org.restAssuredBDD.scenarious;

import net.thucydides.core.annotations.Steps;
import org.restAssuredBDD.steps.StepsLogicRestAPI;
import org.restAssuredBDD.utils.Order;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class GetOrderIdTest {

    @Steps
    StepsLogicRestAPI restAPI;
    Order order = new Order(8);

    @Given("Get new order id of created new order")
    public void givenGetNewOrderIdOfCreatedNewOrder(){
            restAPI = new StepsLogicRestAPI();
    }
    @When("I sent an order id")
    public void whenISentAnOrderId(){
        restAPI.getPetOrderId(order.id());
    }

    @Then("I get response of status code 200")
    public void thenIGetResponseOfStatusCode(){
        Assert.assertEquals(200, restAPI.getResponse().getStatusCode());
    }
}