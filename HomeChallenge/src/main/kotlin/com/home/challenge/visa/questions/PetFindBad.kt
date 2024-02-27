package com.home.challenge.visa.questions

import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.ensure.that

open class PetFindBad : Question<Boolean> {
    companion object {
        fun byId(): PetFindBad {
            return PetFindBad()
        }
    }

    @Subject("User validates bad request message")
    override fun answeredBy(actor: Actor): Boolean {
        actor.attemptsTo(
            that(SerenitySession.get<String>(GeneralConstants.PET_FIND_BAD_REQUEST_KEY)).isEqualTo(
                GeneralConstants.PET_FIND_BAD_REQUEST_MESSAGE
            )
        )
        return true
    }
}