package com.home.challenge.visa.questions

import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.ensure.that

open class PetDelete : Question<Boolean> {
    companion object {
        fun inStore(): PetDelete {
            return PetDelete()
        }
    }

    @Subject("User validates a pet delete successful")
    override fun answeredBy(actor: Actor): Boolean {
        actor.attemptsTo(
            that(GeneralConstants.DELETE_PET_MESSAGE).isEqualTo(SerenitySession.get(GeneralConstants.DELETE_PET_KEY))
        )

        return true
    }

}