package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.pet.PetDelete
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class DeletePet(private val id: Int) : Task {

    companion object {
        fun byId(id: Int): DeletePet {
            return Tasks.instrumented(DeletePet::class.java, id)
        }
    }

    @Step("User deletes a pet by id")
    override fun <T : Actor> performAs(actor: T) {
        val message = PetDelete.byId(id)
        print(message)
        SerenitySession.set(GeneralConstants.DELETE_PET_KEY, message)
    }
}