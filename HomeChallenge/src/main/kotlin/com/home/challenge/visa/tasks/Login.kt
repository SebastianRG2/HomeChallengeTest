package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.user.LoginUser
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class Login : Task {

    companion object {
        fun userInPetStore(): Login {
            return Tasks.instrumented(Login::class.java)
        }
    }

    @Step("In the pet store a user logs in")
    override fun <T : Actor> performAs(actor: T) {
        val message = LoginUser.inPetStoreService()
        SerenitySession.set(GeneralConstants.SUCCESSFUL_LOGIN_MESSAGE_KEY, message)
    }
}