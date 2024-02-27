package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.user.LogoutUser
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class Logout : Task {

    companion object {
        fun userInPetStore(): Logout {
            return Tasks.instrumented(Logout::class.java)
        }
    }

    @Step("In the pet store a user logs out")
    override fun <T : Actor> performAs(actor: T) {
        val message = LogoutUser.inPetStoreService()
        SerenitySession.set(GeneralConstants.SUCCESSFUL_LOGOUT_MESSAGE_KEY, message)
    }
}