package com.home.challenge.visa.questions

import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.ensure.that

open class StoreInventoryBad : Question<Boolean> {
    companion object {
        fun input(): StoreInventoryBad {
            return StoreInventoryBad()
        }
    }

    @Subject("User validates a bad input in store")
    override fun answeredBy(actor: Actor): Boolean {
        actor.attemptsTo(
            that(SerenitySession.get<String>(GeneralConstants.STORE_BAD_INPUT_KEY)).isEqualTo(
                GeneralConstants.STORE_BAD_INPUT_MESSAGE
            )
        )
        return true
    }
}