package com.home.challenge.visa.tasks

import com.home.challenge.visa.integrations.requesters.store.StoreInventory
import net.serenitybdd.annotations.Step
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.Task
import net.serenitybdd.screenplay.Tasks

open class OrderInventory(private val status : String) : Task{

    companion object {
        fun forPet(status : String): OrderInventory {
            return Tasks.instrumented(OrderInventory::class.java,status)
        }
    }

    @Step("User orders inventary for status")
    override fun <T : Actor> performAs(actor: T) {
        StoreInventory.placeNewOrderForPet(status)
    }
}