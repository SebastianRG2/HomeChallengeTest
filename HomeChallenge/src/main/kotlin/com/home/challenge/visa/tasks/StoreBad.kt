package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.store.StoreInventoryBad
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class StoreBad : Task {

    companion object {
        fun input(): StoreBad {
            return Tasks.instrumented(StoreBad::class.java)
        }
    }
    @Step("User sends a bad request")
    override fun <T : Actor> performAs(actor: T) {
        val badInputMessagge = StoreInventoryBad.requestInput()
        SerenitySession.set(GeneralConstants.STORE_BAD_INPUT_KEY,badInputMessagge)
    }
}