package org.example.scenarious;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.example.steps.StepsLogicRestAPI;
import org.example.utils.Order;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
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