package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.pet.PetFind
import com.home.challenge.visa.models.Pet
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class FindPet(private val id: Int) : Task {

    companion object {
        fun byId(id: Int): FindPet {
            return Tasks.instrumented(FindPet::class.java, id)
        }
    }

    @Step("User finds for id register about pet in store")
    override fun <T : Actor> performAs(actor: T) {
        val petFind: Pet = PetFind.byId(id)
        SerenitySession.set(GeneralConstants.PET_FIND_MODEL_KEY, petFind)
    }
}