package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.store.StoreInventory
import com.home.challenge.visa.utils.SerenitySession
import com.home.challenge.visa.utils.constants.GeneralConstants
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class CheckGeneral (private val status : String): Task{
    companion object {
        fun stateInventory(status : String): CheckGeneral {
            return Tasks.instrumented(CheckGeneral::class.java, status)
        }
    }

    @Step("User checks a general state inventory about orders")
    override fun <T : Actor> performAs(actor: T) {
        val numberOrdersState : Int = StoreInventory.checkStatusIventory(status)
        SerenitySession.set(GeneralConstants.INITIAL_CHECK_INVENTORY_STORE,numberOrdersState)
    }
}