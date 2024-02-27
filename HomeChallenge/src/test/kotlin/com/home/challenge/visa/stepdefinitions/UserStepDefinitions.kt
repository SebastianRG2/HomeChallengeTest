package com.home.challenge.visa.stepdefinitions

import com.home.challenge.visa.questions.SuccesfulLogin
import com.home.challenge.visa.questions.SuccesfulLogout
import com.home.challenge.visa.tasks.Create
import com.home.challenge.visa.tasks.Login
import com.home.challenge.visa.tasks.Logout
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.screenplay.GivenWhenThen
import net.serenitybdd.screenplay.actors.OnStage

class UserStepDefinitions {
    @Given("that the user register")
    fun userCreateNewCredentials() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Create.userService())
    }

    @When("the user enters the credentiales")
    fun userEnterTheCredentialInLoginOption() {
        OnStage.withCurrentActor(Login.userInPetStore())
    }

    @When("the user logout")
    fun userLogout() {
        OnStage.withCurrentActor(Logout.userInPetStore())
    }

    @Then("the user should see their correct login")
    fun userSeeCorrectLogin() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(SuccesfulLogin.user()))
    }

    @Then("he see the message logout")
    fun seeTheMessageLogout() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat<Boolean>(SuccesfulLogout.user()))
    }
}