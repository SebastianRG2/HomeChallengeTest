package com.home.challenge.visa.stepdefinitions


import com.home.challenge.visa.questions.StoreInventoryBad
import com.home.challenge.visa.questions.UpdateOrders
import com.home.challenge.visa.tasks.CheckFinal
import com.home.challenge.visa.tasks.CheckGeneral
import com.home.challenge.visa.tasks.OrderInventory
import com.home.challenge.visa.tasks.StoreBad
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.GivenWhenThen
import net.serenitybdd.screenplay.actors.OnStage

class StoreStepDefinitions {

    @Given("the user consults the inventory with status {string}")
    fun userConsultsIventory(status: String) {
        OnStage.theActorInTheSpotlight().wasAbleTo(CheckGeneral.stateInventory(status))
    }

    @When("the user places another order with status {string}")
    fun userPlacerAnotherOrdenWithAStatus(status: String) {
        OnStage.withCurrentActor(
            OrderInventory.forPet(status),
            CheckFinal.stateInventory(status)
        )
    }

    @When("the user send bad input for place order")
    fun userSendBadInput() {
        OnStage.withCurrentActor(StoreBad.input())
    }

    @Then("the user should see the increase of orders in the inventory")
    fun userSeeTheIncreaseOfOrdersInInventory() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(UpdateOrders.succesful()))
    }

    @Then("the user should see the bad input message")
    fun userSeeTheBadInputMessage() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(StoreInventoryBad.input()))
    }
}