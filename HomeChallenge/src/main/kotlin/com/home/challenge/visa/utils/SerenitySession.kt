package com.home.challenge.visa.utils

import com.home.challenge.visa.utils.constants.Defaults
import net.serenitybdd.core.Serenity
import net.serenitybdd.screenplay.actors.Cast
import net.serenitybdd.screenplay.actors.OnStage
import net.serenitybdd.screenplay.actors.Stage

object SerenitySession {
    @JvmStatic
    fun createActor(actorName: String? = null) {
        OnStage.setTheStage(Stage(Cast.ofStandardActors()))
        OnStage.theActor(actorName ?: Defaults.ACTOR_NAME)
    }

    @JvmStatic
    fun <T> get(key: String): T {
        return Serenity.sessionVariableCalled(key)
    }

    @JvmStatic
    fun <T> set(key: String, value: T) {
        Serenity.setSessionVariable(key).to(value)
    }
}