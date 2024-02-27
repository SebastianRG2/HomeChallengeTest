package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.user.CreateUser
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class Create : Task {

    companion object {
        fun userService(): Create {
            return Tasks.instrumented(Create::class.java)
        }
    }

    @Step("User creates in pet store")
    override fun <T : Actor> performAs(actor: T) {
        CreateUser.inPetStore()
    }
}