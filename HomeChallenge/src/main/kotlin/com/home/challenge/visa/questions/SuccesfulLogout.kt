package com.home.challenge.visa.questions

import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject

open class SuccesfulLogout :Question<Boolean> {
    companion object {
        fun user(): SuccesfulLogout {
            return SuccesfulLogout()
        }
    }

    @Subject("User validates asuccesful logout")
    override fun answeredBy(actor: Actor): Boolean {
        return GeneralConstants.SUCCESSFUL_LOGOUT_MESSAGE == SerenitySession.get<String>(GeneralConstants.SUCCESSFUL_LOGOUT_MESSAGE_KEY)
    }
}