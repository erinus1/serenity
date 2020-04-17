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
public class DeleteOrderIdTest extends Steps {

    StepsLogicRestAPI restAPI;
    OrderInformation order = new OrderInformation(8);

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