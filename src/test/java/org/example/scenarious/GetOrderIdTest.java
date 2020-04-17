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
public class GetOrderIdTest extends Steps {

    StepsLogicRestAPI restAPI;
    OrderInformation order = new OrderInformation(8);

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