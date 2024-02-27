package com.home.challenge.visa.questions

import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Question
import net.serenitybdd.screenplay.annotations.Subject

open class SuccesfulLogin : Question<Boolean> {
    companion object {
        fun user(): SuccesfulLogin {
            return SuccesfulLogin()
        }
    }

    @Subject("User validate a successful login")
    override fun answeredBy(actor: Actor): Boolean {
        val patron = Regex("[0-9: ]")
        val message = patron.replace(SerenitySession.get<String>(GeneralConstants.SUCCESSFUL_LOGIN_MESSAGE_KEY), "")
        return GeneralConstants.SUCCESSFUL_LOGIN_MESSAGE == message
    }
}