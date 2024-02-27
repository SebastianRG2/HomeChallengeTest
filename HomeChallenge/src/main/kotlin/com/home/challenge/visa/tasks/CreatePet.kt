package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.pet.PetCreation
import com.home.challenge.visa.models.Pet
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class CreatePet(private val id : Int) : Task{

    companion object {
        fun inStore(id : Int): CreatePet {
            return Tasks.instrumented(CreatePet::class.java, id)
        }
    }

    @Step("Pet creates into to the store")
    override fun <T : Actor> performAs(actor: T) {
        val petCreate : Pet = PetCreation.inStore(id)
        SerenitySession.set(GeneralConstants.PET_CREATE_MODEL_KEY,petCreate)
    }
}