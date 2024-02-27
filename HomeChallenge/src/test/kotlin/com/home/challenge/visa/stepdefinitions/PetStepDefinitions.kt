package com.home.challenge.visa.stepdefinitions

import com.home.challenge.visa.questions.PetCreation
import com.home.challenge.visa.questions.PetDelete
import com.home.challenge.visa.questions.PetFindBad
import com.home.challenge.visa.tasks.CreatePet
import com.home.challenge.visa.tasks.DeletePet
import com.home.challenge.visa.tasks.FindPet
import com.home.challenge.visa.tasks.FindPetBad
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.GivenWhenThen
import net.serenitybdd.screenplay.actors.OnStage

class PetStepDefinitions {

    @When("the user creates a new pet to the store with new id {int}")
    fun createToPetToTheStore(id: Int) {
        OnStage.withCurrentActor(CreatePet.inStore(id))
    }

    @When("the user obtains for id {int} information about the created pet")
    fun userOtainInformationForId(id: Int) {
        OnStage.withCurrentActor(FindPet.byId(id))
    }

    @When("the user delete new pet for same id {int}")
    fun userDeleteNewPetInStore(id: Int) {
        OnStage.withCurrentActor(DeletePet.byId(id))
    }

    @When("the user obtains for id {int} bad information about pet")
    fun userObtainBadInformationById(id: Int) {
        OnStage.withCurrentActor(FindPetBad.byId(id))
    }

    @Then("he will visualize its correct creation")
    fun userVisualizeCorrectPetCreation() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(PetCreation.inStore()))
    }

    @Then("he will visualize a delete message")
    fun userVisualizeCorrectDeletePet() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(PetDelete.inStore()))
    }

    @Then("he will visualize a error message")
    fun userVisualizeErrorMessage() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(PetFindBad.byId()))
    }
}