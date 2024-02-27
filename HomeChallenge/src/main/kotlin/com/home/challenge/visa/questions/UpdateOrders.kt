package com.home.challenge.visa.questions

import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject
import net.serenitybdd.screenplay.ensure.that

open class UpdateOrders : Question<Boolean> {
    companion object {
        fun succesful(): UpdateOrders {
            return UpdateOrders()
        }
    }

    @Subject("User validates a succesful orders")
    override fun answeredBy(actor: Actor): Boolean {
        actor.attemptsTo(
            that(SerenitySession.get<Int>(GeneralConstants.FINAL_CHECK_INVENTORY_STORE)).isGreaterThan(
                SerenitySession.get<Int>(
                    GeneralConstants.INITIAL_CHECK_INVENTORY_STORE
                )
            )
        )
        return true
    }
}